package com.contact.jdbcapp;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.contact.jdbcapp.domain.Contact;
import com.contact.jdbcapp.service.ContactService;

@SpringBootApplication
public class JdbcappApplication implements CommandLineRunner {

	@Autowired
	private ContactService cs;

	public static void main(String[] args) {
		SpringApplication.run(JdbcappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		while (true) {
			System.out.println("Welcome to contact application...");
			System.out.println("1.View All 2.Add 3.update 4.search by name 5.search by number 6.All Contacts count");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				List<Contact> list = cs.getAllContacts();
				for (Contact c : list) {
					c.displayContact();
				}
				break;

			case 2:
				System.out.println("Add Contact");
				sc.nextLine();
				System.out.println("Enter name");
				String name = sc.nextLine();
				System.out.println("Enter Phone number");
				String phno = sc.next();
				System.out.println("Enter Email ");
				String email = sc.next();
				Contact con = new Contact(name, phno, email);
				if (cs.addContact(con) != null)
					System.out.println("Contact added successfully... with details : " + con);
				else {
					System.out.println("Contact already exixts try update instead");
					cs.getContactByPhno(phno).displayContact();
				}
				break;
			case 3:
				System.out.println("Update contact");
				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter name ");
				String searchName = sc.nextLine();
				List<Contact> searchList = cs.getContactByName(searchName);
				for (Contact c : searchList) {
					c.displayContact();
				}
				break;
			case 5:
				sc.nextLine();
				System.out.println("Enter number");
				String searchNumber = sc.next();
				Contact searchContact = cs.getContactByPhno(searchNumber);
				if (searchContact != null)
					searchContact.displayContact();
				else
					System.out.println("No Contact fount with given number " + searchNumber);
				break;
			case 6:
				System.out.println("Total Contacts count : " + cs.getContactsCount());
				break;

			default:
				break;
			}
		}
	}
}
