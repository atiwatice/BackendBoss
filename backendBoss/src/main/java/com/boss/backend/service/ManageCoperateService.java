package com.boss.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.ManageCoperateDao;
import com.boss.backend.model.DAOManageCoperate;
import com.boss.backend.model.ManageCoperateDTO;

@Service
public class ManageCoperateService {
	@Autowired
	private ManageCoperateDao manageCoperateDao;

	// Request Coperate
	public DAOManageCoperate save(ManageCoperateDTO coperate) {

		DAOManageCoperate newCoperate = new DAOManageCoperate();
		newCoperate.setAccepterId(coperate.getAccepterId());
		newCoperate.setRequesterId(coperate.getRequesterId());
		newCoperate.setStatus("waitingConfirmation");
		return manageCoperateDao.save(newCoperate);
	}
	
	//find one user it also be both accepter or requester 
	public List<DAOManageCoperate> findCoperate(int requesterId, int accepterId){
		return (List<DAOManageCoperate>) manageCoperateDao.findCoperateByRequesterIdOrAccepterId(requesterId,accepterId);
	}
	
	

}
