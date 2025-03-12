package com.stackbill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackbill.businesslogic.UserService;
import com.stackbill.entitys.UserEntity;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*") // Base URI for Pojo entity
public class UserControl {

	@Autowired
	private UserService serviceMain;

	// Endpoint to fetch all users
	@GetMapping
	public ResponseEntity<List<UserEntity>> getAllUsers() {
		List<UserEntity> users = serviceMain.getAllPojos();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// Endpoint to fetch user by ID
	@GetMapping("/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable int id) {
		UserEntity user = serviceMain.getPojoById(id).orElse(null);
		if (user != null) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to create a new user
	@PostMapping()
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {
		UserEntity createdUser = serviceMain.createPojo(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	// Endpoint to update an existing user
	@PutMapping("/{id}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable int id, @RequestBody UserEntity userDetails) {
		UserEntity updatedUser = serviceMain.updatePojo(id, userDetails);
		if (updatedUser != null) {
			return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// Endpoint to delete a user by ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable int id) {
		serviceMain.deletePojo(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/get-Login-authentication")
	public UserEntity getUserById(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		return serviceMain.getloginauthetiction(username, password);
	}
}
