package com.flipfit.bean;

import java.util.List;

public class GymOwner extends FlipFitUser {

    private String adharCardNumber;
    private List<String> gymCenterId;
    private boolean status;

    public GymOwner(String id, String name, String email, String password, String adharCardNumber, List<String> gymCenterId, boolean status) {
        super(id, name, email, password);
        this.adharCardNumber = adharCardNumber;
        this.gymCenterId = gymCenterId;
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<String> getGymCenterId() {
        return gymCenterId;
    }

    public void setGymCenterId(List<String> gymCenterId) {
        this.gymCenterId = gymCenterId;
    }

    public String getAdharCardNumber() {
        return adharCardNumber;
    }

    public void setAdharCardNumber(String adharCardNumber) {
        this.adharCardNumber = adharCardNumber;
    }
}