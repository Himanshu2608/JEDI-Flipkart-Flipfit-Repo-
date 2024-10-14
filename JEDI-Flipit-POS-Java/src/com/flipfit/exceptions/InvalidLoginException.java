package com.flipfit.exceptions;

public class InvalidLoginException extends Exception {
  @Override
  public String getMessage() {
    // Returns a custom error message when this exception is thrown
    return "Wrong credentials. Please enter correct credentials";
  }
}
