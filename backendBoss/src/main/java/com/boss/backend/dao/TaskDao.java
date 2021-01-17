package com.boss.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOTask;
import com.boss.backend.model.TaskPercentDTO;


@Repository
public interface TaskDao extends CrudRepository<DAOTask,Integer>{
	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 order by m.endDate")
	List<DAOTask> findAllTaskByTaskOwnerId(int taskOwnerId);

	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 and m.status = 'IN_PROCESS' order by endDate DESC")
	List<DAOTask> findTaskInprocessByTaskOwnerId(int taskOwnerId);

	@Query("select m from DAOTask m where m.taskOwnerId.userId = ?1 and m.status = 'COMPLETE' order by endDate DESC")
	List<DAOTask> findTaskCompleteByTaskOwnerId(int taskOwnerId);


//	@Query(value ="select m.taskId,m.taskName,SUM(s.percent) as percent from DAOTask m inner join DAOSubTask s on m.taskId = s.taskId where m.taskOwnerId.userId = ?1 group by m.taskId,m.taskName",nativeQuery = true)
//	List<?> findTaskPercentByTaskOwnerId(int taskOwnerId);

	@Query(value ="select task.task_id as task_id,task.task_name as task_name, task.start_date as start_date ,task.end_date as end_date,NVL(sum(percent),0) as total_percent from task left outer join sub_task on task.task_id=sub_task.task_id where task.task_owner_id = ?1 group by task.task_id,task.task_name,task.start_date,task.end_date",nativeQuery = true)
	List<TaskPercentDTO> findTaskPercentByTaskOwnerId(int taskOwnerId);
	
	DAOTask findByTaskId(int taskId);

	@Transactional
	void deleteByTaskId(int taskId);
}


