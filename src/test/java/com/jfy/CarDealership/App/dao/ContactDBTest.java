package com.jfy.CarDealership.App.dao;

import com.jfy.CarDealership.App.TestApplicationConfiguration;
import com.jfy.CarDealership.App.dto.Contact;
import com.jfy.CarDealership.App.dto.MakeModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ComponentScan("com.jfy")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestApplicationConfiguration.class)
class ContactDBTest {

  @Autowired
  ContactDao contactDao;


    @BeforeEach
    void setUp() {
    }


    @org.junit.jupiter.api.Test
    void getContactById() {

      Contact contact = new Contact();
      contact.setContactId(1);
      contact.setEmail("test@test.com");
      contact.setMessage("test text");
      contact.setName("test");
      contact.setPhone("514999999");

      Contact expected = contactDao.getContactById(1);

      assertTrue(expected.equals(contact));
    }

    @org.junit.jupiter.api.Test
    void addContact() {

      Contact contact = new Contact();
      contact.setContactId(2);
      contact.setEmail("test@test.com");
      contact.setMessage("test text");
      contact.setName("test");
      contact.setPhone("514999999");

      Contact expected = contactDao.addContact(contact);

      assertTrue(expected.equals(contact));

    }
}
