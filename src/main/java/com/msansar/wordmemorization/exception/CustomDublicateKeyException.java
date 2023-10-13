package com.msansar.wordmemorization.exception;

public class CustomDublicateKeyException extends RuntimeException{
    public CustomDublicateKeyException(String message) {
        super(message);
    }

    public CustomDublicateKeyException(String message, Throwable cause) {
        super(message, cause);
    }
}
