package com.flipfit.rest;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.flipfit.business.FlipFitAdminBusiness;
import com.flipfit.business.IFlipFitAdmin;
import com.flipfit.model.FlipFitAdmin;
import com.flipfit.model.FlipFitGymCentre;
import com.flipfit.model.FlipFitGymCustomer;
import com.flipfit.model.FlipFitGymOwner;

@Path("/admin")
@Produces(MediaType.APPLICATION_JSON)

public class AdminController {
    private final IFlipFitAdmin flipFitAdminBusiness;

    @Inject
    public AdminController(FlipFitAdminBusiness flipFitAdmin) {
        this.flipFitAdminBusiness = flipFitAdmin;
    }

    @GET
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean adminLogin(FlipFitAdmin flipFitAdmin) {
        return flipFitAdminBusiness.adminLogin(flipFitAdmin);
    }

    @GET
    @Path("/getPendingOwnerList")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getPendingOwnerList() {
        List<FlipFitGymOwner> owners=flipFitAdminBusiness.getPendingOwnerList();
        return owners.stream()
                .map(owner -> {
                    Map<String, String> ownerMap = new HashMap<>();
                    ownerMap.put("OwnerId", String.valueOf(owner.getUserId()));
                    ownerMap.put("aadharNumber", owner.aadharNumber);
                    return ownerMap;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/getApprovedOwnerList")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getApprovedOwnerList() {

        List<FlipFitGymOwner> owners=flipFitAdminBusiness.getApprovedOwnerList();
        return owners.stream()
                .map(owner -> {
                    Map<String, String> ownerMap = new HashMap<>();
                    ownerMap.put("OwnerId", String.valueOf(owner.getUserId()));
                    ownerMap.put("aadharNumber", owner.aadharNumber);
                    return ownerMap;
                })
                .collect(Collectors.toList());
    }

    @POST
    @Path("/approveOwner/ownerId={ownerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean approveOwner(@PathParam("ownerId") int ownerId) {
        return flipFitAdminBusiness.validateOwner(ownerId);
    }

    @GET
    @Path("/getCustomersList")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<Map<String, String>> getCustomersList() {

        List<FlipFitGymCustomer> customers = flipFitAdminBusiness.getUserList();
        return customers.stream()
                .map(customer -> {
                    Map<String, String> customerMap = new HashMap<>();
                    customerMap.put("UserId", String.valueOf(customer.getUserId()));
                    customerMap.put("UserName", customer.getUserName());
                    return customerMap;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/getGymCentreUsingOwnerId/ownerID={ownerID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(@PathParam("ownerID") int ownerID) {
        return flipFitAdminBusiness.getGymCentreUsingOwnerId(ownerID);
    }

    @DELETE
    @Path("/deleteOwner/ownerID={ownerID}")
    @Consumes(MediaType.APPLICATION_JSON)
    public boolean deleteOwner(@PathParam("ownerID") int ownerID) {
        return flipFitAdminBusiness.deleteOwner(ownerID);
    }

}
