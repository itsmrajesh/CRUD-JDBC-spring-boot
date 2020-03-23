package com.contact.jdbcapp.service;

import java.util.List;

import com.contact.jdbcapp.domain.Contact;

public interface ContactService {

	Contact addContact(Contact contact);

	List<Contact> getAllContacts();

	Contact getContactByPhno(String phno);

	List<Contact> getContactByName(String name);

	Contact updateContact(Contact contact, String phno);

	int getContactsCount();

}
