package com.flipfit.bean;

import java.time.LocalDate;
import java.time.LocalTime;

public class Slot {
    private String slotId;
    private String gymId;
    private LocalDate slotDate;
    private LocalTime slotTime;

    public Slot(String slotId, String gymId, LocalDate date, LocalTime slotTime) {
        this.slotId = slotId;
        this.gymId = gymId;
        this.slotDate = date;
        this.slotTime = slotTime;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public LocalDate getSlotDate() {return slotDate;}

    public void setSlotDate(LocalDate slotDate) { this.slotDate = slotDate;}

    public LocalTime getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }
}