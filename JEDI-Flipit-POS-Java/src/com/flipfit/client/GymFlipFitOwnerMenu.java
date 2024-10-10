package com.flipfit.client;

import com.flipfit.business.AdminService;
import com.flipfit.business.GymOwnerInterface;
import com.flipfit.business.GymOwnerService;

import java.util.*;

public class GymFlipFitOwnerMenu {

    public void gymOwnerMainPage() {
        Scanner scanner = new Scanner(System.in);
        GymOwnerService gymOwnerService = new GymOwnerService();

        while (true) {
            System.out.println("Gym Owner Service Menu:");
            System.out.println("1. Add Gym Center");
            System.out.println("2. Remove Gym Center");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String ownerId = UUID.randomUUID().toString();
                    System.out.print("Enter gym ID: ");
                    String gymId = scanner.nextLine();
                    System.out.print("Enter city: ");
                    String city = scanner.nextLine();
                    System.out.print("Enter capacity: ");
                    int capacity = scanner.nextInt();
                    System.out.print("Enter cost: ");
                    int cost = scanner.nextInt();
                    scanner.nextLine();
                    boolean addCenterStatus = gymOwnerService.addCenter(ownerId, gymId, city, capacity, cost);
                    System.out.println("Add center status: " + (addCenterStatus ? "Success" : "Failed"));
                    break;
                case 2:
                    System.out.print("Enter owner ID: ");
                    String removeOwnerId = scanner.nextLine();
                    System.out.print("Enter gym ID: ");
                    String removeGymId = scanner.nextLine();
                    boolean removeCenterStatus = gymOwnerService.removeCenter(removeOwnerId, removeGymId);
                    System.out.println("Remove center status: " + (removeCenterStatus ? "Success" : "Failed"));
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
