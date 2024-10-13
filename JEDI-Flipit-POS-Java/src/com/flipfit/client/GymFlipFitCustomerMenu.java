package com.flipfit.client;

import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;
import com.flipfit.bean.FlipFitUser;
import com.flipfit.business.BookingsBusiness;
import com.flipfit.business.FlipFitGymCentreBusiness;
import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.dao.FlipFitBookingDAOImpl;
import com.flipfit.dao.FlipFitGymCentreDAOImpl;
import com.flipfit.dao.FlipFitGymCustomerDAOImpl;
import com.flipfit.exceptions.ExceptionHandler;
import com.flipfit.exceptions.InvalidChoiceException;

import java.util.Scanner;

import java.util.List;

public class GymFlipFitCustomerMenu {
    public static void getFlipFitCustomerMenu(FlipFitUser gymCustomer) throws InvalidChoiceException {
        try {
            int userId = gymCustomer.getUserId();
            Scanner sc = new Scanner(System.in);

            FlipFitGymCustomerDAOImpl flipFitGymCustomerDAO = new FlipFitGymCustomerDAOImpl();
            FlipFitGymCustomerBusiness FCBservice = new FlipFitGymCustomerBusiness(flipFitGymCustomerDAO);

            FlipFitGymCentreDAOImpl flipFitGymCenterDAO = new FlipFitGymCentreDAOImpl();
            FlipFitGymCentreBusiness FCService = new FlipFitGymCentreBusiness(flipFitGymCenterDAO);

            FlipFitBookingDAOImpl flipFitBookingDAO = new FlipFitBookingDAOImpl();
            BookingsBusiness BService = new BookingsBusiness(flipFitBookingDAO);

            int choice;

            do {
                System.out.println( "===========================" );
                System.out.println( "    FlipFit Customer Menu   " );
                System.out.println("===========================" );

                System.out.println( """
                        Choose an option:
                         1. View Booked Slots
                         2. View Centres
                         3. Logout
                        """ );

                choice = sc.nextInt();

                switch (choice) {
                    case 1: {
                        System.out.println( "=========== View Booked Slots ===========" );
                        FCBservice.viewBookedSlots(userId);

                        System.out.println( "Type 1. If you wish to cancel" );
                        System.out.println("Type 2. To return to main menu" );

                        choice = sc.nextInt();

                        if (choice == 1) {
                            System.out.print( "Choose the booking ID you wish to cancel:> " );
                            int bookingId = sc.nextInt();
                            BService.deleteBooking(bookingId);
                        }

                        break;
                    }
                    case 2: {
                        System.out.println( "=========== View Centres ===========");

                        List<FlipFitGymCentre> centreList = FCBservice.viewCentres();
                        for (FlipFitGymCentre centre : centreList) {
                            System.out.println( "CentreId: " + centre.getCentreID() + ", City: " + centre.getCity() + ", Pincode: " + centre.getPincode() );
                        }

                        System.out.print( "Choose a centre you want to book a slot in:> " );
                        int centreId = sc.nextInt();

                        List<FlipFitSlots> slotsList = FCService.viewAvailableSlots(centreId);
                        System.out.println( "These are the available slots:" );
                        for (FlipFitSlots flipFitSlots : slotsList) {
                            System.out.println( "Slot Id: " + flipFitSlots.getSlotId() + ", Slot Timing: " + flipFitSlots.getSlotTime() + ", Availability: " + flipFitSlots.getSeatsAvailable() + ", CentreId: " + flipFitSlots.getCentreId() );
                        }

                        System.out.print("Give the start time you wish to book:> " );
                        int startTime = sc.nextInt();

                        System.out.print( "Give the centre ID:> " );
                        int centreID = sc.nextInt();

                        BService.makeBooking(userId, centreID, startTime);

                        break;
                    }
                    case 3: {
                        System.out.println( "Successfully logged out");
                        return;
                    }
                    default: {
                        throw new InvalidChoiceException( "Invalid choice entered: " + choice );
                    }
                }
            } while (choice != 4);
        } catch (InvalidChoiceException e) {
            ExceptionHandler.InvalidChoiceMainMenu(e);
        }
    }
}