package com.offer.test.api.services;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offer.test.api.dto.UserDTO;
import com.offer.test.api.entity.User;
import com.offer.test.api.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	public boolean isValidUserRegister(UserDTO userDTO) {

		try {
			boolean bValidAgeAndCountry = false;
			if (userDTO.getBirthDate() != null && userDTO.getCountry() != null && !userDTO.getCountry().isEmpty()) {
				LocalDate start = userDTO.getBirthDate().toLocalDate();
				LocalDate end = LocalDate.now();
				long years = ChronoUnit.YEARS.between(start, end);
				bValidAgeAndCountry = years >= 18 && userDTO.getCountry().equals("France") ? true : false;

				if (userDTO.getEmail() != null && userRepository.findByEmail(userDTO.getEmail()).isEmpty()
						&& bValidAgeAndCountry) {

					return true;

				}
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public void saveUserRegister(UserDTO userDto) {
		User userToSave = userDto.convertUserDTOToUser(userDto);
		userRepository.save(userToSave);
	}

	@Transactional
	public UserDTO getUserByEmail(String email) {
		try {
			User user = userRepository.findByEmail(email).get();
			return user.convertUserToUserDTO(user);
		} catch (Exception e) {
			return null;
		}
	}

	@Transactional
	public List<UserDTO> getAllUsersRegistred() {

		List<UserDTO> allUsersDTO = new ArrayList<>();
		List<User> allUsers = userRepository.findAll();
		if (allUsers.size() > 0) {
			allUsers.forEach(user -> {
				allUsersDTO.add(user.convertUserToUserDTO(user));
			});
		}
		return allUsersDTO;

	}
}
