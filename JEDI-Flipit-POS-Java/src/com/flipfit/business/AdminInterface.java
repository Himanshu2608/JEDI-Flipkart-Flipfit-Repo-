package com.flipfit.business;

import com.flipfit.bean.GymOwner;

import java.util.List;
public interface AdminInterface {
    public boolean approveGymOwner (String gymOwnerId, boolean status);
    public List<GymOwner> viewNonApprovedSlots();
    public boolean changePassword(String userName, String oldPassword, String newPassword);

}
