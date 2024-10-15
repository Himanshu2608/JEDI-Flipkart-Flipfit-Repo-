package com.flipfit.app;

/**
 * Hello world!
 *
 */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flipfit.business.BookingsBusiness;
import com.flipfit.business.FlipFitAdminBusiness;
import com.flipfit.business.FlipFitGymCentreBusiness;
import com.flipfit.business.FlipFitGymCustomerBusiness;
import com.flipfit.business.FlipFitGymOwnerBusiness;
import com.flipfit.dao.FlipFitAdminDAOImpl;
import com.flipfit.dao.FlipFitBookingDAOImpl;
import com.flipfit.dao.FlipFitGymCentreDAOImpl;
import com.flipfit.dao.FlipFitGymCustomerDAOImpl;
import com.flipfit.dao.FlipFitGymOwnerDAOImpl;
import com.flipfit.rest.AdminController;
import com.flipfit.rest.BookingController;
import com.flipfit.rest.CustomerController;
import com.flipfit.rest.GymController;
import com.flipfit.rest.OwnerController;

import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) throws Exception {
        LOGGER.info("Registering REST resources");
        FlipFitAdminDAOImpl flipFitAdminDAO = new FlipFitAdminDAOImpl();
        FlipFitAdminBusiness flipFitAdmin = new FlipFitAdminBusiness(flipFitAdminDAO);
        FlipFitGymCustomerDAOImpl flipFitCustomerDAO = new FlipFitGymCustomerDAOImpl();
        FlipFitGymCustomerBusiness flipFitCustomer = new FlipFitGymCustomerBusiness(flipFitCustomerDAO);
        FlipFitGymCentreDAOImpl flipFitCentreDAO = new FlipFitGymCentreDAOImpl();
        FlipFitGymCentreBusiness flipFitCentre = new FlipFitGymCentreBusiness(flipFitCentreDAO);

        FlipFitBookingDAOImpl flipFitBookingDAO = new FlipFitBookingDAOImpl();
        BookingsBusiness bookingBusiness = new BookingsBusiness(flipFitBookingDAO);

        FlipFitGymOwnerDAOImpl flipFitGymOwnerDAO = new FlipFitGymOwnerDAOImpl();
        FlipFitGymOwnerBusiness gymOwnerBusiness = new FlipFitGymOwnerBusiness(flipFitGymOwnerDAO);

        e.jersey().register(new AdminController(flipFitAdmin));
        e.jersey().register(new CustomerController(flipFitCustomer));
        e.jersey().register(new GymController(flipFitCentre));
        e.jersey().register(new BookingController(bookingBusiness));
        e.jersey().register(new OwnerController(gymOwnerBusiness));
        System.out.println("HERE");
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}