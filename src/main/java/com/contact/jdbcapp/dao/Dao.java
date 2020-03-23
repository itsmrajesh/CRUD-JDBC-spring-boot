package com.contact.jdbcapp.dao;

import java.util.List;

import com.contact.jdbcapp.domain.Contact;

public interface Dao {

	Contact addContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactByPhno(String phno);

	List<Contact> getContactByName(String name);

	Contact updateContact(Contact contact, String phno);

	int getContactsCount();

}
