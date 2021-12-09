package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Contact;

import java.util.List;

/**
 * @author Andong
 * @create 2021-12-04-11:55
 */
public interface ContactDao {

    List<Contact> getAllContacts();

    Contact getContactById(int contactId);

    Contact addContact(Contact contact);
}
