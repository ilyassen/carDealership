/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.dto.Contact;
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
public class ContactDB implements ContactDao{

    @Autowired
    JdbcTemplate jdbc;

     public static final class ContactMapper implements RowMapper<Contact> {
        @Override
        public Contact mapRow(ResultSet rs, int index) throws SQLException {
            Contact contact = new Contact();
            contact.setContactId(rs.getInt("contactId"));
            contact.setName(rs.getString("name"));
            contact.setEmail(rs.getString("email"));
            contact.setPhone(rs.getString("phone"));
            contact.setMessage(rs.getString("message"));
            return contact;
        }
    }

    public List<Contact> getAllContacts() {
        final String SELECT_ALL_CONTACTS = "SELECT * FROM contact";
        return jdbc.query(SELECT_ALL_CONTACTS, new ContactMapper());
    }


    public Contact getContactById(int contactId) {
        try {
            final String SELECT_CONTACT_BY_ID = "SELECT * FROM contact WHERE contactId = ?";
            return jdbc.queryForObject(SELECT_CONTACT_BY_ID, new ContactMapper(), contactId);
        } catch(DataAccessException ex) {
            return null;
        }
    }
    @Transactional
    public Contact addContact(Contact contact) {

        final String INSERT_CONTACT = "INSERT INTO contact(name, email, phone,message) VALUES(?,?,?,?)";
        jdbc.update(INSERT_CONTACT, contact.getName(), contact.getEmail(), contact.getPhone(), contact.getMessage());
        int newContactId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        contact.setContactId(newContactId);
        return getContactById(newContactId);
    }

}
