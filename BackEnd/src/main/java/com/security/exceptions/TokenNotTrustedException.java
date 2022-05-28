package com.security.exceptions;

public class TokenNotTrustedException extends RuntimeException {
    public TokenNotTrustedException() {
        super("Token not trusted! Security may be compromised!");
    }
}
