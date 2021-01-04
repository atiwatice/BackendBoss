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

import com.boss.backend.model.CommentDTO;
import com.boss.backend.model.DAOComment;
import com.boss.backend.service.CommentService;

import net.minidev.json.JSONObject;

@CrossOrigin(origins = "http://localhost:3005", maxAge = 3600)
@RestController
public class CommentController {
	@Autowired
	CommentService commentService;

	// Add new comment
	@RequestMapping(value = "/insertNewComment", method = RequestMethod.POST)
	public ResponseEntity<?> addComment(@RequestBody CommentDTO comment) throws Exception {

		JSONObject responseJson = new JSONObject();

		try {
			commentService.save(comment);
			responseJson.put("status", "New comment is inserted");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
		} catch (ParseException e) {
			responseJson.put("status", "new comment error");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/updateComment/{id}")
	public ResponseEntity<?> updateComment(@RequestBody CommentDTO comment, @PathVariable int id) throws Exception {
		DAOComment updateSubTaskNew = commentService.updateComment(id, comment);
		JSONObject responseJson = new JSONObject();

		if (updateSubTaskNew == null) {
			responseJson.put("status", "Not found this comment");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		responseJson.put("status", "Update complete");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	@DeleteMapping("/deleteComment/{id}")
	public ResponseEntity<?> deleteComment(@PathVariable int id) {
		Optional<DAOComment> CheckCommentId = commentService.findCommentById(id);
		JSONObject responseJson = new JSONObject();
		if (!CheckCommentId.isPresent()) {
			responseJson.put("status", "Not Found this comment");
			return new ResponseEntity<JSONObject>(responseJson, HttpStatus.BAD_REQUEST);
		}

		commentService.deleteComment(id);
		responseJson.put("status", "Comment " + id + " is deleted");
		return new ResponseEntity<JSONObject>(responseJson, HttpStatus.OK);
	}

	@GetMapping("/getAllComment/{subTaskId}")
	public List<DAOComment> getAllComment(@PathVariable(value = "subTaskId") int subTaskId) {
		return commentService.findAllComment(subTaskId);
	}
}
