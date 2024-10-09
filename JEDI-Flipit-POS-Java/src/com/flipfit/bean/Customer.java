package com.flipfit.bean;

public class Customer extends User {
    private String customerCity;
    private String customerCardNumber;

    public Customer (String userId, String userName, String email, String password, String customerCity, String customerCardNumber) {
        super(userId, userName, email, password);
        this.customerCity = customerCity;
        this.customerCardNumber = customerCardNumber;
    }

    public String getCustomerAddress() {
        return customerCity;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerCity = customerAddress;
    }

    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }
}