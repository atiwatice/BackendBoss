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
	private long user_id;

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
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
	private String mobile_no;
	
	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

	

	@ManyToOne
	@JoinColumn(name="COMPANY_ID", referencedColumnName = "company_id",columnDefinition="integer")
	private DAOCompany company_id;
	
	public DAOCompany getCompany_id() {
		return company_id;
	}

	public void setCompany_id(DAOCompany company_id) {
		this.company_id = company_id;
	}

	
	@OneToMany(targetEntity=DAOManageCoperate.class,mappedBy="requester_id", cascade = CascadeType.ALL)
	private List<DAOManageCoperate> DAOManageCoperate_Requester;
	
	@OneToMany(targetEntity=DAOManageCoperate.class,mappedBy="accepter_id", cascade = CascadeType.ALL)
	private List<DAOManageCoperate> DAOManageCoperate_Accepter;

	@OneToMany(targetEntity=DAOTask.class,mappedBy="task_owner_id", cascade = CascadeType.ALL)
	private List<DAOTask> DAOTask_Task_owner;
	
	@OneToMany(targetEntity=DAOSubTask.class,mappedBy="assign_to", cascade = CascadeType.ALL)
	private List<DAOSubTask> DAOSubTask_Assign_to;
	
	@OneToMany(targetEntity=DAOComment.class,mappedBy="comment_owner", cascade = CascadeType.ALL)
	private List<DAOComment> DAOComment_Comment_Owner;
}
