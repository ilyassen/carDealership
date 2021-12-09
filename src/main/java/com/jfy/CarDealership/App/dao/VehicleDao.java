package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Vehicle;

import java.util.List;

/**
 * @author Andong
 * @create 2021-12-04-11:59
 */
public interface VehicleDao {

    List<Vehicle> getAllVehicleByType(String type, int limit);

    List<Vehicle> getAllVehicleByPrice(double min, double max);

    List<Vehicle> getAllVehicleByYearRange(int min, int max);

    List<Vehicle> getAllVehicleByYear(int year);

    Vehicle getVehicleById(int vehicleId);

    List<Vehicle> getAllVehicle();

    Vehicle addVehicle(Vehicle vehicle);

    void updateVehicle(Vehicle vehicle);


}
