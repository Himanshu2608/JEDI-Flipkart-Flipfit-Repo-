package com.flipfit.exceptions;

public class RegistrationFailedException extends Exception {

    private String message = "Registration failed";
    public RegistrationFailedException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return "Registration failed. Please try again";
    }
    public String printMessage() {
        return message;
    }
}
