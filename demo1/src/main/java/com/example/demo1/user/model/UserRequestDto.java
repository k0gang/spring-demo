package com.example.demo1.user.model;

import java.sql.Timestamp;

public class UserRequestDto {

	private int code;
	private String userName;
	private String password;
	private String firstName;
	private String email;
	private Timestamp regDate;
	private Timestamp modDate;

	public UserRequestDto() {
		
	}
	
	public UserRequestDto(String userName, String password, String firstName, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.email = email;
	}

	public UserRequestDto(int code, String userName, String password, String firstName, String email, Timestamp regDate,
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

	public void setCode(int code) {
		this.code = code;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public Timestamp getModDate() {
		return modDate;
	}

	public void setModDate(Timestamp modDate) {
		this.modDate = modDate;
	}

}