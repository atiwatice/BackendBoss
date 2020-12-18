package com.boss.backend.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyReposity extends CrudRepository<DAOCompany, Integer> {
	DAOCompany findById(int id);
	List<DAOCompany> findAll();
}
