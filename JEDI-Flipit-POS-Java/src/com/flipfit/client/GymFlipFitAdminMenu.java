package com.flipfit.client;

import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.business.AdminInterface;
import com.flipfit.business.AdminService;
import java.util.*;

public class GymFlipFitAdminMenu {
    AdminInterface adminService = new AdminService();

    public boolean login (String username, String password) {
        if (userVerify(username, password)){
            System.out.println("Admin logged in");
            adminMainPage();
        }
        else{
            System.out.println("Invalid username or password");
            return false;
        }
        return true;
    }
//registration

    private boolean userVerify (String username, String password) {
        //authentication logic
        return false;
    }

    public void adminMainPage() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Admin Service Menu:");
            System.out.println("1. Approve Gym Owner");
            System.out.println("2. View Remaining Slots");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Gym Owner ID: ");
                    String gymOwnerId = scanner.nextLine();
                    System.out.print("Enter status (true for approve, false for disapprove): ");
                    boolean status = scanner.nextBoolean();
                    scanner.nextLine();
                    boolean approvalStatus = adminService.approveGymOwner(gymOwnerId, status);
                    System.out.println("Approval status: " + (approvalStatus ? "Success" : "Failed"));
                    break;
                case 2:
                    List<FlipFitGymOwner> remainingSlots = adminService.viewNonApprovedSlots();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
