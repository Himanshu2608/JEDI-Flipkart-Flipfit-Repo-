package com.flipfit.dao;

import com.flipfit.bean.FlipFitSlots;

import java.util.List;

public interface IFlipFitSlotDAO {
    public FlipFitSlots addSlot(FlipFitSlots slot);
    public boolean deleteSlot(int centreID, int slotID);
    public boolean changeSlot(FlipFitSlots slot);
    public List<FlipFitSlots> getAllSlots(int centreID);
    public FlipFitSlots getSlotDetailsById(int slotId);
    public FlipFitSlots getSlotDetails(int startTime, int centreID);
}
