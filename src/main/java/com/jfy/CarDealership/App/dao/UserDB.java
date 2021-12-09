/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Fishget
 */
@Repository
public class UserDB implements UserDao{

    @Autowired
    JdbcTemplate jdbc;

    public static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setRole(rs.getString("role"));
            return user;
        }
    }
    @Transactional
    public int addUser(User user) {

        final String INSERT_USER = "INSERT INTO user(first_name, last_name, password, email, role) VALUES(?,?,?,?,?)";
        jdbc.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getRole());
        int newUserId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        return newUserId;
    }

    public List<User> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        return jdbc.query(SELECT_ALL_USERS, new UserMapper());
    }


    public User getUserById(int userId) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user WHERE user_id = ?";
            return jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), userId);
        } catch(DataAccessException ex) {
            return null;
        }
    }

    public void updateUser(User user) {
        final String UPDATE_USER = "UPDATE user SET first_name = ?, last_name = ?, password = ?, email = ?, role = ? WHERE user_id = ?";
        jdbc.update(UPDATE_USER, user.getFirstName(), user.getLastName(), user.getPassword(), user.getEmail(), user.getRole(), user.getUserId());
    }

    public void changePassword(int userId, String newPassword){
        final String CHANGE_PASSWORD = "UPDATE user SET password = ? WHERE user_id = ?";
        jdbc.update(CHANGE_PASSWORD, newPassword, userId);
    }



}
