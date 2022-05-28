package com.security.exceptions;

public class UnmatchedPasswordsException extends RuntimeException {
    public UnmatchedPasswordsException() {
        super("Passwords do not match! Try again!");
    }
}
