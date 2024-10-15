package com.flipfit.dao;

import com.flipfit.model.FlipFitBooking;

import java.util.ArrayList;
import java.util.List;

public interface IFlipFitBookingDAO {
    public FlipFitBooking makeBooking(FlipFitBooking booking);
    boolean deleteBooking(int bookingId);
    public List<FlipFitBooking> getAllBookings(int userId);
    public List<FlipFitBooking> getBookingDetails(int bookingId);
    public List<FlipFitBooking> bookings = new ArrayList<>();
}
