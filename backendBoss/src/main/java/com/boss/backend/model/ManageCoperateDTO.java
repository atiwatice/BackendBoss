package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ManageCoperateDTO {
	private DAOUser requesterId;

	public DAOUser getRequesterId() {
		return requesterId;
	}

	public void setRequesterId(DAOUser requesterId) {
		this.requesterId = requesterId;
	}

	private DAOUser accepterId;

	public DAOUser getAccepterId() {
		return accepterId;
	}

	public void setAccepterId(DAOUser accepterId) {
		this.accepterId = accepterId;
	}
	
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	private int amountSubTaskWork;

	public int getAmountSubTaskWork() {
		return amountSubTaskWork;
	}

	public void setAmountSubTaskWork(int amountSubTaskWork) {
		this.amountSubTaskWork = amountSubTaskWork;
	}
	
	
	@JsonProperty("requesterId")
	private void unpackRequester(Integer userId) {
	    this.requesterId = new DAOUser();
	    requesterId.setUserId(userId);
	}
	
	@JsonProperty("accepterId")
	private void unpackAccepter(Integer userId) {
	    this.accepterId = new DAOUser();
	    accepterId.setUserId(userId);
	}
	
}
