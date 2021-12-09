/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dto;

import java.util.Objects;

/**
 *
 * @author Fishget
 */
public class Vehicle {
    private int vehicleId;
    private int year;
    private String bodyStyle;
    private String color;
    private String transmission;
    private String interior;
    private String mileage;
    private String vin;
    private double price;
    private double MSRP;
    private String type;
    private String description;
    private String make;
    private String model;
    private int userId;

    public Vehicle(){

    }

    public Vehicle(int year, String bodyStyle, String color, String transmission, String interior, String mileage, String vin, double price, double MSRP, String type, String description, String make, String model, int userId) {
        this.year = year;
        this.bodyStyle = bodyStyle;
        this.color = color;
        this.transmission = transmission;
        this.interior = interior;
        this.mileage = mileage;
        this.vin = vin;
        this.price = price;
        this.MSRP = MSRP;
        this.type = type;
        this.description = description;
        this.make = make;
        this.model = model;
        this.userId = userId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(String bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getInterior() {
        return interior;
    }

    public void setInterior(String interior) {
        this.interior = interior;
    }

    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMSRP() {
        return MSRP;
    }

    public void setMSRP(double MSRP) {
        this.MSRP = MSRP;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return vehicleId == vehicle.vehicleId && year == vehicle.year && Double.compare(vehicle.price, price) == 0 && Double.compare(vehicle.MSRP, MSRP) == 0 && userId == vehicle.userId && Objects.equals(bodyStyle, vehicle.bodyStyle) && Objects.equals(color, vehicle.color) && Objects.equals(transmission, vehicle.transmission) && Objects.equals(interior, vehicle.interior) && Objects.equals(mileage, vehicle.mileage) && Objects.equals(vin, vehicle.vin) && Objects.equals(type, vehicle.type) && Objects.equals(description, vehicle.description) && Objects.equals(make, vehicle.make) && Objects.equals(model, vehicle.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicleId, year, bodyStyle, color, transmission, interior, mileage, vin, price, MSRP, type, description, make, model, userId);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleId=" + vehicleId +
                ", year=" + year +
                ", bodyStyle='" + bodyStyle + '\'' +
                ", color='" + color + '\'' +
                ", transmission='" + transmission + '\'' +
                ", interior='" + interior + '\'' +
                ", mileage='" + mileage + '\'' +
                ", vin='" + vin + '\'' +
                ", price=" + price +
                ", MSRP=" + MSRP +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", userId=" + userId +
                '}';
    }
}
