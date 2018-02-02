package com.erwat.lr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_MAP_CASE_OUTCOMES\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseTypeOutcomeMap.findAll", query = "SELECT ct FROM CaseTypeOutcomeMap ct"),
		@NamedQuery(name = "CaseTypeOutcomeMap.findByOutcomeId", query = "SELECT ct FROM CaseTypeOutcomeMap ct WHERE ct.outcomeId = :outcomeId"),
		@NamedQuery(name = "CaseTypeOutcomeMap.findByCaseSubCaseId", query = "SELECT ct FROM CaseTypeOutcomeMap ct WHERE ct.caseSubCaseId = :caseSubCaseId")
		
})
public class CaseTypeOutcomeMap {
	
	@Id
	@Column(name = "\"OUTCOME.ID\"", columnDefinition = "INTEGER")
	private Integer outcomeId;
	
	@Id
	@Column(name = "\"CASE_SUB_CASE.ID\"", columnDefinition = "INTEGER")
	private Integer caseSubCaseId;


	public Integer getCaseSubCaseId() {
		return caseSubCaseId;
	}


	public void setCaseSubCaseId(Integer caseSubCaseId) {
		this.caseSubCaseId = caseSubCaseId;
	}


	public Integer getOutComeId() {
		return outcomeId;
	}


	public void setOutComeId(Integer outcomeId) {
		this.outcomeId = outcomeId;
	}
	

}
