package com.boss.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOTask;

@Repository
public interface TaskDao extends CrudRepository<DAOTask,Integer>{
	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 order by m.endDate")
	List<DAOTask> findAllTaskByTaskOwnerId(int taskOwnerId);

	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 and m.status = 'IN_PROCESS' order by endDate DESC")
	List<DAOTask> findTaskInprocessByTaskOwnerId(int taskOwnerId);

	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 and m.status = 'COMPLETE' order by endDate DESC")
	List<DAOTask> findTaskCompleteByTaskOwnerId(int taskOwnerId);

	DAOTask findByTaskId(int taskId);

	@Transactional
	void deleteByTaskId(int taskId);
}
