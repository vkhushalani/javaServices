package com.erwat.lr.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.erwat.lr.v1.db::Table.LRD_CASE_NATURE\"", schema = "ERWAT_LR_SCHEMA")
@NamedQueries({ 
		@NamedQuery(name = "CaseNature.findAll", query = "SELECT ct FROM CaseNature ct ")
		
})
public class CaseNature {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "\"ID\"", columnDefinition = "INTEGER")
	private Integer id;
	
	@Column(name = "\"CATEGORY.ID\"")
     private long categoryId;
	
	@Column(name = "\"DESCRIPTION\"", columnDefinition = "VARCHAR(64)")
	private String description;

	@Column(name = "\"START_DATE\"", columnDefinition = "SECONDDATE")
	private Date sDate;
	
	@Column(name = "\"END_DATE\"", columnDefinition = "SECONDDATE")
	private Date eDate;
	
	@ManyToOne (fetch=FetchType.LAZY)
	@JoinColumn(name="\"CATEGORY.ID\"",referencedColumnName="\"ID\"",insertable=false, updatable=false)
	private CaseCategory cCategory;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
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

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}



}
