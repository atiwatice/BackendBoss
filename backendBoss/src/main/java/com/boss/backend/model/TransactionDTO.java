package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransactionDTO {
	
	String transactionName;

	public String getTransactionName() {
		return transactionName;
	}
	public void setTransactionName(String transactionName) {
		this.transactionName = transactionName;
	}
	
	
	private DAOTransactionType transactionTypeId;
	
	public DAOTransactionType getTransactionTypeId() {
		return transactionTypeId;
	}

	public void setTransactionTypeId(DAOTransactionType transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	
	
	@JsonProperty("transactionTypeId")
	private void unpackTransactionType(Integer transactionTypeid) {
	    this.transactionTypeId = new DAOTransactionType();
	    transactionTypeId.setTransactionTypeId(transactionTypeid);
	}
	
	
	private DAOUser actionOwnerId;

	public DAOUser getActionOwnerId() {
		return actionOwnerId;
	}

	public void setActionOwnerId(DAOUser actionOwnerId) {
		this.actionOwnerId = actionOwnerId;
	}
	
	@JsonProperty("actionOwnerId")
	private void unpackActionOwner(Integer actionOwnerid) {
	    this.actionOwnerId = new DAOUser();
	    actionOwnerId.setUserId(actionOwnerid);
	}
	
}
