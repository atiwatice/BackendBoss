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
	private long manage_coperate_id;

	public long getManage_coperate_id() {
		return manage_coperate_id;
	}

	public void setManage_coperate_id(long manage_coperate_id) {
		this.manage_coperate_id = manage_coperate_id;
	}


	@ManyToOne
	@JoinColumn(name = "REQUESTER_ID", referencedColumnName = "user_id", columnDefinition = "integer")
	private DAOUser requester_id;
	public DAOUser getRequester_id() {
		return requester_id;
	}

	public void setRequester_id(DAOUser requester_id) {
		this.requester_id = requester_id;
	}
	
	@ManyToOne
	@JoinColumn(name = "ACCEPTER_ID", referencedColumnName = "user_id", columnDefinition = "integer")
	private DAOUser accepter_id;
	public DAOUser getAccepter_id() {
		return accepter_id;
	}

	public void setAccepter_id(DAOUser accepter_id) {
		this.accepter_id = accepter_id;
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
