package com.flipfit.business;
import com.flipfit.model.*;
import com.flipfit.dao.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.IFlipFitBookingDAO;
import com.flipfit.model.*;

import com.flipfit.dao.FlipFitBookingDAOImpl;
import com.flipfit.dao.FlipFitSlotDAOImpl;
import com.flipfit.exceptions.BookingCancellationFailedException;
import com.flipfit.exceptions.SlotsUnavailableException;

import java.util.Scanner;

public class BookingsBusiness {
    private final IFlipFitBookingDAO bookingDAO;

    public BookingsBusiness(FlipFitBookingDAOImpl FFBooking) {
        this.bookingDAO = FFBooking;
    }

    public FlipFitBooking makeBooking(int userID, int centreID, int startTime) {
        try {
            Scanner sc = new Scanner(System.in);

            FlipFitSlotDAOImpl slotDAO = new FlipFitSlotDAOImpl();
            FlipFitSlots slotdetails = slotDAO.getSlotDetails(startTime, centreID);

            FlipFitGymCustomerDAOImpl FFGymCustomer = new FlipFitGymCustomerDAOImpl();
            FlipFitGymCustomerBusiness flipFitGymCustomerBusiness = new FlipFitGymCustomerBusiness(FFGymCustomer);
            if (slotdetails != null && slotdetails.getSeatsAvailable() > 0) {
                FlipFitBooking booking = flipFitGymCustomerBusiness.checkBookingConflicts(userID, startTime);
                if (booking != null) {
                    System.out.println("The user has already booked a slot at the same time.");
                    deleteBooking(booking.getBookingId());
                }
                booking = new FlipFitBooking();
                booking.setSlotId(slotdetails.getSlotId());
                booking.setSlotTime(slotdetails.getSlotTime());
                booking.setUserId(userID);
                booking.setIsdeleted(false);

                bookingDAO.makeBooking(booking);

                int seatsAvailable = slotdetails.getSeatsAvailable();
                slotdetails.setSeatsAvailable(seatsAvailable - 1);

                FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
                flipFitSlotsBusiness.updateAvailability(slotdetails);
                System.out.println("Slot booked successfully");
                return booking;
            } else {
                throw new SlotsUnavailableException();
            }
        } catch (SlotsUnavailableException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public boolean deleteBooking(int bookingId) {
//        System.out.println("Deleting a booking for " + bookingId);
        try {
            FlipFitBookingDAOImpl bookingDAO = new FlipFitBookingDAOImpl();
            FlipFitBooking bookingDetails = bookingDAO.getBookingDetailsByBookingId(bookingId);
            if (bookingDetails == null) {
                throw new BookingCancellationFailedException("Booking not found with id " + bookingId + ", please try again");
            }
            int slotId = bookingDetails.getSlotId();
            FlipFitSlotDAOImpl flipFitSlotDAO = new FlipFitSlotDAOImpl();
            FlipFitSlots flipFitSlots = flipFitSlotDAO.getSlotDetailsById(slotId);
            if (flipFitSlots != null) {
                int seatsAvailable = flipFitSlots.getSeatsAvailable();
                flipFitSlots.setSeatsAvailable(seatsAvailable + 1);

                FlipFitSlotsBusiness flipFitSlotsBusiness = new FlipFitSlotsBusiness();
                flipFitSlotsBusiness.updateAvailability(flipFitSlots);
            }
            else{
                throw new BookingCancellationFailedException();
            }

            bookingDAO.deleteBooking(bookingId);
            return true;
        } catch (BookingCancellationFailedException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}