package com.boss.backend.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.ManageCoperateDao;
import com.boss.backend.dao.UserDao;
import com.boss.backend.model.DAOManageCoperate;
import com.boss.backend.model.DAOUser;
import com.boss.backend.model.ManageCoperateDTO;

@Service
public class ManageCoperateService {
	@Autowired
	private ManageCoperateDao manageCoperateDao;

	@Autowired
	private UserDao userDao;

	// Request Coperate
	public DAOManageCoperate save(ManageCoperateDTO coperate) {

		DAOManageCoperate newCoperate = new DAOManageCoperate();
		newCoperate.setAccepterId(coperate.getAccepterId());
		newCoperate.setRequesterId(coperate.getRequesterId());
		newCoperate.setStatus("WAIT_CONFIRM");
		return manageCoperateDao.save(newCoperate);
	}

	// find one user it also be both accepter or requester Coperate
	public List<DAOManageCoperate> findCoperate(int requesterId, int accepterId) {
		return (List<DAOManageCoperate>) manageCoperateDao.findCoperateByRequesterIdOrAccepterId(requesterId,
				accepterId);
	}

	public List<DAOManageCoperate> findWaitConfirm(int accepterId) {
		return (List<DAOManageCoperate>) manageCoperateDao.findWaitCofirmByAccepterId(accepterId);
	}

	public DAOManageCoperate updateStatusCoperate(int ownerId, String requestUser) {

		DAOUser resultConfirmUser = userDao.findByUsername(requestUser);
		DAOManageCoperate resultManageCoperate = manageCoperateDao.findForConfirmByRequesterIdOrAccepterId(resultConfirmUser.getUserId()
				,ownerId);

		if (resultManageCoperate == null) {
			return resultManageCoperate;
		}

		resultManageCoperate.setStatus("COPERATE");
		return manageCoperateDao.save(resultManageCoperate);
	}

	public DAOManageCoperate findManageCoperateIdForRequest(int ownerId, int confirmUserId) {
		DAOManageCoperate resultManageCoperate = manageCoperateDao.findForConfirmByRequesterIdOrAccepterId(ownerId,
				confirmUserId);

		return resultManageCoperate;

	}
	
	public void deleteByManageCoperateId(int manageCoperateId) {
		manageCoperateDao.deleteByManageCoperateId(manageCoperateId);
	}

	public DAOManageCoperate cancelRequest(int ownerId, String confirmUser) {

		DAOUser resultConfirmUser = userDao.findByUsername(confirmUser);
		DAOManageCoperate resultManageCoperate = findManageCoperateIdForRequest(ownerId, resultConfirmUser.getUserId());

		if (resultManageCoperate == null) {
			return resultManageCoperate;
		}
		
		deleteByManageCoperateId(resultManageCoperate.getManageCoperateId());
		
		return resultManageCoperate;
	}
	


	public DAOManageCoperate deleteCoperate(int ownerId, String confirmUser) {

		DAOUser resultConfirmUser = userDao.findByUsername(confirmUser);
		DAOManageCoperate resultManageCoperate = manageCoperateDao.findForDeleteCoperateByRequesterIdOrAccepterId(ownerId, resultConfirmUser.getUserId());

		if (resultManageCoperate == null) {
			return resultManageCoperate;
		}
		
		deleteByManageCoperateId(resultManageCoperate.getManageCoperateId());
		
		return resultManageCoperate;
	
	
	}


}
