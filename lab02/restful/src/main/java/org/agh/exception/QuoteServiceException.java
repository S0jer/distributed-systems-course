package org.agh.exception;

public class QuoteServiceException extends RuntimeException {
    public QuoteServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
