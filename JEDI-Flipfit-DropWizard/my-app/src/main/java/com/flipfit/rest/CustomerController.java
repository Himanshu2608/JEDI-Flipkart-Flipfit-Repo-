package com.flipfit.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.business.IFlipFitGymCustomer;
import com.flipfit.exceptions.InvalidChoiceException;
import com.flipfit.model.*;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)

public class CustomerController {
    private final IFlipFitGymCustomer flipFitCustomerBusiness;
    private FlipFitGymCustomer flipFitGymCustomer;
    private FlipFitUser flipFitUser;

    @Inject
    public CustomerController(FlipFitGymCustomerBusiness flipFitGymCustomerService) {
        this.flipFitCustomerBusiness = flipFitGymCustomerService;
    }

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> login(FlipFitUser user) {
        FlipFitUser customer = flipFitCustomerBusiness.login(user);
        this.flipFitUser = customer;
        Map<String, String> responseMap = new HashMap<>();
        responseMap.put("userName", customer.getUserName());
        responseMap.put("emailID", customer.getEmailID());

        return responseMap;
    }

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public FlipFitGymCustomer register(FlipFitGymCustomer flipFitGymCustomer) {
        FlipFitGymCustomer customer = flipFitCustomerBusiness.registerCustomer(flipFitGymCustomer);
        this.flipFitGymCustomer = customer;
        return flipFitGymCustomer;
    }

    @GET
    @Path("/viewBookings")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitBooking> viewBookings(FlipFitGymCustomer flipFitGymCustomer) {
        return flipFitCustomerBusiness.viewBookedSlots(flipFitGymCustomer.getUserId());
    }

    @GET
    @Path("/viewCentres")
    @Consumes(MediaType.APPLICATION_JSON)
    public List<FlipFitGymCentre> viewCentres() {
        return flipFitCustomerBusiness.viewCentres();
    }

    @PUT
    @Path("/editDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public Map<String, String> editDetails(FlipFitGymCustomer flipFitGymCustomer) throws InvalidChoiceException {
        FlipFitGymCustomer customerDetails = flipFitCustomerBusiness.editDetails(flipFitGymCustomer);
        Map<String, String> detailMap = new HashMap<>();
        detailMap.put("userId", String.valueOf(customerDetails.getUserId()));
        detailMap.put("userName", customerDetails.getUserName());
        detailMap.put("password", customerDetails.getPassword());
        detailMap.put("updated", "successful");
        return detailMap;
    }

}
