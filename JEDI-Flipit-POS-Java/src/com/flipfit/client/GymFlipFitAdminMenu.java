package com.flipfit.client;

import com.flipfit.business.AdminInterface;
import com.flipfit.business.AdminService;

public class GymFlipFitAdminMenu {
    AdminInterface adminService = new AdminService();

    public boolean login (String username, String password) {
        // login logic
        return true;
    }
//registration

    private boolean userVerify (String username, String password) {
        //authentication logic
        return false;
    }

    public void adminMainPage() {

    }
}
