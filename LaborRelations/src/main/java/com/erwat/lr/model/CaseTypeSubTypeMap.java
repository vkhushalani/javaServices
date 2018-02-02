package com.erwat.lr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_CASE_TO_SUB_CASE_MAP\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseTypeSubTypeMap.findAll", query = "SELECT ct FROM CaseTypeSubTypeMap ct"),
		@NamedQuery(name = "CaseTypeSubTypeMap.findByCaseSubCaseId", query = "SELECT ct FROM CaseTypeSubTypeMap ct WHERE ct.subCaseId = :subCaseId AND ct.caseId = :caseId "),
		@NamedQuery(name = "CaseTypeSubTypeMap.findByCaseId", query = "SELECT ct FROM CaseTypeSubTypeMap ct WHERE ct.caseId = :caseId"),
		@NamedQuery(name = "CaseTypeSubTypeMap.findBySubCaseId", query = "SELECT ct FROM CaseTypeSubTypeMap ct WHERE ct.subCaseId = :subCaseId")
		
})
public class CaseTypeSubTypeMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"ID\"", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "\"CASETYPE.ID\"", columnDefinition = "INTEGER")
	private Integer caseId;
	
	@Column(name = "\"SUB_CASE.ID\"", columnDefinition = "INTEGER")
	private Integer subCaseId;


	public Integer getSubCaseId() {
		return subCaseId;
	}


	public void setSubCaseId(Integer subCaseId) {
		this.subCaseId = subCaseId;
	}


	public Integer getCaseId() {
		return caseId;
	}


	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}
