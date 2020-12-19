package com.boss.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.model.DAOUser;
import com.boss.backend.model.UserDTO;
import com.boss.backend.service.UserService;

import net.minidev.json.JSONObject;

@RestController
public class UserController {

	@Autowired
	UserService userService;


	// Get All user
	@GetMapping("/getUsers")
	public List<DAOUser> getAllUser() {
		return userService.retrieveUser();
	}

	// Get the user detail by user name
	@GetMapping("/getUsers/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable(value = "username") String username) {
		Optional<DAOUser> user = userService.retrieveUser(username);
		JSONObject responseJson = new JSONObject();
		if (!user.isPresent()) {
			responseJson.put("status", "Not Found this usernames");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("Output", user);
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	@PutMapping("/putUserID/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user, @PathVariable int id) {
		DAOUser usernameIn = userService.updateUser(id, user);
		JSONObject responseJson = new JSONObject();

		if (usernameIn == null) {
			responseJson.put("status", "Not found this ID");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("status", "Update complete");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) {
		Optional<DAOUser> CheckuserId = userService.findUserId(id);
		JSONObject responseJson = new JSONObject();
		if (!CheckuserId.isPresent()) {
			responseJson.put("status", "Not Found this userId");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		userService.deleteUser(id);
		responseJson.put("status", "UserId " + id + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

}
