/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dto;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Fishget
 */
public class Purchase {
    private int purchaseId;
    private String customerName;
    private String customerPhone;
    private String customerEmail;
    private String customerStreet1;
    private String customerStreet2;
    private String customerCity;
    private String customerState;
    private String customerZip;
    private String purchaseType;
    private Date purchaseTime;
    private int carId;

    public Purchase(){

    }

    public Purchase(String customerName, String customerPhone, String customerEmail, String customerStreet1, String customerStreet2, String customerCity, String customerState, String customerZip, String purchaseType, Date purchaseTime, int carId) {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerStreet1 = customerStreet1;
        this.customerStreet2 = customerStreet2;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerZip = customerZip;
        this.purchaseType = purchaseType;
        this.purchaseTime = purchaseTime;
        this.carId = carId;
    }

    public Purchase(int purchaseId, String customerName, String customerPhone, String customerEmail, String customerStreet1, String customerStreet2, String customerCity, String customerState, String customerZip, String purchaseType, Date purchaseTime, int carId) {
        this.purchaseId = purchaseId;
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerStreet1 = customerStreet1;
        this.customerStreet2 = customerStreet2;
        this.customerCity = customerCity;
        this.customerState = customerState;
        this.customerZip = customerZip;
        this.purchaseType = purchaseType;
        this.purchaseTime = purchaseTime;
        this.carId = carId;
    }

    public int getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerStreet1() {
        return customerStreet1;
    }

    public void setCustomerStreet1(String customerStreet1) {
        this.customerStreet1 = customerStreet1;
    }

    public String getCustomerStreet2() {
        return customerStreet2;
    }

    public void setCustomerStreet2(String customerStreet2) {
        this.customerStreet2 = customerStreet2;
    }

    public String getCustomerCity() {
        return customerCity;
    }

    public void setCustomerCity(String customerCity) {
        this.customerCity = customerCity;
    }

    public String getCustomerState() {
        return customerState;
    }

    public void setCustomerState(String customerState) {
        this.customerState = customerState;
    }

    public String getCustomerZip() {
        return customerZip;
    }

    public void setCustomerZip(String customerZip) {
        this.customerZip = customerZip;
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }

    public Date getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(Date purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Purchase purchase = (Purchase) o;
        return purchaseId == purchase.purchaseId && carId == purchase.carId && Objects.equals(customerName, purchase.customerName) && Objects.equals(customerPhone, purchase.customerPhone) && Objects.equals(customerEmail, purchase.customerEmail) && Objects.equals(customerStreet1, purchase.customerStreet1) && Objects.equals(customerStreet2, purchase.customerStreet2) && Objects.equals(customerCity, purchase.customerCity) && Objects.equals(customerState, purchase.customerState) && Objects.equals(customerZip, purchase.customerZip) && Objects.equals(purchaseType, purchase.purchaseType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(purchaseId, customerName, customerPhone, customerEmail, customerStreet1, customerStreet2, customerCity, customerState, customerZip, purchaseType, purchaseTime, carId);
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "purchaseId=" + purchaseId +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", customerStreet1='" + customerStreet1 + '\'' +
                ", customerStreet2='" + customerStreet2 + '\'' +
                ", customerCity='" + customerCity + '\'' +
                ", customerState='" + customerState + '\'' +
                ", customerZip='" + customerZip + '\'' +
                ", purchaseType='" + purchaseType + '\'' +
                ", purchaseTime=" + purchaseTime +
                ", carId=" + carId +
                '}';
    }
}
