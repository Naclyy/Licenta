package com.security.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class TokenFormatException extends RuntimeException {
    public TokenFormatException() {
        super("Token does not respect the format!");
    }
}
