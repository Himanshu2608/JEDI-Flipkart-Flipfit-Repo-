package com.flipfit.dao;

import com.flipfit.bean.*;
import com.flipfit.dao.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FlipFitAdminDAOImpl implements  IFlipFitAdminDAO {
    /**
     * adminLogin
     * @param flipFitAdmin
     * @return
     */
    @Override
    public boolean adminLogin(FlipFitAdmin flipFitAdmin) {
        String sql = "SELECT * FROM GymAdmin WHERE emailId = ? AND password = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, flipFitAdmin.getEmailID());
            stmt.setString(2, flipFitAdmin.getPassword());

            try (ResultSet rs = stmt.executeQuery()) {
                boolean res = rs.next();
                if(res){
                    System.out.println("Logged in Successfully");
                    LocalDateTime currentTime = LocalDateTime.now();
                    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                    String formattedDate = currentTime.format(myFormat);
                    System.out.println("Welcome ADMIN to FlipFit Application\nLogin Date and Time: "+ formattedDate);
                }
                else{
                    return false;
                }
                return true;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("Logged in Failed");
            return false;
        }
    }

    /**
     * getPendingOwnerList
     * @return
     */
    @Override
    public List<FlipFitGymOwner> getPendingOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT ownerID, Aadhar FROM GymOwner WHERE approved = 0";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserId(rs.getInt("ownerID"));
                owner.setAadharNumber(rs.getString("Aadhar"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pendingOwners;
    }

    /**
     * getApprovedOwnerList
     * @return
     */
    @Override
    public List<FlipFitGymOwner> getApprovedOwnerList() {
        List<FlipFitGymOwner> pendingOwners = new ArrayList<>();
        String sql = "SELECT * FROM GymOwner WHERE approved = 1";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                FlipFitGymOwner owner = new FlipFitGymOwner();
                owner.setUserId(rs.getInt("ownerID"));
                owner.setAadharNumber(rs.getString("Aadhar"));
                pendingOwners.add(owner);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pendingOwners;
    }

    /**
     * getUserList
     * @return
     */
    @Override
    public List<FlipFitGymCustomer> getUserList() {
        List<FlipFitGymCustomer> users = new ArrayList<>();
        String sql = "SELECT * FROM User";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                // Assuming you have a User class
                FlipFitGymCustomer user = new FlipFitGymCustomer(); // Replace with actual User class
                user.setUserId(rs.getInt("userID"));
                user.setUserName(rs.getString("userName"));
                users.add(user);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    /**
     * validateOwner
     * @param ownerId
     * @return
     */
    @Override
    public boolean validateOwner(int ownerId) {
        String sql = "UPDATE GymOwner SET approved = 1 WHERE ownerID = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * deleteOwner
     * @param ownerId
     * @return
     */
    @Override
    public boolean deleteOwner(int ownerId) {
        String sql = "DELETE FROM GymOwner WHERE ownerID = ?";
        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, ownerId);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * getGymCentreUsingOwnerId
     * @param ownerId
     * @return
     */
    @Override
    public List<FlipFitGymCentre> getGymCentreUsingOwnerId(int ownerId) {
        List<FlipFitGymCentre> gymCentres = new ArrayList<>();
        String sql = "SELECT * FROM GymCentre WHERE ownerID = ? AND approved = 1";

        try (Connection conn = GetConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, ownerId);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    FlipFitGymCentre gymCentre = new FlipFitGymCentre();
                    gymCentre.setCentreID(rs.getInt("centreID"));
                    gymCentre.setCapacity(rs.getInt("capacity"));
                    gymCentre.setCity(rs.getString("city"));
                    gymCentres.add(gymCentre);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            // Consider logging the error or throwing a custom exception
        }
        return gymCentres;
    }


}

