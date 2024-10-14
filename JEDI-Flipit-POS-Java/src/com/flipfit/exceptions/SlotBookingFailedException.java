package com.flipfit.exceptions;

import com.flipfit.constant.ColorConstants;

import static com.flipfit.constant.ColorConstants.*;

/**
 * Custom exception class for handling slot booking failure scenarios.
 * This exception is thrown when a slot booking fails.
 *

 */
public class SlotBookingFailedException extends Exception {

    /**
     * Overrides the getMessage() method from the Exception class to provide
     * a custom error message when the slot booking fails.
     *
     * @return String Custom error message with color formatting.

     */
    private String message = "Unable to book slot. Please try again";
    public SlotBookingFailedException() {}
    public SlotBookingFailedException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        // Returns a custom error message with color formatting when this exception is thrown
        return CYAN +  message + ColorConstants.RESET;
    }
}

