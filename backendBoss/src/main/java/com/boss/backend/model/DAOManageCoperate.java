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
	private long manageCoperateId;

	public long getManageCoperateId() {
		return manageCoperateId;
	}

	public void setManageCoperateId(long manageCoperateId) {
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
	private String STATUS;

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}

	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

}
