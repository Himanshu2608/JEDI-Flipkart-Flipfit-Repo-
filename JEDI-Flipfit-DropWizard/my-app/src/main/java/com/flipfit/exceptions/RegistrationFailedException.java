package com.flipfit.exceptions;

public class RegistrationFailedException extends Exception {

    private String message = "Registration failed. Please try again";
    public RegistrationFailedException() {}
    public RegistrationFailedException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        // Returns a custom error message when this exception is thrown
        return message;
    }
}
