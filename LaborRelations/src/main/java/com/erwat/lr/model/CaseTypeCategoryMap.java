package com.erwat.lr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_MAP_CASE_CATEGORY\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseTypeCategoryMap.findAll", query = "SELECT ct FROM CaseTypeCategoryMap ct"),
		@NamedQuery(name = "CaseTypeCategoryMap.findByCaseCategoryId", query = "SELECT ct FROM CaseTypeCategoryMap ct WHERE ct.caseCategoryId = :caseCategoryId"),
		@NamedQuery(name = "CaseTypeCategoryMap.findByCaseSubCaseId", query = "SELECT ct FROM CaseTypeCategoryMap ct WHERE ct.caseSubCaseId = :caseSubCaseId")
		
})
public class CaseTypeCategoryMap {
	
	@Id
	@Column(name = "\"CASE_CATEGORY.ID\"", columnDefinition = "INTEGER")
	private Integer caseCategoryId;
	
	@Id
	@Column(name = "\"CASE_SUB_CASE.ID\"", columnDefinition = "INTEGER")
	private Integer caseSubCaseId;


	public Integer getCaseSubCaseId() {
		return caseSubCaseId;
	}


	public void setCaseSubCaseId(Integer caseSubCaseId) {
		this.caseSubCaseId = caseSubCaseId;
	}


	public Integer getCaseCategoryId() {
		return caseCategoryId;
	}


	public void setCaseCategoryId(Integer caseId) {
		this.caseCategoryId = caseId;
	}
	

}
