package com.boss.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOSubTask;






@Repository
public interface SubTaskDao extends CrudRepository<DAOSubTask,Integer> {
	
	@Query("select m from DAOSubTask m where m.taskId.taskId = ?1")
	List<DAOSubTask> findAllSubTaskByTaskId(int taskId);
	

	
	@Transactional
	void deleteBySubTaskId(int subTaskId);
	
	DAOSubTask findBySubTaskId(int SubTaskId);
	DAOSubTask findBySubTaskName(String subTaskName);
}
