package com.erwat.lr.service;

import java.util.List;

import com.erwat.lr.model.CaseTypeOutcomeMap;

public interface CaseTypeOutcomeMapService {
	public List<CaseTypeOutcomeMap> findAll();
	public CaseTypeOutcomeMap create(CaseTypeOutcomeMap item);
	public  List<CaseTypeOutcomeMap> findByOutcomeId(Integer outComeId);
	public  List<CaseTypeOutcomeMap> findByCaseSubCaseId(Integer caseSubCaseId);

}
