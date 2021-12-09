/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Vehicle;
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
public class VehicleDB implements VehicleDao{

      @Autowired
    JdbcTemplate jdbc;

    public static final class VehicleMapper implements RowMapper<Vehicle> {
        @Override

        public Vehicle mapRow(ResultSet rs, int index) throws SQLException {
            Vehicle vehicle = new Vehicle();
            vehicle.setVehicleId(rs.getInt("vehicleId"));
            vehicle.setYear(rs.getInt("year"));
            vehicle.setBodyStyle(rs.getString("bodyStyle"));
            vehicle.setColor(rs.getString("color"));
            vehicle.setTransmission(rs.getString("transmission"));
            vehicle.setInterior(rs.getString("interior"));
            vehicle.setMileage(rs.getString("mileage"));
            vehicle.setVin(rs.getString("vin"));
            vehicle.setPrice(rs.getDouble("price"));
            vehicle.setMSRP(rs.getDouble("MSRP"));
            vehicle.setType(rs.getString("type"));
            vehicle.setDescription(rs.getString("description"));
            vehicle.setMake(rs.getString("make"));
            vehicle.setModel(rs.getString("model"));
            vehicle.setUserId(rs.getInt("user_id"));
            return vehicle;
        }
    }

      @Override
    public List<Vehicle> getAllVehicle() {
            final String SELECT_VEHICLE = "SELECT * FROM vehicle";
            return jdbc.query(SELECT_VEHICLE, new VehicleMapper());
    }

      @Override
    public List<Vehicle> getAllVehicleByType(String type, int limit) {
            final String SELECT_VEHICLE_BY_TYPE = "SELECT * FROM vehicle WHERE type = ? LIMIT ? ";
            return jdbc.query(SELECT_VEHICLE_BY_TYPE, new VehicleMapper(), type,limit);
    }

      @Override
    public List<Vehicle> getAllVehicleByPrice(double min, double max) {
            final String SELECT_VEHICLE_BY_PRICE = "SELECT * FROM vehicle WHERE price BETWEEN ? AND ? ";
            return jdbc.query(SELECT_VEHICLE_BY_PRICE, new VehicleMapper(), min, max);
    }

      @Override
    public List<Vehicle> getAllVehicleByYearRange(int min, int max) {
            final String SELECT_VEHICLE_BY_YEAR_RANGE = "SELECT * FROM vehicle WHERE year BETWEEN ? AND ? ";
            return jdbc.query(SELECT_VEHICLE_BY_YEAR_RANGE, new VehicleMapper(), min, max);
    }

      @Override
    public List<Vehicle> getAllVehicleByYear(int year) {
            final String SELECT_VEHICLE_BY_YEAR = "SELECT * FROM vehicle WHERE year = ? ";
            return jdbc.query(SELECT_VEHICLE_BY_YEAR, new VehicleMapper(), year);
    }

    @Override
    public Vehicle getVehicleById(int vehicleId) {
        try {
            final String SELECT_VEHICLE_BY_ID = "SELECT * FROM vehicle WHERE vehicleId = ?";
            return jdbc.queryForObject(SELECT_VEHICLE_BY_ID, new VehicleMapper(), vehicleId);
        } catch(DataAccessException ex) {
            return null;
        }
    }


    @Transactional
    public Vehicle addVehicle(Vehicle vehicle) {
        final String INSERT_VEHICLE = "INSERT INTO vehicle(year, bodyStyle, color, transmission, interior, mileage, vin, price, MSRP, type, description, make,model,user_id) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbc.update(INSERT_VEHICLE, vehicle.getYear(), vehicle.getBodyStyle(), vehicle.getColor(), vehicle.getTransmission(), vehicle.getInterior(), vehicle.getMileage(), vehicle.getVin(), vehicle.getPrice(), vehicle.getMSRP(), vehicle.getType(), vehicle.getDescription(), vehicle.getMake(), vehicle.getModel(), vehicle.getUserId());
        int newVehicleId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        vehicle.setVehicleId(newVehicleId);
        return getVehicleById(newVehicleId);
    }

    @Override
    public void updateVehicle(Vehicle vehicle) {
        final String UPDATE_VEHICLE = "UPDATE vehicle SET year = ?, bodyStyle = ?, color = ?, transmission = ?, interior = ?, mileage = ?, vin = ?, price = ?, MSRP = ?, type = ?, description = ?, make = ?,model = ?,user_id = ? WHERE vehicleId = ?";
        jdbc.update(UPDATE_VEHICLE, vehicle.getYear(), vehicle.getBodyStyle(), vehicle.getColor(), vehicle.getTransmission(), vehicle.getInterior(), vehicle.getMileage(), vehicle.getVin(), vehicle.getPrice(), vehicle.getMSRP(), vehicle.getType(), vehicle.getDescription(), vehicle.getMake(), vehicle.getModel(), vehicle.getUserId(),vehicle.getVehicleId() );
    }





}
