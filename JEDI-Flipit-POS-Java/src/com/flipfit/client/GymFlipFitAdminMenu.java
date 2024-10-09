package com.flipfit.client;

public class GymFlipFitAdminMenu {
    AdminInterface adminService = new AdminService();

    public boolean login (String username, String password) {
        // login logic
        return true;
    }

    private boolean userVerify (String username, String password) {
        //authentication logic
        return false;
    }

    public void adminMainPage() {

    }
}
