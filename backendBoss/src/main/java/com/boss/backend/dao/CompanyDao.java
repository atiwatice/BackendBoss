package com.boss.backend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boss.backend.model.DAOCompany;



@Repository
public interface CompanyDao extends CrudRepository<DAOCompany, Integer>{
	DAOCompany findByCompanyName(String companyName);
	List<DAOCompany> findAll();
	DAOCompany findById(int id);
	void deleteById(int id);

}
