package com.boss.backend.model;


import javax.persistence.*;


@Entity
@Table(name = "COMMENTTABLE")
public class DAOComment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "COMMENT_ID_SEQ")
	private long COMMENT_ID;

	public long getCOMMENT_ID() {
		return COMMENT_ID;
	}

	public void setCOMMENT_ID(long COMMENT_ID) {
		this.COMMENT_ID = COMMENT_ID;
	}
	
	@Column(columnDefinition = "VARCHAR2(1000 CHAR) ")
	private String COMMENT_DETAIL;
	
	public String getCOMMENT_DETAIL() {
		return COMMENT_DETAIL;
	}

	public void setCOMMENT_DETAIL(String COMMENT_DETAIL) {
		this.COMMENT_DETAIL = COMMENT_DETAIL;
	}
	
	@ManyToOne
	@JoinColumn(name = "COMMENT_OWNER", referencedColumnName = "USER_ID", columnDefinition = "integer")
	private DAOUser COMMENT_OWNER;
	public DAOUser getCOMMENT_OWNER() {
		return COMMENT_OWNER;
	}

	public void setCOMMENT_OWNER(DAOUser COMMENT_OWNER) {
		this.COMMENT_OWNER = COMMENT_OWNER;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "SUB_TASK_ID", referencedColumnName = "SUB_TASK_ID", columnDefinition = "integer")
	private DAOSubTask SUB_TASK_ID;
	public DAOSubTask getSUB_TASK_ID() {
		return SUB_TASK_ID;
	}

	public void setSUB_TASK_ID(DAOSubTask SUB_TASK_ID) {
		this.SUB_TASK_ID = SUB_TASK_ID;
	}
	
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String DATETIME;
	
	public String getDATETIME() {
		return DATETIME;
	}
}
