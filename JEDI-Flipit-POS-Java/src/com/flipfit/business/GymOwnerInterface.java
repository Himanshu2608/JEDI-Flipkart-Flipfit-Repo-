package com.flipfit.business;

public interface GymOwnerInterface {
    public boolean login(String username, String password);
    public boolean register (String username, String password);
    public boolean changePassword (String oldPassword, String newPassword);
    public boolean addCenter(String centerName);
    public boolean removeCenter(String centerName);
}
