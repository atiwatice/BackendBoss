package com.boss.backend.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "DEPARTMENT")
public class DAODepartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "DEPARTMENT_ID_SEQ")
	private int departmentId;
	
	public int getDepartmentId() {
        return departmentId;
    }
	
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	
    @OneToMany(targetEntity=DAOUser.class,mappedBy="departmentId", cascade = CascadeType.ALL)
    private List<DAOUser> DAOUsers;
    
	@Column(name="DEPARTMENT_NAME",columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT department_name_nn NOT NULL UNIQUE")
	private String departmentName;
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	@Column(name="DEPARTMENT_DETAIL",columnDefinition= "VARCHAR2(100 CHAR)")
	private String departmentDetail;
	
	public String getDepartmentDetail() {
		return departmentDetail;
	}

	public void setDepartmentDetail(String departmentDetail) {
		this.departmentDetail = departmentDetail;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;
}
