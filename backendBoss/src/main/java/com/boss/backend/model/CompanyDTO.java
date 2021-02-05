package com.boss.backend.model;

public class CompanyDTO {
	String companyName;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	private String companyDetail;

	public String getCompanyDetail() {
		return companyDetail;
	}
	
	private String companyStartDate;

	public String getCompanyStartDate() {
		return companyStartDate;
	}

	public void setCompanyStartDate(String companyStartDate) {
		this.companyStartDate = companyStartDate;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}
}
