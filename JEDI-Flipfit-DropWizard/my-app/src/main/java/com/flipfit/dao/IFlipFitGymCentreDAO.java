package com.flipfit.dao;

import com.flipfit.model.FlipFitGymCentre;
import com.flipfit.model.FlipFitSlots;

import java.util.ArrayList;

public interface IFlipFitGymCentreDAO {
        public FlipFitGymCentre createGymCentre(FlipFitGymCentre FFGC);
        public FlipFitGymCentre updateGymCentre(FlipFitGymCentre FFGC);
        public void deleteGymCentre(FlipFitGymCentre FFGC);
        public ArrayList<FlipFitSlots> viewAvailableSlots(FlipFitGymCentre FFGC);
        public ArrayList<FlipFitGymCentre> viewCentres(String city);
}
