package com.boss.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@Entity
@Table(name = "users")
public class DAOUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "USER_ID_SEQ")
	private int userId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="USERNAME",columnDefinition = "VARCHAR2(40 CHAR) " + "CONSTRAINT users_username_nn_unique NOT NULL UNIQUE")
	private String username;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD",columnDefinition = "VARCHAR2(100 CHAR) " + "CONSTRAINT users_password_nn NOT NULL")
	@JsonIgnore
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	@Column(name="FIRSTNAME",columnDefinition = "VARCHAR2(20 CHAR) " + "CONSTRAINT users_firstname_nn NOT NULL")
	private String firstname;
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	@Column(name="LASTNAME",columnDefinition = "VARCHAR2(20 CHAR) " + "CONSTRAINT users_lastname_nn NOT NULL")
	private String lastname;
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	@Column(name="ADDRESS",columnDefinition = "VARCHAR2(500 CHAR) " + "CONSTRAINT users_address_nn NOT NULL")
	private String address;
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	

	@Column(name="EMAIL",columnDefinition = "VARCHAR2(200 CHAR) " + "CONSTRAINT users_email_nn_unique NOT NULL UNIQUE")
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	@Column(name="MOBILE_NO",columnDefinition = "VARCHAR2(10 CHAR) " + "CONSTRAINT users_mobile_no_nn_unique NOT NULL UNIQUE")
	private String mobileNo;
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name="DEPARTMENT_ID", referencedColumnName = "departmentId",columnDefinition="integer")
	private DAODepartment departmentId;
	
	public DAODepartment getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(DAODepartment departmentId) {
		this.departmentId = departmentId;
	}
	

	@ManyToOne
	@JoinColumn(name="COMPANY_ID", referencedColumnName = "companyId",columnDefinition="integer")
	private DAOCompany companyId;
	
	public DAOCompany getCompanyId() {
		return companyId;
	}

	public void setCompanyId(DAOCompany companyId) {
		this.companyId = companyId;
	}

	
	@OneToMany(targetEntity=DAOManageCoperate.class,mappedBy="requesterId", cascade = CascadeType.ALL)
	private List<DAOManageCoperate> DAOManageCoperateRequester;
	
	@OneToMany(targetEntity=DAOManageCoperate.class,mappedBy="accepterId", cascade = CascadeType.ALL)
	private List<DAOManageCoperate> DAOManageCoperateAccepter;

	@OneToMany(targetEntity=DAOTask.class,mappedBy="taskOwnerId", cascade = CascadeType.ALL)
	private List<DAOTask> DAOTaskTaskowner;
	
	@OneToMany(targetEntity=DAOSubTask.class,mappedBy="assignTo", cascade = CascadeType.ALL)
	private List<DAOSubTask> DAOSubTaskAssignto;
	
	@OneToMany(targetEntity=DAOComment.class,mappedBy="commentOwner", cascade = CascadeType.ALL)
	private List<DAOComment> DAOCommentCommentOwner;
	
	@OneToMany(targetEntity=DAOTransaction.class,mappedBy="actionOwnerId", cascade = CascadeType.ALL)
	private List<DAOTransaction> DAOTransactionActionOwner;
}
