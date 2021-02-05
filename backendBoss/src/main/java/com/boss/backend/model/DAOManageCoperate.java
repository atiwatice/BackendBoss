package com.boss.backend.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "MANAGE_COPERATE")
public class DAOManageCoperate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "MANAGE_COPERATE_ID_SEQ")
	private int manageCoperateId;

	public int getManageCoperateId() {
		return manageCoperateId;
	}

	public void setManageCoperateId(int manageCoperateId) {
		this.manageCoperateId = manageCoperateId;
	}


	@ManyToOne
	@JoinColumn(name = "REQUESTER_ID", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser requesterId;
	public DAOUser getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(DAOUser requesterId) {
		this.requesterId = requesterId;
	}
	
	@ManyToOne
	@JoinColumn(name = "ACCEPTER_ID", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser accepterId;
	public DAOUser getAccepterId() {
		return accepterId;
	}

	public void setAccepterId(DAOUser accepterId) {
		this.accepterId = accepterId;
	}

	@Column(name="STATUS",columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT manage_coperate_nn  NOT NULL")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(name="AMOUNT_SUB_TASK_WORK",columnDefinition= "NUMBER(10,0) DEFAULT 0 " + 
			"CONSTRAINT manage_sub_task_work_nn  NOT NULL")
	private int amountSubTaskWork;

	public int getAmountSubTaskWork() {
		return amountSubTaskWork;
	}

	public void setAmountSubTaskWork(int amountSubTaskWork) {
		this.amountSubTaskWork = amountSubTaskWork;
	}
	

	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

}
