package com.boss.backend.model;

import javax.persistence.*;

@Entity
@Table(name = "MANAGE_COPERATE")
public class DAOManageCoperate {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "MANAGE_COPERATE_ID_SEQ")
	private long MANAGE_COPERATE_ID;

	public long getMANAGE_COPERATE_ID() {
		return MANAGE_COPERATE_ID;
	}

	public void setMANAGE_COPERATE_ID(long MANAGE_COPERATE_ID) {
		this.MANAGE_COPERATE_ID = MANAGE_COPERATE_ID;
	}


	@ManyToOne
	@JoinColumn(name = "REQUESTER_ID", referencedColumnName = "USER_ID", columnDefinition = "integer")
	private DAOUser REQUESTER_ID;
	public DAOUser getREQUESTER_ID() {
		return REQUESTER_ID;
	}

	public void setREQUESTER_ID(DAOUser REQUESTER_ID) {
		this.REQUESTER_ID = REQUESTER_ID;
	}
	
	@ManyToOne
	@JoinColumn(name = "ACCEPTER_ID", referencedColumnName = "USER_ID", columnDefinition = "integer")
	private DAOUser ACCEPTER_ID;
	public DAOUser getACCEPTER_ID() {
		return ACCEPTER_ID;
	}

	public void setACCEPTER_ID(DAOUser ACCEPTER_ID) {
		this.ACCEPTER_ID = ACCEPTER_ID;
	}

	@Column(columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT manage_coperate_nn  NOT NULL")
	private String STATUS;

	public String getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(String STATUS) {
		this.STATUS = STATUS;
	}

	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String DATETIME;

	public String getDATETIME() {
		return DATETIME;
	}

}
