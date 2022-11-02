package com.offer.test.api.dto;

import java.sql.Date;

import com.offer.test.api.entity.User;
import com.offer.test.api.enums.Gender;

public class UserDTO {

	private String userName;
	private Date birthDate;
	private Gender gender;
	private String country;
	private String email;
	private int phone;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public User convertUserDTOToUser(UserDTO userDTO) {
		User user = new User();
		user.setBirthDate(userDTO.getBirthDate());
		user.setCountry(userDTO.getCountry());
		user.setGender(userDTO.getGender());
		user.setEmail(userDTO.getEmail());
		user.setPhone(userDTO.getPhone());
		user.setUserName(userDTO.getUserName());
		return user;
	}
}
