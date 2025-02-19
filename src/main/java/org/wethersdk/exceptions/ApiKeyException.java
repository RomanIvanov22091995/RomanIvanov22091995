package org.wethersdk.exceptions;

/**
 * Exception for invalid API key.
 */
public class ApiKeyException extends Exception {
    public ApiKeyException(String message) {
        super(message);
    }
}
