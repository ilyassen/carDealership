/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.service;

import com.jfy.CarDealership.App.dao.*;
import com.jfy.CarDealership.App.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Fishget
 */

@Service
@ComponentScan("Service")
public class CarDealershipServiceImpl {
    @Autowired
    ContactDao ContactDao;

    @Autowired
    VehicleDao VehicleDao;

    @Autowired
    UserDao userDao;

    @Autowired
    PurchaseDao purchaseDao;

    @Autowired
    MakeModelDao MakeModelDao;

    public List<Contact> getAllContacts() {
        List<Contact> contacts = ContactDao.getAllContacts();
        return contacts;
    }

    public Contact newContact (String name, String email, String phone,String message){
        Contact contact = new Contact();
        contact.setName(name);
        contact.setEmail(email);
        contact.setPhone(phone);
        contact.setMessage(message);
        ContactDao.addContact(contact);
        return contact;
    }
    public Vehicle addVehicle(int year, String bodyStyle, String color, String transmission, String interior, String mileage, String vin, double price, double MSRP, String type, String description, String make, String model, int userId,String date)
    {
            Vehicle vehicle = new Vehicle();
            vehicle.setYear(year);
            vehicle.setBodyStyle(bodyStyle);
            vehicle.setColor(color);
            vehicle.setTransmission(transmission);
            vehicle.setInterior(interior);
            vehicle.setMileage(mileage);
            vehicle.setVin(vin);
            vehicle.setPrice(price);
            vehicle.setMSRP(MSRP);
            vehicle.setType(type);
            vehicle.setDescription(description);
            vehicle.setMake(make);
            vehicle.setModel(model);
            vehicle.setUserId(userId);
            return VehicleDao.addVehicle(vehicle);
    }



    public Vehicle EditVehicle(int id,int vehicleId, int year, String bodyStyle, String color, String transmission, String interior, String mileage, String vin, double price, double MSRP, String type, String description, String make, String model, int userId, String date){
        User user = userDao.getUserById(id);

        if (user.getRole().equals("Admin")){
           Vehicle vehicle = VehicleDao.getVehicleById(vehicleId);
           //System.out.println(vehicle.getDate());
           vehicle.setVehicleId(vehicleId);
           vehicle.setYear(year);
           vehicle.setBodyStyle(bodyStyle);
           vehicle.setColor(color);
           vehicle.setTransmission(transmission);
           vehicle.setInterior(interior);
           vehicle.setMileage(mileage);
           vehicle.setVin(vin);
           vehicle.setPrice(price);
           vehicle.setMSRP(MSRP);
           vehicle.setType(type);
           vehicle.setDescription(description);
           vehicle.setMake(make);
           vehicle.setModel(model);
           vehicle.setUserId(userId);
           VehicleDao.updateVehicle(vehicle);
           return VehicleDao.getVehicleById(vehicleId);
        } else{
        return VehicleDao.getVehicleById(vehicleId);
        }

    }


    public List<Vehicle> SearchVehicleByPrice(int min, int max, String type) {
        List<Vehicle> vehicles = VehicleDao.getAllVehicleByPrice(min, max);
        List<Vehicle> vehiclesTypes = new ArrayList<Vehicle>();

        for (Vehicle vehicle : vehicles){
            if (vehicle.getType().equals(type)){
                vehiclesTypes.add(vehicle);
            }
        }
        return vehiclesTypes;
    }
    public List<Vehicle> SearchVehicleByYear(int year) {
        List<Vehicle> vehicles = VehicleDao.getAllVehicleByYear(year);
        return vehicles;
    }
    public List<Vehicle> SearchVehicleByYearRange(int min, int max) {
        List<Vehicle> vehicles = VehicleDao.getAllVehicleByYearRange(min, max);
        return vehicles;
    }

     public List<Vehicle> getAllVehicleByType(String type, int limit) {
        if(type.equals("New")){
             limit= 20;
        }
        List<Vehicle> vehicles = VehicleDao.getAllVehicleByType(type,limit);
        return vehicles;
    }
    public Vehicle getVehicleById(int vehicleId) {
        Vehicle vehicle = VehicleDao.getVehicleById(vehicleId);
        return vehicle;
    }

    public List<Vehicle> SearchVehicleByMakeModelYear(String type) {
        List<Vehicle> vehicles = VehicleDao.getAllVehicle();
        List<Vehicle> vehiclesTypes = new ArrayList<Vehicle>();
        for (Vehicle vehicle : vehicles){
            if (vehicle.getModel().equals(type)){
                vehiclesTypes.add(vehicle);
            }
            else if (vehicle.getMake().equals(type)){
                vehiclesTypes.add(vehicle);
            }
            else{
                String year = Integer.toString(vehicle.getYear());
                if (year.equals(type)){
                   vehiclesTypes.add(vehicle);
                }
            }
        }
        return vehiclesTypes;
    }

    public List <MakeModel> getMakeModels() {
        return MakeModelDao.getAllMakeModels();
    }

    public MakeModel addMakeModel(String make, String model,String date,String email) {

        MakeModel makemodel = new MakeModel();
        makemodel.setMake(make);
        makemodel.setModel(model);
        makemodel.setDate(date);
        makemodel.setEmail(email);
        MakeModelDao.addMakeModel(makemodel);
        return makemodel;

    }

    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }

    public User getUserById(int id){
        return userDao.getUserById(id);
    }

    public void addUser(User user){
        userDao.addUser(user);
    }

    public void editUser(User user){
        userDao.updateUser(user);
    }

    public void changePassword(int userId, String newPassword){
        userDao.changePassword(userId, newPassword);
    }

    public void addPurchase(Purchase purchase){
        purchaseDao.addPurchase(purchase);
    }

    public List<Purchase> getAllPurchase(){
        return purchaseDao.getAllPurchases();
    }
}
