package com.boss.backend.model;

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

	private String percent;

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	private DAOUser assignTo;

	public DAOUser getAssignToo() {
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
}
