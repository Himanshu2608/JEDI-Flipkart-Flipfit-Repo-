package com.flipfit.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
                    ownerMap.put("name", owner.name);
                    ownerMap.put("aadharNumber", owner.aadharNumber);
                    return ownerMap;
                })
                .collect(Collectors.toList());
    }

    @GET
    @Path("/getApprovedOwnerList")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymOwner> getApprovedOwnerList() {
        return flipFitAdminBusiness.getApprovedOwnerList();
    }

    @GET
    @Path("/getCustomersList")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymCustomer> getCustomersList() {
        return flipFitAdminBusiness.getUserList();
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
