package com.contact.jdbcapp.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

	private String name;
	private String phno;
	private String email;

	public void displayContact() {
		System.out.println("-----------");
		System.out.println("Name : " + name);
		System.out.println("Phone Number : " + phno);
		System.out.println("Email : " + email);
		System.out.println("-----------");
	}

}
