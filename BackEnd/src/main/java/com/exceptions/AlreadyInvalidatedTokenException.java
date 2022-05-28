package com.exceptions;

public class AlreadyInvalidatedTokenException extends RuntimeException {
    public AlreadyInvalidatedTokenException() {
        super("Token is already invalidated!");
    }
}
