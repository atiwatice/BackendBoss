package com.boss.backend.model;

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
}
