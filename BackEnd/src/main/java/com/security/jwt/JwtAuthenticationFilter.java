package com.security.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.exceptions.UnauthorizedAuthenticationException;
import com.entities.dto.Login;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.crypto.SecretKey;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

import static org.springframework.http.HttpHeaders.EXPIRES;

@Slf4j
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private final JwtConfig jwtConfig;
    private final SecretKey secretKey;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager, JwtConfig jwtConfig, SecretKey secretKey) {
        this.authenticationManager = authenticationManager;
        this.jwtConfig = jwtConfig;
        this.secretKey = secretKey;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("Attempting authentication!");
        try {
            Login authRequest = new ObjectMapper().readValue(request.getInputStream(), Login.class);
            Authentication authentication = generateAuthentication(authRequest.getEmail(), authRequest.getPassword());
            return authenticationManager.authenticate(authentication);
        } catch (IOException ex) {
            log.error("IOException caught when authentication the user!");
            throw new RuntimeException("IOException caught when authentication the user!");
        } catch (AuthenticationException ex) {
            try {
                log.error("401 UNAUTHORIZED");
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, ex.getLocalizedMessage());
                throw new UnauthorizedAuthenticationException();
            } catch (IOException ex0) {
                log.error("IOException caught when sending 401 UNAUTHORIZED");
                throw new RuntimeException("401 UNAUTHORIZED IOException");
            }
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) {
        log.info("Successful authentication! Generating JWT token!");
        response.addHeader(EXPIRES, generateToken(authResult));
    }

    public Authentication generateAuthentication(String username, String password) {
        return new UsernamePasswordAuthenticationToken(username, password);
    }

    private String generateToken(Authentication auth) {
        return jwtConfig.getTokenPrefix() + Jwts.builder().setSubject(auth.getName()).claim("authorities", auth.getAuthorities()).setIssuedAt(new Date()).setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtConfig.getTokenExpiryDuration()))).signWith(secretKey).compact();
    }
}
