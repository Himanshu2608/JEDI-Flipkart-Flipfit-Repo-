package com.flipfit.bean;

public class Payment {
    private String paymentId;
    private String bookingId;
    private float amountPaid;

    public Payment() {}

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }
    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public float getAmountPaid() {
        return amountPaid;
    }
    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }
}