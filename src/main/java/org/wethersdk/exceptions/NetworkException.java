package org.wethersdk.exceptions;

/**
 * Exception for network-related issues.
 */
public class NetworkException extends Exception {
    public NetworkException(String message) {
        super(message);
    }
}
