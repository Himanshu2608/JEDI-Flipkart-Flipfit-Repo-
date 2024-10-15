package com.flipfit.dao;

import com.flipfit.model.FlipFitGymCentre;
import com.flipfit.model.FlipFitGymOwner;
import com.flipfit.model.FlipFitUser;

import java.util.List;

public interface IFlipFitGymOwnerDAO {
    public FlipFitGymCentre addCentre(FlipFitGymCentre centre);
    public List<FlipFitGymCentre> viewCentresByOwnerID(FlipFitGymOwner owner);
//    List<FlipFitUser> viewFlipFitCustomers(FlipFitGymCentre centre);
    public FlipFitGymOwner editDetails(FlipFitGymOwner owner);
    public FlipFitGymOwner addGymOwner(FlipFitGymOwner owner, FlipFitUser user);
    public FlipFitUser addUser(FlipFitUser user);
}