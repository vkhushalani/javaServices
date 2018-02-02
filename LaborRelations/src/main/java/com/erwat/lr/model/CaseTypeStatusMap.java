package com.erwat.lr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_MAP_CASE_STATUS\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseTypeStatusMap.findAll", query = "SELECT ct FROM CaseTypeStatusMap ct"),
		@NamedQuery(name = "CaseTypeStatusMap.findByCaseStatusId", query = "SELECT ct FROM CaseTypeStatusMap ct WHERE ct.caseStatusId = :caseStatusId"),
		@NamedQuery(name = "CaseTypeStatusMap.findByCaseSubCaseId", query = "SELECT ct FROM CaseTypeStatusMap ct WHERE ct.caseSubCaseId = :caseSubCaseId")
		
})
public class CaseTypeStatusMap {

	@Id
	@Column(name = "\"CASE_STATUS.ID\"", columnDefinition = "INTEGER")
	private Integer caseStatusId;
	
	@Id
	@Column(name = "\"CASE_SUB_CASE.ID\"", columnDefinition = "INTEGER")
	private Integer caseSubCaseId;


	public Integer getCaseSubCaseId() {
		return caseSubCaseId;
	}


	public void setCaseSubCaseId(Integer caseSubCaseId) {
		this.caseSubCaseId = caseSubCaseId;
	}


	public Integer getCaseStausId() {
		return caseStatusId;
	}


	public void setCaseStausId(Integer caseStatusId) {
		this.caseStatusId = caseStatusId;
	}
	
}
