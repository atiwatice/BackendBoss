package com.boss.backend.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOManageCoperate;

@Repository
public interface ManageCoperateDao extends CrudRepository<DAOManageCoperate,Integer> {
		
	@Query("select m from DAOManageCoperate m where (m.requesterId.userId = ?1 or m.accepterId.userId = ?2 ) and m.status = 'COPERATE'")
	List<DAOManageCoperate> findCoperateByRequesterIdOrAccepterId(int requesterId,int accepterId);
	
	@Query("select m from DAOManageCoperate m where (m.accepterId.userId = ?1 ) and m.status = 'WAIT_CONFIRM'")
	List<DAOManageCoperate> findWaitCofirmByAccepterId(int accepterId);
	
	DAOManageCoperate findByManageCoperateId(int manageCoperateId);
	
	@Query("select m from DAOManageCoperate m where ((m.requesterId.userId = ?1 and m.accepterId.userId = ?2 ) or (m.requesterId.userId = ?2 and m.accepterId.userId = ?1 ) ) and m.status = 'WAIT_CONFIRM'")
	DAOManageCoperate findForConfirmByRequesterIdOrAccepterId(int requesterId,int accepterId);

	@Query("select m from DAOManageCoperate m where ((m.requesterId.userId = ?1 and m.accepterId.userId = ?2 ) or (m.requesterId.userId = ?2 and m.accepterId.userId = ?1 ) ) and m.status = 'COPERATE'")
	DAOManageCoperate findForDeleteCoperateByRequesterIdOrAccepterId(int requesterId,int accepterId);
	
	
	@Transactional
	void deleteByManageCoperateId(int manageCoperateId);
	
	
	
}
