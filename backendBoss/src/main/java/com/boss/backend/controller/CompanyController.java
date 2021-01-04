package com.boss.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.model.CompanyDTO;
import com.boss.backend.model.DAOCompany;
import com.boss.backend.service.CompanyService;

import net.minidev.json.JSONObject;


@CrossOrigin(origins = "http://localhost:3005", maxAge = 3600)
@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;

	// Get All company
	@GetMapping("/getCompanies")
	public List<DAOCompany> getAllUser() {
		return companyService.retrieveCompany();
	}
	
	// Get the company name and detail by id
	@GetMapping("/getCompanies/{companyId}")
	public ResponseEntity<?> getUserByUsername(@PathVariable(value = "companyId") int companyId) {
		Optional<DAOCompany> company = Optional.ofNullable(companyService.findCompanyId(companyId));
		JSONObject responseJson = new JSONObject();
		if (!company.isPresent()) {
			responseJson.put("status", "Not Found this company");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}
		
		DAOCompany companyDetail = companyService.findCompanyId(companyId);
		responseJson.put("Output", companyDetail);
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	// Add new company
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public ResponseEntity<?> addCompany(@RequestBody CompanyDTO company) {
		Optional<DAOCompany> findCompanyName = Optional.ofNullable(companyService.findCompanyName(company.getCompanyName()));
		JSONObject responseJson = new JSONObject();

		if (findCompanyName.isPresent()) {
			responseJson.put("status", "This company already exist.");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}
		
		companyService.save(company);
		responseJson.put("status", "Company " +company.getCompanyName()+" is added.");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCompany/{companyName}")
	public ResponseEntity<?> deleteUser(@PathVariable String companyName) {
		Optional<DAOCompany> CheckCompanyName = Optional.ofNullable(companyService.findCompanyName(companyName));
		JSONObject responseJson = new JSONObject();

		if (!CheckCompanyName.isPresent()) {
			responseJson.put("status", "This company don't exist.");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}
		DAOCompany companyValue = companyService.findCompanyName(companyName);
		
		companyService.deleteCompanyId(companyValue.getCompanyId());
		responseJson.put("status", "UserId " + companyName + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	
}
