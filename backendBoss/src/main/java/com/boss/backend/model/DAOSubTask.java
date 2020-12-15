package com.boss.backend.model;


import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "SUB_TASK")
public class DAOSubTask {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "SUB_TASK_ID_SEQ")
	private long SUB_TASK_ID;

	public long getSUB_TASK_ID() {
		return SUB_TASK_ID;
	}

	public void setSUB_TASK_ID(long SUB_TASK_ID) {
		this.SUB_TASK_ID = SUB_TASK_ID;
	}
	
	
	@Column(columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT subtask_sub_task_name_nn NOT NULL")
	private String SUB_TASK_NAME;
	
	public String getSUB_TASK_NAME() {
		return SUB_TASK_NAME;
	}

	public void setSUB_TASK_NAME(String SUB_TASK_NAME) {
		this.SUB_TASK_NAME = SUB_TASK_NAME;
	}
	
	
	@Column(columnDefinition = "DATE " + "CONSTRAINT subtask_start_date_nn NOT NULL")
	private String START_DATE;
	
	public String getSTART_DATE() {
		return START_DATE;
	}

	public void setSTART_DATE(String START_DATE) {
		this.START_DATE = START_DATE;
	}
	
	
	@Column(columnDefinition = "DATE " + "CONSTRAINT subtask_end_date_nn NOT NULL")
	private String END_DATE;
	
	public String getEND_DATE() {
		return END_DATE;
	}

	public void setEND_DATE(String END_DATE) {
		this.END_DATE = END_DATE;
	}
	
	
	@Column(columnDefinition= "NUMBER " + 
			"CONSTRAINT subtask_percent_nn  NOT NULL")
	private String PERCENT;

	public String getPERCENT() {
		return PERCENT;
	}

	public void setPERCENT(String PERCENT) {
		this.PERCENT = PERCENT;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "ASSIGN_TO", referencedColumnName = "USER_ID", columnDefinition = "integer")
	private DAOUser ASSIGN_TO;
	public DAOUser getASSIGN_TO() {
		return ASSIGN_TO;
	}

	public void setASSIGN_TO(DAOUser ASSIGN_TO) {
		this.ASSIGN_TO = ASSIGN_TO;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "TASK_ID", referencedColumnName = "TASK_ID", columnDefinition = "integer")
	private DAOTask TASK_ID;
	public DAOTask getTASK_ID() {
		return TASK_ID;
	}

	public void setTASK_ID(DAOTask TASK_ID) {
		this.TASK_ID = TASK_ID;
	}
	
	@OneToMany(targetEntity=DAOComment.class,mappedBy="SUB_TASK_ID", cascade = CascadeType.ALL)
	private List<DAOComment> DAOComment_Sub_Task_id;
	
}
