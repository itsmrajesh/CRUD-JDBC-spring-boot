package com.contact.jdbcapp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import com.contact.jdbcapp.domain.Contact;

@Component
public class DaoImpl implements Dao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Contact addContact(Contact contact) {
		String addQuery = "INSERT INTO CONTACTS VALUES (?,?,?)";
		int count = jdbcTemplate.update(addQuery, contact.getName(), contact.getPhno(), contact.getEmail());
		return count == 1 ? contact : null;
	}

	@Override
	public List<Contact> getAllContacts() {
		String getAllQuery = "SELECT * FROM CONTACTS";
		List<Contact> list = jdbcTemplate.query(getAllQuery,
				(rs, rowNum) -> new Contact(rs.getString("name"), rs.getString("phno"), rs.getString("email")));
		return list;
	}

	@Override
	public Contact getContactByPhno(String phno) {
		String getContactQuery = "SELECT * FROM CONTACTS WHERE PHNO = ?";
		Contact contact = jdbcTemplate.queryForObject(getContactQuery, new Object[] { phno },
				(rs, rowNum) -> new Contact(rs.getString("name"), rs.getString("phno"), rs.getString("email")));
		return contact;
	}

	@Override
	public List<Contact> getContactByName(String name) {
		String getByName = "SELECT * FROM CONTACTS WHERE NAME like ?";
		List<Contact> list = jdbcTemplate.query(getByName, new Object[] { "%" + name + "%" },
				(rs, rowNum) -> new Contact(rs.getString("name"), rs.getString("phno"), rs.getString("email")));
		return list;
	}

	@Override
	public Contact updateContact(Contact contact, String phno) {
		String updateQuery = "UPDATE CONTACTS SET NAME = ?, PHNO = ? , EMAIL = ? WHERE PHNO = ?";
		int count = jdbcTemplate.update(updateQuery, contact.getName(), contact.getPhno(), contact.getEmail(), phno);
		return count == 1 ? contact : null;
	}

	@Override
	public int getContactsCount() {
		String sql = "select count(*) from contacts";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

}
