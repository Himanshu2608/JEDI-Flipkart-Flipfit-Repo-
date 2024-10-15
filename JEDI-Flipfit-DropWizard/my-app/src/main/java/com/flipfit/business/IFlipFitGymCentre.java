package com.flipfit.business;


import com.flipfit.model.*;


import java.util.List;

public interface IFlipFitGymCentre {
    public FlipFitGymCentre updateGymCentre(FlipFitGymCentre flipFitGymCentre);
    public boolean deleteGymCentre(int centreId);
    public List<FlipFitSlots> viewAvailableSlots(int centreId);
}