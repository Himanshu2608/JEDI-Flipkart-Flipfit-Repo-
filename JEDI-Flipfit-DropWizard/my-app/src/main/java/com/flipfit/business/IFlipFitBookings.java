package com.flipfit.business;

import com.flipfit.model.*;

public interface IFlipFitBookings{
    public FlipFitBooking makeBooking(int userID, int centreID, int startTime);
    public boolean deleteBooking(int bookingId);
}