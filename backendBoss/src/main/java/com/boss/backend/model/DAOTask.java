package com.boss.backend.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "TASK")
public class DAOTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "TASK_ID_SEQ")
	private long TASK_ID;

	public long getTASK_ID() {
		return TASK_ID;
	}

	public void setTASK_ID(long TASK_ID) {
		this.TASK_ID = TASK_ID;
	}
	
	
	@Column(columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT task_task_name_nn NOT NULL")
	private String TASK_NAME;
	
	public String getTASK_NAME() {
		return TASK_NAME;
	}

	public void setTASK_NAME(String TASK_NAME) {
		this.TASK_NAME = TASK_NAME;
	}
	
	
	@Column(columnDefinition = "DATE " + "CONSTRAINT task_start_date_nn NOT NULL")
	private String START_DATE;
	
	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String START_DATE) {
		this.START_DATE = START_DATE;
	}
	
	
	@Column(columnDefinition = "DATE " + "CONSTRAINT task_end_date_nn NOT NULL")
	private String END_DATE;
	
	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String END_DATE) {
		this.END_DATE = END_DATE;
	}
	
	
	@Column(columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT task_status_nn  NOT NULL")
	private String STATUS;

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}
	
	@ManyToOne
	@JoinColumn(name = "TASK_OWNER_ID", referencedColumnName = "USER_ID", columnDefinition = "integer")
	private DAOUser TASK_OWNER_ID;
	public DAOUser getTASK_OWNER_ID() {
		return TASK_OWNER_ID;
	}

	public void setTASK_OWNER_ID(DAOUser TASK_OWNER_ID) {
		this.TASK_OWNER_ID = TASK_OWNER_ID;
	}
	
	@OneToMany(targetEntity=DAOSubTask.class,mappedBy="TASK_ID", cascade = CascadeType.ALL)
	private List<DAOSubTask> DAOSubTask_Task_id;
	
}
