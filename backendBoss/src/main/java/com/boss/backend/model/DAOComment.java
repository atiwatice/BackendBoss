package com.boss.backend.model;


import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "COMMENTTABLE")
public class DAOComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "COMMENT_ID_SEQ")
	private int commentId;

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	
	@Column(name="COMMENT_DETAIL",columnDefinition = "VARCHAR2(1000 CHAR) ")
	private String commentDetail;
	
	public String getCommentDetail() {
		return commentDetail;
	}

	public void setCommentDetail(String commentDetail) {
		this.commentDetail = commentDetail;
	}
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_OWNER", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser commentOwner;
	public DAOUser getCommentOwner() {
		return commentOwner;
	}

	public void setCommentOwner(DAOUser commentOwner) {
		this.commentOwner = commentOwner;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "SUB_TASK_ID", referencedColumnName = "subTaskId", columnDefinition = "integer")
	private DAOSubTask subTaskId;
	public DAOSubTask getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskId(DAOSubTask subTaskId) {
		this.subTaskId = subTaskId;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;
}
