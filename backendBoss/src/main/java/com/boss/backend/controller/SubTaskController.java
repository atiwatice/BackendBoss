package com.boss.backend.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.model.DAOSubTask;
import com.boss.backend.model.SubTaskDTO;
import com.boss.backend.service.SubTaskService;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:3005", maxAge = 3600)
@RestController
public class SubTaskController {
	@Autowired
	SubTaskService subTaskService;
	
	// Add new request
	@RequestMapping(value = "/insertNewSubTask", method = RequestMethod.POST)
	public ResponseEntity<?> addSubTask(@RequestBody SubTaskDTO subtask) throws Exception {

		JSONObject responseJson = new JSONObject();

		try {
			subTaskService.save(subtask);
			responseJson.put("status", "New sub Task is inserted");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		} catch (ParseException e) {
			responseJson.put("status", "new sub task error");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

	}
	
	@PutMapping("/updateSubTask/{id}")
	public ResponseEntity<?> updateSubTask(@RequestBody SubTaskDTO subtask, @PathVariable int id) throws Exception {
		DAOSubTask updateSubTaskNew = subTaskService.updateSubTask(id, subtask);
		JSONObject responseJson = new JSONObject();

		if (updateSubTaskNew == null) {
			responseJson.put("status", "Not found this subTask");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("status", "Update complete");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteSubTask/{id}")
	public ResponseEntity<?> deleteSubTask(@PathVariable int id) {
		Optional<DAOSubTask> CheckSubTaskId = subTaskService.findSubTaskById(id);
		JSONObject responseJson = new JSONObject();
		if (!CheckSubTaskId.isPresent()) {
			responseJson.put("status", "Not Found this sub Task");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		subTaskService.deleteSubTask(id);
		responseJson.put("status", "Sub Task " + id + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	@GetMapping("/getAllSubTask/{taskId}")
	public List<DAOSubTask> getAllSubTask(@PathVariable(value = "taskId") int taskId) {
		return subTaskService.findAllSubTask(taskId);
	}
	


}
