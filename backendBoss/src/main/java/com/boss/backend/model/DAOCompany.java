package com.boss.backend.model;



import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "COMPANY")
public class DAOCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "COMPANY_ID_SEQ")
	private long COMPANY_ID;
	
	public long getCOMPANY_ID() {
        return COMPANY_ID;
    }

	
    @OneToMany(targetEntity=DAOUser.class,mappedBy="COMPANY_ID", cascade = CascadeType.ALL)
    private List<DAOUser> DAOUsers;
    
	@Column(columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT company_company_name_nn NOT NULL")
	private String COMPANY_NAME;
	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}
	public void setCOMPANY_NAME(String COMPANY_NAME) {
		this.COMPANY_NAME = COMPANY_NAME;
	}
	
	@Column(columnDefinition= "VARCHAR2(100 CHAR)")
	private String COMPANY_DETAIL;
	
	public String getCOMPANY_DETAIL() {
		return COMPANY_DETAIL;
	}

	public void setCOMPANY_DETAIL(String COMPANY_DETAIL) {
		this.COMPANY_DETAIL = COMPANY_DETAIL;
	}
	
	
	@Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private String DATETIME;
	
	public String getDATETIME() {
		return DATETIME;
	}

	
}
