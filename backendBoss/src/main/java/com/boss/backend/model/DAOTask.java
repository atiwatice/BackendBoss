package com.boss.backend.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class DAOTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "TASK_ID_SEQ")
	private long task_id;

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}
	
	
	@Column(name="TASK_NAME",columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT task_task_name_nn NOT NULL")
	private String task_name;
	
	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}
	
	
	@Column(name="START_DATE",columnDefinition = "DATE " + "CONSTRAINT task_start_date_nn NOT NULL")
	private String start_date;
	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	
	@Column(name="END_DATE",columnDefinition = "DATE " + "CONSTRAINT task_end_date_nn NOT NULL")
	private String end_date;
	
	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	
	@Column(name="STATUS",columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT task_status_nn  NOT NULL")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@ManyToOne
	@JoinColumn(name = "TASK_OWNER_ID", referencedColumnName = "user_id", columnDefinition = "integer")
	private DAOUser task_owner_id;
	public DAOUser getTask_owner_id() {
		return task_owner_id;
	}

	public void setTask_owner_id(DAOUser task_owner_id) {
		this.task_owner_id = task_owner_id;
	}
	
	@OneToMany(targetEntity=DAOSubTask.class,mappedBy="task_id", cascade = CascadeType.ALL)
	private List<DAOSubTask> DAOSubTask_Task_id;
	
}
