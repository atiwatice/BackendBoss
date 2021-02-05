package com.boss.backend.model;

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

@Entity
@Table(name = "TRANSACTION_TYPE")
public class DAOTransactionType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "increment")
	@SequenceGenerator(name = "SEQ", sequenceName = "TRANSACTION_TYPE_ID_SEQ")
	private int transactionTypeId;
	
	public int getTransactionTypeId() {
        return transactionTypeId;
    }
	
	public void setTransactionTypeId(int transactionTypeId) {
		this.transactionTypeId = transactionTypeId;
	}
	
	@Column(name="TRANSACTION_TYPE_NAME",columnDefinition= "VARCHAR2(100 CHAR)")
	private String transactionTypeName;
	
	public String getTransactionTypeName() {
		return transactionTypeName;
	}

	public void setTransactionTypeName(String transactionTypeName) {
		this.transactionTypeName = transactionTypeName;
	}
	
    @OneToMany(targetEntity=DAOTransaction.class,mappedBy="transactionTypeId", cascade = CascadeType.ALL)
    private List<DAOTransaction> DAOTransactions;
	
}
