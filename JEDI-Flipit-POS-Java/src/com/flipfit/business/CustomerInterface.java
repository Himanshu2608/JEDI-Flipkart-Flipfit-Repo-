package com.flipfit.business;

import com.flipfit.bean.FlipFitBooking;
import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitSlots;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface CustomerInterface {
    public List<FlipFitGymCentre> viewAllGymCenters(String city);
    public List<FlipFitSlots> viewAllFreeSlots (String gymId, LocalDate date);
    public List<FlipFitBooking> viewAllBookings (String gymId, LocalDate date);
    public boolean bookSlot (String userId, String gymId, String slotId, LocalDate date, LocalTime time);
    public boolean cancelSlot (String gymId, LocalDate date, LocalTime time);
    public boolean checkValidCustomer (String userName, String password);
    public boolean registerCustomer(String userName, String password, String email, String city, String cardNumber);
    public boolean changePassword(String username, String oldPassword, String newPassword);
    public void login(String userName, String password);
}