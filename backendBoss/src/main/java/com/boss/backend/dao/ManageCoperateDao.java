package com.boss.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.boss.backend.model.DAOManageCoperate;

public interface ManageCoperateDao extends CrudRepository<DAOManageCoperate,Integer> {
		
	@Query("select m from DAOManageCoperate m where (m.requesterId.userId = ?1 or m.accepterId.userId = ?2 ) and m.status = 'COPERATE'")
	List<DAOManageCoperate> findCoperateByRequesterIdOrAccepterId(int requesterId,int accepterId);
	
	
	
}
