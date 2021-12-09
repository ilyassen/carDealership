/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dto;

/**
 *
 * @author Fishget
 */
public class MakeModel {

    private String make;
    private String model;
    private String date;
    private String email;

    public MakeModel() {
    }


    public MakeModel(String make, String model, String date, String email) {
        this.make = make;
        this.model = model;
        this.date = date;
        this.email = email;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getDate() {
        return date;
    }

    public String getEmail() {
        return email;
    }





}
