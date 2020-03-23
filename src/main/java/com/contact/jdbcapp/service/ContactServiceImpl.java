package com.contact.jdbcapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.contact.jdbcapp.dao.Dao;
import com.contact.jdbcapp.domain.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private Dao dao;

	@Override
	public Contact addContact(Contact contact) {
		Assert.notNull(contact, "Contact object cannot be null");
		return dao.addContact(contact);
	}

	@Override
	public List<Contact> getAllContacts() {
		return dao.getAllContacts();

	}

	@Override
	public Contact getContactByPhno(String phno) {
		if (phno.length() > 9) {
			return dao.getContactByPhno(phno);
		}
		return null;
	}

	@Override
	public List<Contact> getContactByName(String name) {
		if (!name.equalsIgnoreCase("")) {
			return dao.getContactByName(name);
		}
		return null;
	}

	@Override
	public Contact updateContact(Contact contact, String phno) {
		Contact myContact = getContactByPhno(phno);
		if (myContact != null) {
			dao.updateContact(contact, phno);
		}
		return null;
	}

	@Override
	public int getContactsCount() {
		return dao.getContactsCount();
	}

}
