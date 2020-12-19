package com.boss.backend.model;

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
}
