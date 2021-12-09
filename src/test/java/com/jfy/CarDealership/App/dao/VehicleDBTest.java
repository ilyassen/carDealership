package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.TestApplicationConfiguration;
import com.jfy.CarDealership.App.dto.Vehicle;
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
class VehicleDBTest {


  @Autowired
  ContactDao contactDao;

  @Autowired
  VehicleDao vehicleDao;

    @Test
    void getAllVehicle() {
    }

    @Test
    void getAllVehicleByType() {
    }

    @Test
    void getAllVehicleByPrice() {
    }

    @Test
    void getAllVehicleByYearRange() {
    }

    @Test
    void getAllVehicleByYear() {
    }

    @Test
    void getVehicleById() {

      Vehicle v1 = vehicleDao.getVehicleById(1);

      Vehicle v2 = new Vehicle();
      v2.setVehicleId(1);
      v2.setYear(2013);
      v2.setBodyStyle("SUV");
      v2.setColor("Silver");
      v2.setTransmission("Automatic");
      v2.setInterior("Black");
      v2.setMileage("15000");
      v2.setVin("2DS820192D78S123");
      v2.setPrice(12875);
      v2.setMSRP(14875);
      v2.setType("Used");
      v2.setDescription("Bad Car");
      v2.setMake("Audi");
      v2.setModel("A4");
      v2.setUserId(3);


      assertTrue(v1.equals(v2));
    }

    @Test
    void addVehicle() {

      Vehicle v2 = new Vehicle();
      v2.setVehicleId(3);
      v2.setYear(2013);
      v2.setBodyStyle("SUV");
      v2.setColor("Silver");
      v2.setTransmission("Automatic");
      v2.setInterior("Black");
      v2.setMileage("15000");
      v2.setVin("2DS820192D78S123");
      v2.setPrice(12875);
      v2.setMSRP(14875);
      v2.setType("Used");
      v2.setDescription("Bad Car");
      v2.setMake("Audi");
      v2.setModel("A4");
      v2.setUserId(3);

      vehicleDao.addVehicle(v2);
  Vehicle v1 = vehicleDao.getVehicleById(3);

  assertTrue(v1.equals(v2));
}

  @Test
  void updateVehicle() {
  }
}
