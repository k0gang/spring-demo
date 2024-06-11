package com.example.demo1.user.model;

import java.sql.Timestamp;

public class User {
	// code, user_name, password, first_name, email, reg_date, mod_date
	private int code;
	private String userName;
	private String password;
	private String firstName;
	private String email;
	private Timestamp regDate;
	private Timestamp modDate;

	public User(int code, String userName, String password, String firstName, String email, Timestamp regDate,
			Timestamp modDate) {
		super();
		this.code = code;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
		this.regDate = regDate;
		this.modDate = modDate;
	}

	public int getCode() {
		return code;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getEmail() {
		return email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

}
