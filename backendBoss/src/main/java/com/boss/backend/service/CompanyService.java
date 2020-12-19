package com.boss.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boss.backend.dao.CompanyDao;
import com.boss.backend.model.CompanyDTO;
import com.boss.backend.model.DAOCompany;




@Service
public class CompanyService {
	@Autowired
	private CompanyDao companyDao;
	
	public DAOCompany save(CompanyDTO company) {
		DAOCompany newCompany = new DAOCompany();
		newCompany.setCompanyName(company.getCompanyName());
		newCompany.setCompanyDetail(company.getCompanyDetail());
		return companyDao.save(newCompany);
	}
	
	public List<DAOCompany> retrieveCompany(){
		return (List<DAOCompany>) companyDao.findAll();
	}
	
	public DAOCompany findCompanyId(int companyId){
		return companyDao.findByCompanyId(companyId);
	}
	
	public DAOCompany findCompanyName(String companyName){
		return companyDao.findByCompanyName(companyName);
	}
	
	public void deleteCompanyId(int companyId) {
		companyDao.deleteById(companyId);
	}
}
