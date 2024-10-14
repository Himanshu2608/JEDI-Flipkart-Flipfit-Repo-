package com.flipfit.exceptions;

public class ExceptionHandler {
    public static void InvalidChoiceMainMenu(InvalidChoiceException e)
    {
        System.out.println(e.getMessage());
    }
    public static void InvalidChoiceEditDetailsMenu(InvalidChoiceException e)
    {
        System.out.println(e.getMessage());
    }

    public static void InvalidLoginDetails(InvalidLoginException e)
    {
        System.out.println(e.getMessage());
    }
}
