package com.erwat.lr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_SUB_CASE_TYPES\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "SubCaseType.findAll", query = "SELECT ct FROM SubCaseType ct")
})
public class SubCaseType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"ID\"", columnDefinition = "INTEGER")
	private Integer id;
	

	@Column(name = "\"DESCRIPTION\"", columnDefinition = "VARCHAR(64)")
	private String description;
	
	@Column(name = "\"START_DATE\"", columnDefinition = "SECONDDATE")
	private Date sDate;
	
	@Column(name = "\"END_DATE\"", columnDefinition = "SECONDDATE")
	private Date eDate;

	public Integer getSubCaseId() {
		return id;
	}

	public void setSubCaseId(Integer id) {
		this.id = id;
	}

	public String getSubCaseDescription() {
		return description;
	}

	public void setSubCaseDescription(String description) {
		this.description = description;
	}

	public Date getsDate() {
		return sDate;
	}

	public void setsDate(Date sDate) {
		this.sDate = sDate;
	}

	public Date geteDate() {
		return eDate;
	}

	public void seteDate(Date eDate) {
		this.eDate = eDate;
	}

}
