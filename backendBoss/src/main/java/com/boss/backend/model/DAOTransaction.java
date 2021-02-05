package com.boss.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "TRANSACTION")
public class DAOTransaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "TRANSACTION_ID_SEQ")
	private int transactionId;
	
	public int getTransactionId() {
        return transactionId;
    }
	
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	
	@Column(name="TRANSACTION_NAME",columnDefinition= "VARCHAR2(100 CHAR)")
	private String transactionName;
	
	public String getTransactionName() {
		return transactionName;
	}

	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
	@ManyToOne
	@JoinColumn(name="TRANSACTION_TYPE_ID", referencedColumnName = "transactionTypeId",columnDefinition="integer")
	private DAOTransactionType transactionTypeId;
	
	public DAOTransactionType getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(DAOTransactionType transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "ACTION_OWNER_ID", referencedColumnName = "userId", columnDefinition = "integer")
	private DAOUser actionOwnerId;
	public DAOUser getActionOwnerId() {
		return actionOwnerId;
	}

	public void setActionOwnerId(DAOUser actionOwnerId) {
		this.actionOwnerId = actionOwnerId;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;
	
}
