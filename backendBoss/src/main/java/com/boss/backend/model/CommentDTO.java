package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentDTO {
	private String commentDetail;

	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}

	private DAOUser commentOwner;

	public DAOUser getCommentOwner() {
		return commentOwner;
	}

	public void setCommentOwner(DAOUser commentOwner) {
		this.commentOwner = commentOwner;
	}

	private DAOSubTask subTaskId;

	public DAOSubTask getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskId(DAOSubTask subTaskId) {
		this.subTaskId = subTaskId;
	}
	
	@JsonProperty("commentOwner")
	private void unpackCommentOwner(Integer userId) {
	    this.commentOwner = new DAOUser();
	    commentOwner.setUserId(userId);
	}
	
	@JsonProperty("subTaskId")
	private void unpackTaskId(Integer subTaskIdd) {
	    this.subTaskId = new DAOSubTask();
	    subTaskId.setSubTaskId(subTaskIdd);
	}
}
