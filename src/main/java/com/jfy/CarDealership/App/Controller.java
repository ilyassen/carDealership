/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App;

import com.jfy.CarDealership.App.dto.*;
import com.jfy.CarDealership.App.service.CarDealershipServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Fishget
 */
@RestController
@RequestMapping("/cardealership")
@ComponentScan("com.jfy")
public class Controller {

    @Autowired
    CarDealershipServiceImpl service;

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

     @GetMapping("/searchbyprice/{type}/{min}/{max}")
    public  List<Vehicle> SearchVehicleByPrice(@PathVariable("min")int min, @PathVariable("max")int max, @PathVariable("type")String type)
    {
        return service.SearchVehicleByPrice(min, max, type);
    }


     @GetMapping("/quicksearch/{input}")
    public  List<Vehicle> SearchVehicleByMakeModelYear(@PathVariable("input")String input)
    {
        return service.SearchVehicleByMakeModelYear(input);
    }
     @GetMapping("/searchbyyearrange/{min}/{max}")
    public  List<Vehicle> SearchVehicleByYearRange(@PathVariable("min")int min, @PathVariable("max")int max)
    {
        return service.SearchVehicleByYearRange(min, max);
    }

    @PostMapping("/addcontact")
    public Contact addContact(String name, String email, String phone,String message) {
        return service.newContact(name, email, phone, message);
    }
    @GetMapping("/{type}/{limit}")
    public List<Vehicle> getAllVehicleByType(@PathVariable("type")String type, @PathVariable("limit")int limit)
    {
        return service.getAllVehicleByType(type, limit);
    }
     @GetMapping("/inventory/details/{vehicleId}")
    public Vehicle getVehicleById( @PathVariable("vehicleId")int vehicleId)
    {
        return service.getVehicleById(vehicleId);
    }


    @PostMapping("/addVehicle")
    public Vehicle addVehicle(int year, String bodyStyle, String color, String transmission, String interior, String mileage, String vin, double price, double MSRP, String type, String description, String make, String model, int userId, String date)
    {
        return service.addVehicle(year, bodyStyle, color, transmission, interior, mileage, vin, price, MSRP, type, description, make, model, userId,date);
    }

    @PostMapping("/editVehicle")
    public Vehicle editehicle(int id,int vehicleId, int year, String bodyStyle, String color, String transmission, String interior, String mileage, String vin, double price, double MSRP, String type, String description, String make, String model, int userId, String date)
    {
        return service.EditVehicle(id,vehicleId, year, bodyStyle, color, transmission, interior, mileage, vin, price, MSRP, type, description, make, model, userId, date);
    }


    @PostMapping("/addmakemodel")
    public MakeModel addMakeModel(String make, String model, String date,String email) {
        return service.addMakeModel(make, model, date, email);
    }
    @GetMapping("/makemodel")
    public List<MakeModel> getAllMakeModels() {
        return service.getMakeModels();
    }

    @PostMapping("/adduser/{userId}")
    public String addUser(@PathVariable Integer userId, String firstName, String lastName, String email, String role, String password){
        User userAdmin = service.getUserById(userId);
        if(userAdmin.getRole().equalsIgnoreCase("admin")){
            User user = new User(firstName, lastName, email, role, password);
            service.addUser(user);
            return "SUCCESS";
        } else {
            return "NOT QUALIFIED";
        }
    }

    @GetMapping("/users/{userId}")
    public List<User> showUsers(@PathVariable Integer userId){
        User userAdmin = service.getUserById(userId);
        if(userAdmin.getRole().equalsIgnoreCase("admin")){
            return service.getAllUsers();
        } else {
            return null;
        }
    }

    @PostMapping("/edituser/{id}")
    public String editUser(@PathVariable Integer id, int userId, String firstName, String lastName, String email, String role, String password){
        User userAdmin = service.getUserById(id);
        if(userAdmin.getRole().equalsIgnoreCase("admin")){
            User user = new User(userId, firstName, lastName, email, role, password);
            service.editUser(user);
            return "SUCCESS";
        } else {
            return "NOT QUALIFIED";
        }
    }

    @PostMapping("/changepassword/{userId}")
    public String changePassword(@PathVariable Integer userId, @RequestParam("userId") int id, @RequestParam("password") String password){
        User userAdmin = service.getUserById(userId);
        if(userAdmin.getRole().equalsIgnoreCase("admin") || userAdmin.getRole().equalsIgnoreCase("sales")){
            service.changePassword(id, password);
            return "SUCCESS";
        } else {
            return "NOT QUALIFIED";
        }
    }

    @PostMapping("/purchase/{index}/{userId}")
    public String addPurchase(@PathVariable Integer index,
                              @PathVariable Integer userId,
                              String name, String phone,
                              String email, String street1,
                              String street2, String city,
                              String state, String zip,
                              String type){
        User userAdmin = service.getUserById(userId);
        if (userAdmin.getRole().equalsIgnoreCase("sales")) {
            Date date = new Date(System.currentTimeMillis());
            Purchase purchase = new Purchase(name, phone, email, street1, street2, city, state, zip, type, date, index);
            service.addPurchase(purchase);
            return "SUCCESS";
        } else {
            return "NOT QUALIFIED";
        }
    }

    @GetMapping("/showpurchase/{userId}")
    public List<Purchase> showPurchases(@PathVariable int userId){
        User userAdmin = service.getUserById(userId);
        if (userAdmin.getRole().equalsIgnoreCase("admin")) {
            return service.getAllPurchase();
        } else {
            return null;
        }
    }
}
