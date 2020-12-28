package com.boss.backend.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class DAOTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "TASK_ID_SEQ")
	private int taskId;

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
	@Column(name="TASK_NAME",columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT task_task_name_nn NOT NULL")
	private String taskName;
	
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	
	@Column(name="START_DATE",columnDefinition = "DATE " + "CONSTRAINT task_start_date_nn NOT NULL")
	private Date startDate;
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	
	@Column(name="END_DATE",columnDefinition = "DATE " + "CONSTRAINT task_end_date_nn NOT NULL")
	private Date endDate;
	
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	@JoinColumn(name = "TASK_OWNER_ID", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser taskOwnerId;
	public DAOUser getTaskOwnerId() {
		return taskOwnerId;
	}

	public void setTaskOwnerId(DAOUser taskOwnerId) {
		this.taskOwnerId = taskOwnerId;
	}
	
	@OneToMany(targetEntity=DAOSubTask.class,mappedBy="taskId", cascade = CascadeType.ALL)
	private List<DAOSubTask> DAOSubTaskTaskId;
	
}
