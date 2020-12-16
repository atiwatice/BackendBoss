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
	private long comment_id;

	public long getComment_id() {
		return comment_id;
	}

	public void setComment_id(long comment_id) {
		this.comment_id = comment_id;
	}
	
	@Column(name="COMMENT_DETAIL",columnDefinition = "VARCHAR2(1000 CHAR) ")
	private String comment_detail;
	
	public String getComment_detail() {
		return comment_detail;
	}

	public void setComment_detail(String comment_detail) {
		this.comment_detail = comment_detail;
	}
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_OWNER", referencedColumnName = "user_id", columnDefinition = "integer")
	private DAOUser comment_owner;
	public DAOUser getComment_owner() {
		return comment_owner;
	}

	public void setComment_owner(DAOUser comment_owner) {
		this.comment_owner = comment_owner;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "SUB_TASK_ID", referencedColumnName = "sub_task_id", columnDefinition = "integer")
	private DAOSubTask sub_task_id;
	public DAOSubTask getSub_task_id() {
		return sub_task_id;
	}

	public void setSub_task_id(DAOSubTask sub_task_id) {
		this.sub_task_id = sub_task_id;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;
}
