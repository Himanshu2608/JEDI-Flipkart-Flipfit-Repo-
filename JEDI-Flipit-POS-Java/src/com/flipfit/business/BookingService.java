package com.flipfit.business;

public class BookingService implements BookingInterface{
    @Override
    public boolean addBooking(String userId, String slotId, String gymId) {
        return false;
    }
    public boolean isBookingValid(String slotId, String gymId){
        return false;
    }
    public boolean cancelBooking(String bookingid) {
        return false;
    }
}
