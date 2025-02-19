package org.wethersdk.exceptions;

/**
 * Base exception for errors related to the weather SDK.
 */
public class CommonWeatherException extends Exception {
    public CommonWeatherException(String message) {
        super(message);
    }
}
