package com.boss.backend.model;



import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "COMPANY")
public class DAOCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "COMPANY_ID_SEQ")
	private long company_id;
	
	public long getCompany_id() {
        return company_id;
    }

	
    @OneToMany(targetEntity=DAOUser.class,mappedBy="company_id", cascade = CascadeType.ALL)
    private List<DAOUser> DAOUsers;
    
	@Column(name="COMPANY_NAME",columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT company_company_name_nn NOT NULL")
	private String company_name;
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	
	@Column(name="COMPANY_DETAIL",columnDefinition= "VARCHAR2(100 CHAR)")
	private String company_detail;
	
	public String getCompany_detail() {
		return company_detail;
	}

	public void setCompany_detail(String company_detail) {
		this.company_detail = company_detail;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

	
}
