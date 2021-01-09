package com.boss.backend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.boss.backend.dao.TaskDao;
import com.boss.backend.model.DAOTask;
import com.boss.backend.model.TaskDTO;
import com.boss.backend.model.TaskPercentDTO;


@Service
public class TaskService {

	@Autowired
	TaskDao taskDao;

	// Add task
	public DAOTask save(TaskDTO task) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		Date dateStart = dateFormat.parse(task.getStartDate());
		Date dateEnd = dateFormat.parse(task.getEndDate());
		DAOTask newTask = new DAOTask();
		newTask.setTaskName(task.getTaskName());
		newTask.setStartDate(dateStart);
		newTask.setEndDate(dateEnd);
		newTask.setStatus("IN_PROCESS");
		newTask.setTaskOwnerId(task.getTaskOwnerId());
		return taskDao.save(newTask);
	}

	// update task
	public DAOTask updateTask(int id, TaskDTO task) throws Exception {
		DAOTask taskId = taskDao.findByTaskId(id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		if (taskId == null) {
			return taskId;
		}

		if (task.getTaskName() != null)
			taskId.setTaskName(task.getTaskName());
		if (task.getStartDate() != null) {
			Date dateStart = dateFormat.parse(task.getStartDate());
			taskId.setStartDate(dateStart);
		}
		if (task.getEndDate() != null) {
			Date dateEnd = dateFormat.parse(task.getEndDate());
			taskId.setEndDate(dateEnd);
		}
		if (task.getStatus() != null)
			taskId.setStatus(task.getStatus());

		return taskDao.save(taskId);
	}

	public List<DAOTask> findAllTask(int taskOwnerId) {
		return (List<DAOTask>) taskDao.findAllTaskByTaskOwnerId(taskOwnerId);
	}

	public List<DAOTask> findInprocessTask(int taskOwnerId) {
		return (List<DAOTask>) taskDao.findTaskInprocessByTaskOwnerId(taskOwnerId);
	}
	
	public List<DAOTask> findCompleteTak(int taskOwnerId) {
		return (List<DAOTask>) taskDao.findTaskCompleteByTaskOwnerId(taskOwnerId);
	}
	
	public List<TaskPercentDTO> findAllpercentTask(int taskOwnerId) {
		return (List<TaskPercentDTO>) taskDao.findTaskPercentByTaskOwnerId(taskOwnerId);
	}
	
	public Optional<DAOTask> findTaskById(int taskId) {
		return  Optional.ofNullable(taskDao.findByTaskId(taskId));
	}
	
	public void deleteTask(int id) {
		taskDao.deleteByTaskId(id);
	}
	
	

}
