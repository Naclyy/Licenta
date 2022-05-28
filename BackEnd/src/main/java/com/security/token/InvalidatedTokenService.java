package com.security.token;


import com.security.exceptions.AlreadyInvalidatedTokenException;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvalidatedTokenService {
    private final InvalidatedTokensDAO dao;

    @Autowired
    public InvalidatedTokenService(InvalidatedTokensDAO dao) {
        this.dao = dao;
    }

    public boolean checkIfIsInvalid(String token) {
        return dao.findByToken(token).isPresent();
    }

    public void invalidateToken(String token) {
        if (checkIfIsInvalid(token)) throw new AlreadyInvalidatedTokenException();
        dao.save(InvalidatedToken.builder().token(token).build());
    }
}

