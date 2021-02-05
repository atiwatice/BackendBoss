package com.boss.backend.model;



import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;


@Entity
@Table(name = "COMPANY")
public class DAOCompany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "COMPANY_ID_SEQ")
	private int companyId;
	
	public int getCompanyId() {
        return companyId;
    }
	
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	
    @OneToMany(targetEntity=DAOUser.class,mappedBy="companyId", cascade = CascadeType.ALL)
    private List<DAOUser> DAOUsers;
    
	@Column(name="COMPANY_NAME",columnDefinition= "VARCHAR2(20 CHAR) " + 
			"CONSTRAINT company_company_name_nn NOT NULL UNIQUE")
	private String companyName;
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	@Column(name="COMPANY_DETAIL",columnDefinition= "VARCHAR2(100 CHAR)")
	private String companyDetail;
	
	public String getCompanyDetail() {
		return companyDetail;
	}

	public void setCompanyDetail(String companyDetail) {
		this.companyDetail = companyDetail;
	}
	
	@Column(name="COMPANY_START_DATE",columnDefinition = "DATE " + "CONSTRAINT company_start_date_nn NOT NULL")
	private Date companyStartDate;
	
	public Date getCompanyStartDate() {
		return companyStartDate;
	}

	public void setCompanyStartDate(Date companyStartDate) {
		this.companyStartDate = companyStartDate;
	}
	
	
	@Column(name ="DATETIME")
	@CreationTimestamp
    private LocalDateTime createdAt;

	
}
