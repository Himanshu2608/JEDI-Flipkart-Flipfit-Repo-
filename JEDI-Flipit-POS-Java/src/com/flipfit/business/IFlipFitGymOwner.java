package com.flipfit.business;

import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.bean.*;

import java.util.List;

public interface IFlipFitGymOwner {
    public FlipFitGymCentre addCentre(FlipFitGymCentre flipFitGymCentre) throws InvalidChoiceException;
    public List<FlipFitGymCentre> viewCentres(FlipFitGymOwner flipFitGymOwner);
    public List<FlipFitPayments> viewPayments();
    public FlipFitGymOwner editDetails(FlipFitGymOwner flipFitGymOwner) throws InvalidChoiceException;
    public FlipFitGymOwner registerOwner(FlipFitGymOwner owner);
    public FlipFitUser login(FlipFitUser user);
    FlipFitSlots addSlot(FlipFitSlots flipFitSlot);
}
