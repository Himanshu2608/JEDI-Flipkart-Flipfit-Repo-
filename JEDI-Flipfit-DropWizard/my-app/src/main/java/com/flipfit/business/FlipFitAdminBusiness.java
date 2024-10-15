package com.flipfit.business;
import com.flipfit.model.*;
import com.flipfit.dao.IFlipFitAdminDAO;
import com.flipfit.dao.FlipFitAdminDAOImpl;

import java.util.List;

public class FlipFitAdminBusiness implements IFlipFitAdmin {
    private final IFlipFitAdminDAO flipFitAdminDAOImpl;

    public FlipFitAdminBusiness(FlipFitAdminDAOImpl FFAdmin){
        this.flipFitAdminDAOImpl=FFAdmin;
    }

    public boolean adminLogin(FlipFitAdmin flipFitAdmin){
        return flipFitAdminDAOImpl.adminLogin(flipFitAdmin);
    }
    public List<FlipFitGymOwner> getPendingOwnerList(){
        return flipFitAdminDAOImpl.getPendingOwnerList();
    }
    public List<FlipFitGymOwner> getApprovedOwnerList(){
        return flipFitAdminDAOImpl.getApprovedOwnerList();
    }
    public List<FlipFitGymCustomer> getUserList(){
        return flipFitAdminDAOImpl.getUserList();
    }
    public boolean validateOwner(int ownerId){
        return flipFitAdminDAOImpl.validateOwner(ownerId);
    }
    public boolean deleteOwner(int ownerId){
        flipFitAdminDAOImpl.deleteOwner(ownerId);
        return true;
    }
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId){
        return flipFitAdminDAOImpl.getGymCentreUsingOwnerId(ownerId);
    }
}