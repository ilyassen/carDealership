package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.TestApplicationConfiguration;
import com.jfy.CarDealership.App.dto.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;


@ComponentScan("com.jfy")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class UserDBTest {

  @Autowired
  UserDao userDao;


    @Test
    void getUserById() {

      User user = new User(1, "X", "man", "xman@hotmail.com", "Admin", "xman");

      User expectedUser = userDao.getUserById(1);

      assertTrue(expectedUser.equals(user));
    }

    @Test
    void changePassword() {

      User user = new User(1, "X", "man", "xman@hotmail.com", "Admin", "admin");


      userDao.changePassword(1,"admin");
      User expectedUser = userDao.getUserById(1);


      assertTrue(expectedUser.equals(user));
    }
}
