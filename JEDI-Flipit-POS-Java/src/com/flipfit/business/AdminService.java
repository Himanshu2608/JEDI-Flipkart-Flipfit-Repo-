package com.flipfit.business;


import com.flipfit.bean.GymOwner;
import java.util.List;
public class AdminService implements AdminInterface{
    public boolean approveGymOwner (String gymOwnerId, boolean status) {
        //method for call at dao layer to set the status of the gymOwnerId
        return false;
    }
    public List<GymOwner> viewNonApprovedSlots() {
        //method to call all pending ownerId
        return null;
    }
    public boolean approveGym (String gymId, boolean status) {
        return false;
    }
    public boolean changePassword(String userName, String oldPassword, String newPassword) {
        return false;
    }
    public void login(String userName, String password) {
        return;
    }
}
