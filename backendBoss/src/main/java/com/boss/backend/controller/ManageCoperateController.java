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

import com.boss.backend.model.DAOManageCoperate;
import com.boss.backend.model.DAOUser;
import com.boss.backend.model.ManageCoperateDTO;
import com.boss.backend.service.ManageCoperateService;
import com.boss.backend.service.UserService;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:3005", maxAge = 3600)
@RestController
public class ManageCoperateController {

	@Autowired
	private ManageCoperateService manageCoperateService;

	@Autowired
	UserService userService;

	// Add new request
	@RequestMapping(value = "/requestCoperate", method = RequestMethod.POST)
	public ResponseEntity<?> addCompany(@RequestBody ManageCoperateDTO coperate) {

		DAOUser accepterId = coperate.getAccepterId();
		DAOUser requesterId = coperate.getRequesterId();

		Optional<DAOUser> CheckRequesterId = userService.findUserId(requesterId.getUserId());
		Optional<DAOUser> CheckAccepterId = userService.findUserId(accepterId.getUserId());

		JSONObject responseJson = new JSONObject();
		if (!(CheckRequesterId.isPresent() && CheckAccepterId.isPresent())) {
			responseJson.put("status", "RequesterID or AccepterID is not exist");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		}

		manageCoperateService.save(coperate);
		responseJson.put("status",
				"Requester ID " + requesterId.getUserId() + " request to Accepeter ID " + accepterId.getUserId());
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	// Get the getAllCoperate COPERATE
	@GetMapping("/getAllCoperate/{coperateId}")
	public List<DAOManageCoperate> getCoperate(@PathVariable(value = "coperateId") int coperateId) {
		return manageCoperateService.findCoperate(coperateId, coperateId);
	}

	// Get the getAllCoperate WAIT_CONFIRM
	@GetMapping("/getAllWaitConfirm/{coperateId}")
	public List<DAOManageCoperate> getWaitConfirm(@PathVariable(value = "coperateId") int coperateId) {
		return manageCoperateService.findWaitConfirm(coperateId);
	}
	
	//confirm request
	@RequestMapping(value = "/confirmRequest/{ownerId}/{requestUser}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStatusCoperate(@PathVariable(value = "ownerId") int ownerId, @PathVariable(value = "requestUser") String requestUser) {
		DAOManageCoperate manageCoperate = manageCoperateService.updateStatusCoperate(ownerId, requestUser);
		JSONObject responseJson = new JSONObject();
		
		if(manageCoperate == null) {
			responseJson.put("status", "Not found this request");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		}
		responseJson.put("status", "User "+requestUser+" is accepted.");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	//delete request
	@DeleteMapping("/deleteRequest/{ownerId}/{confirmUser}")
	public ResponseEntity<?> cancelRequest(@PathVariable(value = "ownerId") int ownerId, @PathVariable(value = "confirmUser") String confirmUser) {
		DAOManageCoperate manageCoperate = manageCoperateService.cancelRequest(ownerId, confirmUser);
		JSONObject responseJson = new JSONObject();
		if(manageCoperate == null) {
			responseJson.put("status", "Not found this request");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		}
		
		responseJson.put("status", "Request from " + confirmUser + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	//delete request
		@DeleteMapping("/deleteCoperate/{ownerId}/{confirmUser}")
		public ResponseEntity<?> deleteCoperate(@PathVariable(value = "ownerId") int ownerId, @PathVariable(value = "confirmUser") String confirmUser) {
			DAOManageCoperate manageCoperate = manageCoperateService.deleteCoperate(ownerId, confirmUser);
			JSONObject responseJson = new JSONObject();
			if(manageCoperate == null) {
				responseJson.put("status", "Not found this request");
				return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
			}
			
			responseJson.put("status", "Request from " + confirmUser + " is deleted");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		}
	
	
	
}
