package com.flipfit.bean;

public class FlipFitGym {

    private String gymId;
    private String gymName;
    private String ownerId;
    private String ownerName;
    private String gymAddress;
    private int numberOfSlots;
    private int cost;
    private int gymStatus;
    private String ownerGstNumber;

    public FlipFitGym(String gymId, String gymName, String ownerId, String ownerName, String gymAddress, int numberOfSlots, int cost, int gymStatus, String ownerGstNumber) {
        this.gymId = gymId;
        this.gymName = gymName;
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.gymAddress = gymAddress;
        this.numberOfSlots = numberOfSlots;
        this.cost = cost;
        this.gymStatus = gymStatus;
        this.ownerGstNumber = ownerGstNumber;
    }

    public int getNumberOfSlots() {
        return numberOfSlots;
    }

    public void setNumberOfSlots(int numberOfSlots) {
        this.numberOfSlots = numberOfSlots;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getGymStatus() {
        return gymStatus;
    }

    public void setGymStatus(int gymStatus) {
        this.gymStatus = gymStatus;
    }
    public String getOwnerGstNumber() {
        return ownerGstNumber;
    }

    public void setOwnerGstNumber(String ownerGstNumber) {
        this.ownerGstNumber = ownerGstNumber;
    }

}