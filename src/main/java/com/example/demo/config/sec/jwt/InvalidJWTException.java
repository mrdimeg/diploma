package com.example.demo.config.sec.jwt;

public class InvalidJWTException extends RuntimeException {

    public InvalidJWTException() {
        super();
    }

    public InvalidJWTException(String message) {
        super(message);
    }

    public InvalidJWTException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidJWTException(Throwable cause) {
        super(cause);
    }

    protected InvalidJWTException(String message, Throwable cause, boolean enableSuppression,
                                  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
