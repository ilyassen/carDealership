package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.TestApplicationConfiguration;
import com.jfy.CarDealership.App.dto.Purchase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


@ComponentScan("com.jfy")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class PurchaseDBTest {

  @Autowired
  PurchaseDao purchaseDao;



    @Test
    void addPurchase() {
      Purchase purchase = new Purchase(1, "test", "1234", "email",
        "street1", "street2", "city",
        "state", "0a0", "type", new Date(), 1);

      purchaseDao.addPurchase(purchase);

      Purchase expected = purchaseDao.getPurchaseById(1);

      assertTrue(expected.equals(purchase));
    }

    @Test
    void getPurchaseById() {

      Purchase purchase = new Purchase(1, "test", "1234", "email",
        "street1", "street2", "city",
        "state", "0a0", "type", new Date(), 1);


      Purchase expected = purchaseDao.getPurchaseById(1);

      assertTrue(expected.equals(purchase));
    }
}
