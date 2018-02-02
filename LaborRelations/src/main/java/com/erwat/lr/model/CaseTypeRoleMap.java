package com.erwat.lr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_MAP_CASE_ROLE_MATRIX\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseTypeRoleMap.findAll", query = "SELECT ct FROM CaseTypeRoleMap ct"),
		@NamedQuery(name = "CaseTypeRoleMap.findByRoleId", query = "SELECT ct FROM CaseTypeRoleMap ct WHERE ct.roleId = :roleId"),
		@NamedQuery(name = "CaseTypeRoleMap.findByCaseSubCaseId", query = "SELECT ct FROM CaseTypeRoleMap ct WHERE ct.caseSubCaseId = :caseSubCaseId")
		
})
public class CaseTypeRoleMap {
	@Id
	@Column(name = "\"ROLE_MATRIX.ID\"", columnDefinition = "INTEGER")
	private Integer roleId;
	
	@Id
	@Column(name = "\"CASE_SUB_CASE.ID\"", columnDefinition = "INTEGER")
	private Integer caseSubCaseId;
	
	@Id
	@Column(name = "\"STAGE\"", columnDefinition = "INTEGER")
	private Integer stage;


	public Integer getCaseSubCaseId() {
		return caseSubCaseId;
	}


	public void setCaseSubCaseId(Integer caseSubCaseId) {
		this.caseSubCaseId = caseSubCaseId;
	}


	public Integer getOutComeId() {
		return roleId;
	}


	public void setOutComeId(Integer roleId) {
		this.roleId = roleId;
	}


	public Integer getStage() {
		return stage;
	}


	public void setStage(Integer stage) {
		this.stage = stage;
	}
}
