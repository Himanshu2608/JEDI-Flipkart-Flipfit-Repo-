package com.flipfit.client;

import java.util.Scanner;

import static sun.security.jgss.GSSUtil.login;

public class GymFlipFitApplication {
    public static void main(String[] args) {
        homePage();
        System.out.println("Choose a option : \n1: Enter to login\n2:Enter to register as Customer\n3:Enter to register as Gym " +
                "Owner\n4: Change Password\n5: Exit");
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                login();
                break;
            case 2:
                registerAsCustomer();
                break;
            case 3:
                registerGymOwner();
                break;
            case 4:
                changePassword();
                break;
            case 5:
                System.out.println("Exiting FlipFit App. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Please choose a valid option");
        }
    }

    private static void changePassword() {
    }

    private static void registerGymOwner() {
    }

    private static void registerAsCustomer() {
    }

    private static void login() {
    }

    private static void homePage() {
        System.out.println("Welcome to home page!");
    }

}
