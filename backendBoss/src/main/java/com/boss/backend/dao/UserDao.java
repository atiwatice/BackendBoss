package com.boss.backend.dao;

import java.util.List;


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
}

