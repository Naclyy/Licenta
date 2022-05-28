package com.security.jwt;


import com.google.common.base.Strings;
import com.exceptions.TokenNotTrustedException;
import com.services.InvalidatedTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Slf4j
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    private final SecretKey secretKey;
    private final JwtConfig jwtConfig;
    private final InvalidatedTokenService invalidatedTokenService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager, SecretKey secretKey, JwtConfig jwtConfig, InvalidatedTokenService invalidatedTokenService) {
        super(authenticationManager);
        this.secretKey = secretKey;
        this.jwtConfig = jwtConfig;
        this.invalidatedTokenService = invalidatedTokenService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (Strings.isNullOrEmpty(authorizationHeader) || !authorizationHeader.startsWith(jwtConfig.getTokenPrefix())) {
            log.error("Something went wrong with the Authorization process!!");
            chain.doFilter(request, response);
            return;
        }

        String token = authorizationHeader.replace(jwtConfig.getTokenPrefix(), "");

        if (invalidatedTokenService.checkIfIsInvalid(token)) {
            log.error("Token is invalid! Issue a new one!");
            throw new RuntimeException("Token is invalid! Issue a new one!");
        }

        try {
            Authentication authentication = getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            log.info("Authorization successful! SecurityContext updated with current authentication!");
        } catch (JwtException ex) {
            log.error("JWT token cannot be trusted!");
            throw new TokenNotTrustedException();
        }

        chain.doFilter(request, response);
    }

    private Authentication getAuthentication(String token) throws JwtException {
        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);

        Claims body = claimsJws.getBody();
        String username = body.getSubject();

        var authorities = (List<Map<String, String>>) body.get("authorities");

        Set<SimpleGrantedAuthority> simpleGrantedAuthorities = authorities.stream().map(auth -> new SimpleGrantedAuthority(auth.get("authority"))).collect(Collectors.toSet());

        return new UsernamePasswordAuthenticationToken(username, null, simpleGrantedAuthorities);
    }
}

