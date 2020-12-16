package com.boss.backend.model;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "SUB_TASK")
public class DAOSubTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "SUB_TASK_ID_SEQ")
	private long sub_task_id;

	public long getSub_task_id() {
		return sub_task_id;
	}

	public void setSub_task_id(long sub_task_id) {
		this.sub_task_id = sub_task_id;
	}
	
	
	@Column(name="SUB_TASK_NAME",columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT subtask_sub_task_name_nn NOT NULL")
	private String sub_task_name;
	
	public String getSub_task_name() {
		return sub_task_name;
	}

	public void setSub_task_name(String sub_task_name) {
		this.sub_task_name = sub_task_name;
	}
	
	
	@Column(name="START_DATE",columnDefinition = "DATE " + "CONSTRAINT subtask_start_date_nn NOT NULL")
	private String start_date;
	
	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	
	
	@Column(name="END_DATE",columnDefinition = "DATE " + "CONSTRAINT subtask_end_date_nn NOT NULL")
	private String end_date;
	
	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
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
	@JoinColumn(name = "ASSIGN_TO", referencedColumnName = "user_id", columnDefinition = "integer")
	private DAOUser assign_to;
	public DAOUser getAssign_to() {
		return assign_to;
	}

	public void setAssign_to(DAOUser assign_to) {
		this.assign_to = assign_to;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "TASK_ID", referencedColumnName = "task_id", columnDefinition = "integer")
	private DAOTask task_id;
	public DAOTask getTask_id() {
		return task_id;
	}

	public void setTask_id(DAOTask task_id) {
		this.task_id = task_id;
	}
	
	@OneToMany(targetEntity=DAOComment.class,mappedBy="sub_task_id", cascade = CascadeType.ALL)
	private List<DAOComment> DAOComment_Sub_Task_id;
	
}
