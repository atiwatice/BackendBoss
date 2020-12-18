package com.boss.backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.UserDao;
import com.boss.backend.model.DAOUser;
import com.boss.backend.model.UserDTO;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	@Autowired
	public UserService(UserDao repository) {
		this.userDao = repository;
	}
	
	public List<DAOUser> retrieveUser(){
		return (List<DAOUser>) userDao.findAll();
	}
	
	public Optional<DAOUser> retrieveUser(String username){
		return Optional.ofNullable(userDao.findByUsername(username));
	}
	
	public Optional<DAOUser> findUserId(int userId){
		return Optional.ofNullable(userDao.findByUserId(userId));
	}
	
	
	public DAOUser updateUser(int id, UserDTO user){
		DAOUser usernameIn = userDao.findById(id);
		if(usernameIn==null) {
			return usernameIn;
		}
		
		if (user.getUsername() != null)
			usernameIn.setUsername(user.getUsername());
		if (user.getPassword() != null)
			usernameIn.setPassword(bcryptEncoder.encode(user.getPassword()));
		if (user.getFirstname() != null)
			usernameIn.setFirstname(user.getFirstname());
		if (user.getLastname() != null)
			usernameIn.setLastname(user.getLastname());
		if (user.getAddress() != null)
			usernameIn.setAddress(user.getAddress());
		if (user.getEmail() != null)
			usernameIn.setEmail(user.getEmail());
		if (user.getMobileNo() != null)
			usernameIn.setMobileNo(user.getMobileNo());
		if (user.getCompanyId() != null)
			usernameIn.setCompanyId(user.getCompanyId());
		
		
		return userDao.save(usernameIn);
	}
	
}
