package com.boss.backend.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.dao.UserDao;
import com.boss.backend.model.CompanyReposity;
import com.boss.backend.model.DAOCompany;
import com.boss.backend.model.DAOUser;

@RestController
public class HelloWorldController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CompanyReposity companyRepo;
	

//    @GetMapping("/getAllUser") 
//    public List<DAOUser> getAllUser() 
//    { 
//        return userDao.findAll(); 
//    } 
//
//    
//    // Get the company details by 
//    // ID 
//    @GetMapping("/getAllUser/{username}") 
//    public DAOUser getUserByUsername( 
//        @PathVariable(value = "username") String username) 
//    { 
//        return userDao.findByUsername(username); 
//    } 
    

    @GetMapping("/getAllCompany") 
    public List<DAOCompany> getAllCompany() 
    { 
        return companyRepo.findAll(); 
    } 
//	
//	@RequestMapping({ "/hello" })
//	public String firstPage() {
//		
//		return "Hello World";
//	}
}
