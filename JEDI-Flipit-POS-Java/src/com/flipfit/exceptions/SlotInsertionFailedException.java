package com.flipfit.exceptions;

/**
 * Custom exception class for handling slot insertion failure scenarios.
 * This exception is thrown when slot insertion fails.
 *

 */
public class SlotInsertionFailedException extends Exception {

    private String message = "Slot insertion failed!";
    public SlotInsertionFailedException() {}
    public SlotInsertionFailedException(String message) {
        this.message = message;
    }
    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the slot insertion fails.
     *
     * @return String Custom error message when this exception is thrown.
     */

    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return message;
    }
}

