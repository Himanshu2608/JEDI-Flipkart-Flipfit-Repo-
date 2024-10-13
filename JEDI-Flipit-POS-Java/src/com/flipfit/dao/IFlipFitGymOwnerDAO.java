package com.flipfit.dao;

import com.flipfit.bean.FlipFitGymCentre;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;

import java.util.List;

public interface IFlipFitGymOwnerDAO {
    public FlipFitGymCentre addCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner owner);
//    List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner);
    public FlipFitGymOwner addGymOwner(FlipFitGymOwner owner, FlipFitUser user);
    public FlipFitUser addUser(FlipFitUser user);
}