package com.flipfit.exceptions;

import com.flipfit.constant.ColorConstants;

public class InvalidLoginException extends Exception {
  @Override
  public String getMessage() {
    // Returns a custom error message when this exception is thrown
    return ColorConstants.RED + "Wrong credentials. Please enter correct credentials" + ColorConstants.RESET;
  }
}
