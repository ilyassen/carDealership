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
public class Contact {
    private int contactId;
    private String name;
    private String email;
    private String phone;
    private String message;

    public Contact(){

    }
    public Contact(String name, String email, String phone,String message){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.message = message;
    }

    public int getContactId(){
        return contactId;
    }

    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getMessage(){
        return message;
    }

    public void setContactId(int contactId){
        this.contactId=contactId;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setMessage(String message){
        this.message = message;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Contact contact = (Contact) o;
    return contactId == contact.contactId &&
      Objects.equals(name, contact.name) &&
      Objects.equals(email, contact.email) &&
      Objects.equals(phone, contact.phone) &&
      Objects.equals(message, contact.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contactId, name, email, phone, message);
  }
}
