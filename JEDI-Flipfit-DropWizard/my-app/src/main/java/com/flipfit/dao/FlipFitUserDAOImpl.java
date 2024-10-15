package com.flipfit.dao;

import com.flipfit.model.FlipFitUser;
import com.flipfit.constant.DBConstants;
import com.flipfit.exceptions.RegistrationFailedException;
import com.flipfit.exceptions.UpdationFailedException;

import java.sql.*;
import java.util.Random;

public class FlipFitUserDAOImpl implements IFlipFitUserDAO {
    Random rand = new Random();

    /**
     * loginAsCustomer
     * @param emailID
     * @param password
     * @return FlipFitUser
     */
    @Override
    public FlipFitUser loginAsCustomer(String emailID, String password) {
        String sql = "SELECT * from User where emailID=? and password=? and roleID=0";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailID);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FlipFitUser flipFitUser = new FlipFitUser();
                    flipFitUser.setEmailID(emailID);
                    flipFitUser.setPassword(password);
                    flipFitUser.setUserId(rs.getInt("userID"));
                    flipFitUser.setRole(rs.getInt("roleID"));
                    flipFitUser.setUserName(rs.getString("userName"));
                    return flipFitUser;
                }
                else{
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * loginAsOwner
     *
     * @param emailID
     * @param password
     * @return
     */
    @Override
    public FlipFitUser loginAsOwner(String emailID, String password) {
        String sql = "SELECT * from FlipFitSchema.User where emailID=? and password=? and roleID=1";
        try (Connection conn = GetConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, emailID);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    FlipFitUser flipFitUser = new FlipFitUser();
                    flipFitUser.setEmailID(emailID);
                    flipFitUser.setPassword(password);
                    flipFitUser.setUserId(rs.getInt("userID"));
                    flipFitUser.setRole(rs.getInt("roleID"));
                    flipFitUser.setUserName(rs.getString("userName"));
                    return flipFitUser;
                }
                else {
                    return null;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * addUser
     *
     * @param FFU
     */
    @Override
    public void addUser(FlipFitUser FFU) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("INSERT INTO User VALUES (?, ?, ?, ?, ?, ?)");


            // Generate random integers in range 0 to 999
            FFU.setUserId(rand.nextInt(1000));
            stmt.setInt(1, FFU.getUserId());
            stmt.setInt(2, FFU.getUserId());
            stmt.setInt(3, FFU.getRole());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());


            int i = stmt.executeUpdate();
            if (i > 0) {
                System.out.println(i + " user added");
            }
            else{
                throw new RegistrationFailedException();
            }

            con.close();
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    /**
     * deleteUser
     *
     * @param FFU
     */
    @Override
    public void deleteUser(FlipFitUser FFU) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("DELETE FROM User WHERE userID=(?)");

            stmt.setInt(1, FFU.getUserId());

            int i = stmt.executeUpdate();
            System.out.println(i + " user removed");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * changeUser
     *
     * @param FFU
     */
    @Override
    public void changeUser(FlipFitUser FFU) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement(("UPDATE User SET userName = ?, roleID =? , emailId = ?, phoneNumber = ?, password = ? WHERE userID = ?"));

            stmt.setInt(1, FFU.getUserId());
            stmt.setInt(2, FFU.getUserId());
            stmt.setInt(3, FFU.getRole());
            stmt.setString(5, FFU.getPhoneNumber());
            stmt.setString(4, FFU.getEmailID());
            stmt.setString(6, FFU.getPassword());

            int i = stmt.executeUpdate();
            con.close();
            if(i > 0) {
                System.out.println(i + " user changed");
            }
            else {
                throw new UpdationFailedException();
            }
        } catch (UpdationFailedException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * getUser
     *
     * @param userID
     * @return
     */
    @Override
    public FlipFitUser getUser(int userID) {
        FlipFitUser FFU = new FlipFitUser();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);

            PreparedStatement stmt = con.prepareStatement("SELECT * FROM User WHERE userId = ?");
            stmt.setInt(1, userID);

            ResultSet rs = stmt.executeQuery();
            rs.next();
            FFU.setUserName(rs.getString("userName"));
            FFU.setUserId(rs.getInt("userID"));
            FFU.setPassword(rs.getString("password"));
            FFU.setPhoneNumber(rs.getString("phoneNumber"));
            FFU.setRole(rs.getInt("roleID"));
            FFU.setEmailID(rs.getString("emailId"));

            int i = stmt.executeUpdate();
            System.out.println(i + " user fetched");

            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return FFU;
    }
}
