package org.wethersdk.exceptions;

/**
 * Exception for when the city is not found.
 */
public class CityNotFoundException extends Exception {
    public CityNotFoundException(String message) {
        super(message);
    }
}
