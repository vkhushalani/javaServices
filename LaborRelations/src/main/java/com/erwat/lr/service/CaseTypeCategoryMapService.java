package com.erwat.lr.service;

import java.util.List;

import com.erwat.lr.model.CaseTypeCategoryMap;

public interface CaseTypeCategoryMapService {
	public List<CaseTypeCategoryMap> findAll();
	public CaseTypeCategoryMap create(CaseTypeCategoryMap item);
	public  List<CaseTypeCategoryMap> findByCaseCategoryId(Integer caseCategoryId);
	public  List<CaseTypeCategoryMap> findByCaseSubCaseId(Integer caseSubCaseId);


}
