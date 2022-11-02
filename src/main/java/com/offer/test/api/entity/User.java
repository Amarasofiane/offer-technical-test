package com.offer.test.api.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.offer.test.api.dto.UserDTO;
import com.offer.test.api.enums.Gender;

@Entity
@Table(name = "user_register")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_register_id", unique = true, nullable = false)
	private Long userRegisterId;
	@Column(name = "user_name")
	private String userName;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "gender")
	private Gender gender;
	@Column(name = "country")
	private String country;
	@Column(name = "email")
	private String email;
	@Column(name = "phone_number")
	private int phone;

	public Long getUserRegisterId() {
		return userRegisterId;
	}

	public void setUserRegisterId(Long userRegisterId) {
		this.userRegisterId = userRegisterId;
	}

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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserDTO convertUserToUserDTO(User user) {
		UserDTO userDTO = new UserDTO();
		userDTO.setBirthDate(user.getBirthDate());
		userDTO.setCountry(user.getCountry());
		userDTO.setGender(user.getGender());
		userDTO.setEmail(user.getEmail());
		userDTO.setPhone(user.getPhone());
		userDTO.setUserName(user.getUserName());
		return userDTO;
	}

}
