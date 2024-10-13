package com.flipfit.dao;
import com.flipfit.bean.FlipFitGymCustomer;
import com.flipfit.bean.FlipFitGymOwner;
import com.flipfit.bean.FlipFitUser;

public interface IFlipFitUserDAO {
    public FlipFitUser loginAsCustomer(String emailID, String password);
    public FlipFitUser loginAsOwner(String emailID, String password);

    public void addUser(FlipFitUser ffu);
    public void deleteUser(FlipFitUser ffu);
    public void changeUser(FlipFitUser ffu);
    public FlipFitUser getUser(int userID);
}
