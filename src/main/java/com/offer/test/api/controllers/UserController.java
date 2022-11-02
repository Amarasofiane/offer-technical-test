package com.offer.test.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.offer.test.api.dto.UserDTO;
import com.offer.test.api.services.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("api/users")
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);


	@Autowired
	private UserService userRepositoryService;

	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> registerUser(@RequestBody UserDTO userDTO) {
		LOGGER.info("register  user");
		Map<String, String> response = new HashMap<>();
		if (userRepositoryService.isValidUserRegister(userDTO)) {
			userRepositoryService.saveUserRegister(userDTO);
			response.put("ok", "registered user");
			return ResponseEntity.ok(response);
		}
		response.put("error", "invalid user or not authorized");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}

	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getUserRegistred() {
		LOGGER.info("get all users");
		return ResponseEntity.ok(userRepositoryService.getAllUsersRegistred());
	}

	@GetMapping("/email/{name}")
	public ResponseEntity<?> findUserByEmail(@PathVariable("name") String email) {
		LOGGER.info("get user by email");

		UserDTO userDto = userRepositoryService.getUserByEmail(email);
		if (userDto == null) {
			LOGGER.error("not find user");
			Map<String, String> response = new HashMap<>();
			response.put("error", "user does not exist");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		return ResponseEntity.ok(userDto);
	}
}
