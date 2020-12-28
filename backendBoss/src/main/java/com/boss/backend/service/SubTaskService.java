package com.boss.backend.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.SubTaskDao;
import com.boss.backend.model.DAOSubTask;
import com.boss.backend.model.SubTaskDTO;

@Service
public class SubTaskService {
	@Autowired
	SubTaskDao subTaskDao;

	// Add sub task
	public DAOSubTask save(SubTaskDTO subtask) throws Exception {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		Date dateStart = dateFormat.parse(subtask.getStartDate());
		Date dateEnd = dateFormat.parse(subtask.getEndDate());
		DAOSubTask newSubTask = new DAOSubTask();

		newSubTask.setSubTaskName(subtask.getSubTaskName());
		newSubTask.setStartDate(dateStart);
		newSubTask.setEndDate(dateEnd);
		newSubTask.setPercent(0);
		newSubTask.setTaskId(subtask.getTaskId());

		if (subtask.getAssignTo() != null) {
			newSubTask.setAssignTo(subtask.getAssignTo());
		}

		return subTaskDao.save(newSubTask);
	}

	// update sub task
	public DAOSubTask updateSubTask(int id, SubTaskDTO subtask) throws Exception {
		DAOSubTask subTaskId = subTaskDao.findBySubTaskId(id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");

		if (subTaskId == null) {
			return subTaskId;
		}

		if (subtask.getSubTaskName() != null)
			subTaskId.setSubTaskName(subtask.getSubTaskName());

		if (subtask.getStartDate() != null) {
			Date dateStart = dateFormat.parse(subtask.getStartDate());
			subTaskId.setStartDate(dateStart);
		}

		if (subtask.getEndDate() != null) {
			Date dateEnd = dateFormat.parse(subtask.getEndDate());
			subTaskId.setEndDate(dateEnd);
		}

		if (subtask.getPercent() != subTaskId.getPercent())
			subTaskId.setPercent(subtask.getPercent());

		if (subtask.getAssignTo() != null || subtask.getAssignTo() != subTaskId.getAssignTo())
			subTaskId.setAssignTo(subtask.getAssignTo());

		return subTaskDao.save(subTaskId);
	}
	
	public void deleteSubTask(int id) {
		subTaskDao.deleteBySubTaskId(id);
	}
	
	public Optional<DAOSubTask> findSubTaskById(int taskId) {
		return  Optional.ofNullable(subTaskDao.findBySubTaskId(taskId));
	}
	
	public List<DAOSubTask> findAllSubTask(int taskId) {
		return (List<DAOSubTask>) subTaskDao.findAllSubTaskByTaskId(taskId);
	}
	
	
}
