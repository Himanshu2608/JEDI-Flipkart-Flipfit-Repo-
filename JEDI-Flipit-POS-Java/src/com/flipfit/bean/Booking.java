package com.flipfit.bean;

public class Booking {
    private String bookingId;
    private String userID;
    public Booking (String bookingId, String userID) {
        this.bookingId = bookingId;
        this.userID = userID;
    }
    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getUserId() {
        return userID;
    }

    public void setUserId(String userId) {
        this.userID = userId;
    }



}
