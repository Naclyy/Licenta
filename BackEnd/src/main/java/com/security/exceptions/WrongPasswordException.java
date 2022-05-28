package com.security.exceptions;

public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException() {
        super("Wrong password inserted!");
    }
}
