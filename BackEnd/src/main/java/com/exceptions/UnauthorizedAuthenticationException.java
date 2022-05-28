package com.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedAuthenticationException extends RuntimeException {
    public UnauthorizedAuthenticationException() {
        super("401 UNAUTHORIZED!");
    }
}
