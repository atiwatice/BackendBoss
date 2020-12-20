package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDTO {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	private long userId;
	
	public long getUserId() {
		return userId;
	}
	
	private String firstname;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	private String lastname;
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	private String mobileNo;
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	private DAOCompany companyId;
	
	public DAOCompany getCompanyId() {
		return companyId;
	}

	public void setCompanyId(DAOCompany companyId) {
		this.companyId = companyId;
	}
	
	@JsonProperty("companyId")
	private void unpackAccepter(Integer companyid) {
	    this.companyId = new DAOCompany();
	    companyId.setCompanyId(companyid);
	}

}
