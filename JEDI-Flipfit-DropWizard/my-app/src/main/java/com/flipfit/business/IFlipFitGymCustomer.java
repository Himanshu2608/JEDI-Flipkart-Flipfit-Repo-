package com.flipfit.business;

import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.model.FlipFitBooking;
import com.flipfit.model.FlipFitGymCentre;
import com.flipfit.model.FlipFitGymCustomer;
import com.flipfit.model.FlipFitUser;

import java.util.List;

public interface IFlipFitGymCustomer {
    public List<FlipFitBooking> viewBookedSlots(int userId);
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime);
    public List<FlipFitGymCentre> viewCentres();
    public boolean makePayment(int userId);
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException;
    public FlipFitUser login(FlipFitUser flipFitUser);
    public FlipFitGymCustomer registerCustomer(FlipFitGymCustomer flipFitGymCustomer);
}
