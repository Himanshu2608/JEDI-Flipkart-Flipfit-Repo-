package com.flipfit.dao;
import java.sql.*;
import com.flipfit.constant.DBConstants;
public class GetConnection {
    /**
     * getConnection
     * @return
     */
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DBConstants.DB_URL, DBConstants.USER, DBConstants.PASSWORD);
            return con;
        }
        catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
