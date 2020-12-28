package com.boss.backend.controller;

import java.text.ParseException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.boss.backend.model.DAOTask;
import com.boss.backend.model.TaskDTO;
import com.boss.backend.service.TaskService;
import com.boss.backend.service.UserService;

import net.minidev.json.JSONObject;

@RestController
public class TaskController {
	@Autowired
	TaskService taskService;

	@Autowired
	UserService userService;

	// Add new request
	@RequestMapping(value = "/insertNewTask", method = RequestMethod.POST)
	public ResponseEntity<?> addTask(@RequestBody TaskDTO task) throws Exception {

		JSONObject responseJson = new JSONObject();

		try {
			taskService.save(task);
			responseJson.put("status", "Task is Updated");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		} catch (ParseException e) {
			responseJson.put("status", "Update task error");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateTask/{id}")
	public ResponseEntity<?> updateTask(@RequestBody TaskDTO task, @PathVariable int id) throws Exception {
		DAOTask updateTaskNew = taskService.updateTask(id, task);
		JSONObject responseJson = new JSONObject();

		if (updateTaskNew == null) {
			responseJson.put("status", "Not found this Task");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("status", "Update complete");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteTask/{id}")
	public ResponseEntity<?> deleteTask(@PathVariable int id) {
		Optional<DAOTask> CheckTaskId = taskService.findTaskById(id);
		JSONObject responseJson = new JSONObject();
		if (!CheckTaskId.isPresent()) {
			responseJson.put("status", "Not Found this Task");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		taskService.deleteTask(id);
		responseJson.put("status", "Task " + id + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}
	

	@GetMapping("/getAllTask/{ownerId}")
	public List<DAOTask> getAllTask(@PathVariable(value = "ownerId") int ownerId) {
		return taskService.findAllTask(ownerId);
	}
	
	@GetMapping("/getAllInprocessTask/{ownerId}")
	public List<DAOTask> findInprocessTask(@PathVariable(value = "ownerId") int ownerId) {
		return taskService.findInprocessTask(ownerId);
	}
	
	@GetMapping("/getAllCompleteTask/{ownerId}")
	public List<DAOTask> findCompleteTask(@PathVariable(value = "ownerId") int ownerId) {
		return taskService.findCompleteTak(ownerId);
	}
	
}
