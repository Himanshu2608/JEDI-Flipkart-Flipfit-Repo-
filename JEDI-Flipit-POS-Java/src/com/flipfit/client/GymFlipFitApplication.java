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
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter old password: ");
        String oldPassword = scanner.nextLine();
        System.out.print("Enter new password: ");
        String newPassword = scanner.nextLine();

        System.out.println("\nEnter your role:");
        System.out.println("1: Customer");
        System.out.println("2: GymOwner");
        System.out.println("3: Admin");

        try {
            int roleChoice = scanner.nextInt();

            switch(roleChoice) {
                case 1:
                    System.out.println("You selected Customer role.");
                    if(customerClient.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                case 2:
                    System.out.println("You selected GymOwner role.");
                    if(gymOwnerClient.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                case 3:
                    System.out.println("You selected Admin role.");
                    if(adminClient.changePassword(username, oldPassword, newPassword)){
                        System.out.println("Password changed successfully!");
                    }
                    break;
                default:
                    System.out.println("Invalid role choice. Please choose 1, 2, or 3.");
            }
        }
        catch (Exception e) {
            System.out.println("Please chosen a valid option");
        }
    }

    private static void registerGymOwner() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter aadhar card number: ");
        String adharCardNumber = scanner.nextLine();

        System.out.print("Enter gym center id: ");
        String gymCenterId = scanner.nextLine();
        List<String> gymCenterIds = new ArrayList<>();
        gymCenterIds.add(gymCenterId);
        boolean registrationSuccess = gymOwnerClient.register(UUID.randomUUID().toString(), username, email, password, adharCardNumber, gymCenterIds);

        if (registrationSuccess) {
            System.out.println("Customer registration successful!");
        } else {
            System.out.println("Customer registration failed. Please try again.");
        }
    }

    private static void registerAsCustomer() {
        Scanner scanner = new Scanner(System.in);

        // Input for registration details
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter city: ");
        String city = scanner.nextLine();

        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();

        // Call the registerCustomer method with the collected inputs
        boolean registrationSuccess = customerClient.registerCustomer(username, password, email, city, cardNumber);

        if (registrationSuccess) {
            System.out.println("Customer registration successful!");
        } else {
            System.out.println("Customer registration failed. Please try again.");
        }
    }

    private static void login() {
        System.out.println("Please Choose : \n1: Enter 1 to login as Admin\n2: Enter 2 to login as Customer\n3: " +
                "Enter 3 to login as GymOwner");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if(choice == 1) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();

            System.out.println("Enter your Passkey");
            String password = scanner.next();
            adminClient.login(userName, password);
            gymFlipFitAdminMenu.adminMainPage();
        }
        else if (choice == 2) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            customerClient.login(userName, password);
            gymFlipFitCustomerMenu.customerMainPage();
        }
        else if (choice == 3) {
            System.out.println("Enter your UserName");
            String userName = scanner.next();
            System.out.println("Enter your Passkey");
            String password = scanner.next();
            gymOwnerClient.login(userName, password);
            gymFlipFitOwnerMenu.gymOwnerMainPage();
        }
        else {
            System.out.println("Please choose a valid option");
        }
    }

    private static void homePage() {
        System.out.println("Welcome to home page!");
    }

}
