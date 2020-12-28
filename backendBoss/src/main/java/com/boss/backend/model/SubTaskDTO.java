package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SubTaskDTO {
	private String subTaskName;

	public String getSubTaskName() {
		return subTaskName;
	}

	public void setSubTaskName(String subTaskName) {
		this.subTaskName = subTaskName;
	}

	private String startDate;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	private String endDate;

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	private int percent;

	public int getPercent() {
		return percent;
	}

	public void setPercent(int percent) {
		this.percent = percent;
	}

	private DAOUser assignTo;

	public DAOUser getAssignTo() {
		return assignTo;
	}

	public void setAssignTo(DAOUser assignTo) {
		this.assignTo = assignTo;
	}

	private DAOTask taskId;

	public DAOTask getTaskId() {
		return taskId;
	}

	public void setTaskId(DAOTask taskId) {
		this.taskId = taskId;
	}
	
	@JsonProperty("assignTo")
	private void unpackAssignTo(Integer userId) {
	    this.assignTo = new DAOUser();
	    assignTo.setUserId(userId);
	}
	
	@JsonProperty("taskId")
	private void unpackTaskId(Integer taskIdd) {
	    this.taskId = new DAOTask();
	    taskId.setTaskId(taskIdd);
	}
	
}
