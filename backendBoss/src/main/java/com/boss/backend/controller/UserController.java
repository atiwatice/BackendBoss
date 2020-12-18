package com.boss.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.dao.UserDao;
import com.boss.backend.model.DAOUser;
import com.boss.backend.model.UserDTO;
import com.boss.backend.service.UserService;

import net.minidev.json.JSONObject;

@RestController
public class UserController {
	@Autowired
	private UserDao userDao;

	@Autowired
	UserService userService;
	
	@GetMapping("/hello")
	ResponseEntity<String> hello() {
		return new ResponseEntity<>("Hello World!", HttpStatus.BAD_REQUEST);
	}

	// Get All user
	@GetMapping("/getUsers")
	public List<DAOUser> getAllUser() {
		return userService.retrieveUser();
	}

	// Get the user id by user name
	@GetMapping("/getUsers/{username}")
	public ResponseEntity<?> getUserByUsername(@PathVariable(value = "username") String username) {
		Optional <DAOUser>  user = userService.retrieveUser(username);
		JSONObject responseJson = new JSONObject();
		if(!user.isPresent()) {
			responseJson.put("status", "Not Found this usernames");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}
			 
		responseJson.put("status", "Found username "+username);
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

//	
//	@PutMapping("/putUserID/{id}")
//	public ResponseEntity<?> updateUser(@RequestBody UserDTO user, @PathVariable int id) {
//		DAOUser usernameIn = userDao.findById(id);
//		JSONObject responseJson = new JSONObject();
//
//		if (usernameIn == null) {
//			responseJson.put("status", "Not found this ID");
//			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
//		}
//		if (user.getUsername() != null)
//			usernameIn.setUsername(user.getUsername());
//		if (user.getPassword() != null)
//			usernameIn.setPassword(bcryptEncoder.encode(user.getPassword()));
//		if (user.getFirstname() != null)
//			usernameIn.setFirstname(user.getFirstname());
//		if (user.getLastname() != null)
//			usernameIn.setLastname(user.getLastname());
//		if (user.getAddress() != null)
//			usernameIn.setAddress(user.getAddress());
//		if (user.getEmail() != null)
//			usernameIn.setEmail(user.getEmail());
//		if (user.getMobile_no() != null)
//			usernameIn.setMobile_no(user.getMobile_no());
//		if (user.getCOMPANY_ID() != null)
//			usernameIn.setCompany_id(user.getCOMPANY_ID());
//
//		userDao.save(usernameIn);
//
//		responseJson.put("status", "Update complete");
//		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
//	}

	
	@PutMapping("/putUserID/{id}")
	public ResponseEntity<?> updateUser(@RequestBody UserDTO user, @PathVariable int id) {
		DAOUser usernameIn = userService.updateUser(id,user);
		JSONObject responseJson = new JSONObject();

		if (usernameIn == null) {
			responseJson.put("status", "Not found this ID");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("status", "Update complete");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	
	
	@DeleteMapping("/deleteUser/{id}")
	public void deleteUser(@PathVariable int id) {
		userDao.deleteById(id);
	}

}
