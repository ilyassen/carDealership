package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.User;

import java.util.List;

/**
 * @author Andong
 * @create 2021-12-04-11:56
 */
public interface UserDao {

    int addUser(User user);

    List<User> getAllUsers();

    User getUserById(int userId);

    void updateUser(User user);

    void changePassword(int userId, String newPassword);
}
