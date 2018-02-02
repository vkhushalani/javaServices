package com.erwat.lr.service;

import java.util.List;

import com.erwat.lr.model.CaseTypeRoleMap;

public interface CaseTypeRoleMapService {
	
	public List<CaseTypeRoleMap> findAll();
	public CaseTypeRoleMap create(CaseTypeRoleMap item);
	public  List<CaseTypeRoleMap> findByRoleId(Integer roleId);
	public  List<CaseTypeRoleMap> findByCaseSubCaseId(Integer caseSubCaseId);


}
