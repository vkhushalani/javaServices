package com.erwat.lr.service;

import java.util.List;

import com.erwat.lr.model.CaseTypeStatusMap;

public interface CaseTypeStatusMapService {
	public List<CaseTypeStatusMap> findAll();
	public CaseTypeStatusMap create(CaseTypeStatusMap item);
	public  List<CaseTypeStatusMap> findByCaseStatusId(Integer caseStatusId);
	public  List<CaseTypeStatusMap> findByCaseSubCaseId(Integer caseSubCaseId);

}
