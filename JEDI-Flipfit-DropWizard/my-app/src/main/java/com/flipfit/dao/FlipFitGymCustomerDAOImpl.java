package com.flipfit.dao;
import com.flipfit.model.*;
import com.flipfit.exceptions.RegistrationFailedException;
import com.flipfit.exceptions.UpdationFailedException;

import java.sql.*;
        import java.util.*;


public class FlipFitGymCustomerDAOImpl implements IFlipFitGymCustomerDAO{
    /**
     * viewBookedSlots
     * @param userID
     * @return
     */
    public List<FlipFitSlots> viewBookedSlots(int userID) {
        List<FlipFitSlots> bookedSlots = new ArrayList<>();
        String sql = "SELECT * FROM Booking WHERE userID = ? and isDeleted=FALSE";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                FlipFitSlots slot = new FlipFitSlots();
                slot.setSlotId(rs.getInt("slotID"));
                bookedSlots.add(slot);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return bookedSlots;
    }

    /**
     * checkBookingConflicts
     * @param userId
     * @param slotTime
     * @return
     */
    public FlipFitBooking checkBookingConflicts(int userId, int slotTime) {
        String sql = "SELECT * FROM Booking WHERE userID = ? and slotTime = ?";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setInt(1, userId);
            stmt.setInt(2, slotTime);
            try(ResultSet rs = stmt.executeQuery()) {
                if(rs.next()) {
                    FlipFitBooking booking = new FlipFitBooking();
                    booking.setSlotTime(rs.getInt("slotTime"));
                    booking.setSlotId(rs.getInt("slotID"));
                    booking.setUserId(userId);
                    booking.setBookingId(rs.getInt("bookingID"));
                    booking.setIsdeleted(rs.getBoolean("isDeleted"));
                    return booking;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * viewCentres
     * @return
     */
    public List<FlipFitGymCentre> viewCentres() {
        List<FlipFitGymCentre> gymcentres = new ArrayList<>();
        String sql = "SELECT * FROM GymCentre";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                FlipFitGymCentre gymcentre = new FlipFitGymCentre();
                gymcentre.setCentreID(rs.getInt("centreID"));
                gymcentre.setOwnerID(rs.getInt("ownerID"));
                gymcentre.setCapacity(rs.getInt("capacity"));
                gymcentre.setCity(rs.getString("city"));
                gymcentre.setState(rs.getString("state"));
                gymcentre.setApproved(rs.getBoolean("approved"));
                gymcentre.setPincode(rs.getString("pincode"));
                gymcentres.add(gymcentre);
            }
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return gymcentres;
    }

    /**
     * makePayment
     * @param userID
     * @return
     */
    public boolean makePayment(int userID) {
        return false;
    }

    /**
     * viewPaymentDetails
     * @param userID
     */
    public void viewPaymentDetails(int userID) {

    }

    /**
     * editPaymentDetails
     * @param userID
     */
    public void editPaymentDetails(int userID) {

    }

    /**
     * editDetails
     * @param customer
     * @return
     */
    public FlipFitGymCustomer editDetails(FlipFitGymCustomer customer) {
        String sql = "UPDATE Customer SET city=?, pincode=? WHERE customerID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getCity());
            stmt.setString(2, customer.getPinCode());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                throw new UpdationFailedException();
            }
        } catch (SQLException | UpdationFailedException e){
          System.out.println(e.getMessage());
        }

        sql = "UPDATE User SET userName=?, password=? WHERE userID=?";

        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)){
            stmt.setString(1, customer.getUserName());
            stmt.setString(2, customer.getPassword());
            stmt.setInt(3,customer.getUserId());
            ResultSet rs = stmt.executeQuery();
            if(rs==null) {
                throw new UpdationFailedException();
            }
        } catch (SQLException | UpdationFailedException e){
            System.out.println(e.getMessage());
        }

        return customer;
    }

    /**
     * addUser
     * @param user
     * @return
     */
    public FlipFitUser addUser(FlipFitUser user) {
        String sql = "INSERT INTO User (userName, roleID, emailID, phoneNumber, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getUserName());
            stmt.setInt(2, user.getRole());
            stmt.setString(3, user.getEmailID());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setString(5, user.getPassword());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new RegistrationFailedException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int userID = generatedKeys.getInt(1);
                    user.setUserId(userID);
                } else {
                    throw new RegistrationFailedException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException | RegistrationFailedException e) {
            System.out.println(e.getMessage());
        }
        return user;
    }

    /**
     * addCustomer
     * @param customer
     * @param user
     * @return
     */
    public FlipFitGymCustomer addCustomer(FlipFitGymCustomer customer, FlipFitUser user) {
        String sql = "INSERT INTO Customer (customerID, city, pincode) VALUES (?, ?, ?)";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, user.getUserId());
            stmt.setString(2, customer.getCity());
            stmt.setString(3, customer.getPinCode());
            int affectedRows = stmt.executeUpdate(); // Use executeUpdate() for INSERT
            if (affectedRows == 0) {
                throw new RegistrationFailedException("Creating customer failed, no rows affected.");
            }
        } catch (SQLException | RegistrationFailedException e) {
            System.out.println(e.getMessage());
        }
        customer.setUserId(user.getUserId());
        return customer;
    }
}

