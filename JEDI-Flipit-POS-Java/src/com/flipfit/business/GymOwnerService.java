package com.flipfit.business;

import java.util.List;

public class GymOwnerService implements GymOwnerInterface{
    public boolean login (String userName, String password) {
        //verify the user
        return false;
    }

    public boolean register (String userId, String userName, String email, String password, String adharCardNumber,
                             List<String> gymCenterId) {
        //add this user to DB
        return true;
    }

    public boolean addCenter (String ownerId, String gymId, String city, int capacity, int cost){
        //add the gym center to the ownerId
        return false;
    }

    public boolean removeCenter (String ownerId, String gymId){
        return false;
    }
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        return true;
    }
}
