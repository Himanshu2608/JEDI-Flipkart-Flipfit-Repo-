package com.flipfit.business;

public interface BookingInterface {
    public boolean addBooking(String userId, String slotId, String gymId);
    public boolean isBookingValid(String slotId, String gymId);
    public boolean cancelBooking(String bookingid);

}
