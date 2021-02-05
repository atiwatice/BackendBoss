package com.boss.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.boss.backend.model.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer>{
	DAOUser findByUsername(String username);
	DAOUser findByUserId(int userId);
	List<DAOUser> findAll();
	DAOUser findById(int id);
	void deleteById(int id);
	DAOUser findByEmail(String email);
	DAOUser findByMobileNo(String mobileNo);
	
	@Query(value ="select * from users m where (m.company_id = (select users.company_id from users where users.user_id =?1 and users.company_id is not null)) and (m.user_id != ?1) and (m.user_id not in (select a.accepter_id from manage_coperate a where a.requester_id =?1)) and (m.user_id not in (select a.requester_id from manage_coperate a where a.accepter_id =?1))",nativeQuery = true)
	List<DAOUser> findAllUserSameCompanyByUserId(int userId);
}

