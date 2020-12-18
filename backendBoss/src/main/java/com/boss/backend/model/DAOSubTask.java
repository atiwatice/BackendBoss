package com.boss.backend.model;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "SUB_TASK")
public class DAOSubTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "SUB_TASK_ID_SEQ")
	private long subTaskId;

	public long getSubTaskId() {
		return subTaskId;
	}

	public void setSubTaskId(long subTaskId) {
		this.subTaskId = subTaskId;
	}
	
	
	@Column(name="SUB_TASK_NAME",columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT subtask_sub_task_name_nn NOT NULL")
	private String subTaskName;
	
	public String getSubTaskName() {
		return subTaskName;
	}

	public void setSubTaskName(String subTaskName) {
		this.subTaskName = subTaskName;
	}
	
	
	@Column(name="START_DATE",columnDefinition = "DATE " + "CONSTRAINT subtask_start_date_nn NOT NULL")
	private String startDate;
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	
	@Column(name="END_DATE",columnDefinition = "DATE " + "CONSTRAINT subtask_end_date_nn NOT NULL")
	private String endDate;
	
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	
	
	@Column(name="PERCENT",columnDefinition= "NUMBER " + 
			"CONSTRAINT subtask_percent_nn  NOT NULL")
	private String percent;

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "ASSIGN_TO", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser assignTo;
	public DAOUser getAssignToo() {
		return assignTo;
	}

	public void setAssignTo(DAOUser assignTo) {
		this.assignTo = assignTo;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "TASK_ID", referencedColumnName = "taskId", columnDefinition = "integer")
	private DAOTask taskId;
	public DAOTask getTaskId() {
		return taskId;
	}

	public void setTaskId(DAOTask taskId) {
		this.taskId = taskId;
	}
	
	@OneToMany(targetEntity=DAOComment.class,mappedBy="subTaskId", cascade = CascadeType.ALL)
	private List<DAOComment> DAOCommentSubTaskId;
	
}
