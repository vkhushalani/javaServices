package com.erwat.lr.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erwat.lr.model.CaseTypeCategoryMap;
import com.erwat.lr.model.CaseTypeOutcomeMap;
import com.erwat.lr.model.CaseTypeRoleMap;
import com.erwat.lr.model.CaseTypeStatusMap;
import com.erwat.lr.model.CaseTypeSubTypeMap;
import com.erwat.lr.service.CaseTypeCategoryMapService;
import com.erwat.lr.service.CaseTypeOutcomeMapService;
import com.erwat.lr.service.CaseTypeRoleMapService;
import com.erwat.lr.service.CaseTypeStatusMapService;
import com.erwat.lr.service.CaseTypeSubTypeMapService;


@RestController
@RequestMapping("/TableMaint")
public class AssignController {
	
	private static String successMessage = "SUCCESS";
	Logger logger = LoggerFactory.getLogger(AssignController.class);
	
	
	@Autowired
	CaseTypeSubTypeMapService caseTypeSubTypeMapService;
	@Autowired
	CaseTypeStatusMapService caseTypeStatusMapService;
	@Autowired
	CaseTypeCategoryMapService caseTypeCategoryMapService;
	@Autowired
	CaseTypeOutcomeMapService caseTypeOutcomeMapService;
	@Autowired
	CaseTypeRoleMapService caseTypeRoleMapService;
	
	@PostMapping(value = "/assign/SubCaseToCase")
	public  ResponseEntity<?> assignSubCaseToCase(@RequestBody CaseTypeSubTypeMap assignBody)  {
		caseTypeSubTypeMapService.create(assignBody);
		return ResponseEntity.ok().body(successMessage);
		
	}
	
	@PostMapping(value = "/assign/StatusToCaseSubCase")
	public  ResponseEntity<?> assignStatusToCase(@RequestBody CaseTypeStatusMap assignBody)  {
		caseTypeStatusMapService.create(assignBody);
		return ResponseEntity.ok().body(successMessage);
		
	}
	
	@PostMapping(value = "/assign/CategoryToCaseSubCase")
	public  ResponseEntity<?> assignCategoryToCase(@RequestBody CaseTypeCategoryMap assignBody)  {
		caseTypeCategoryMapService.create(assignBody);
		return ResponseEntity.ok().body(successMessage);
		
	}
	@PostMapping(value = "/assign/OutcomeToCaseSubCase")
	public  ResponseEntity<?> assignOutcomeToCase(@RequestBody CaseTypeOutcomeMap assignBody)  {
		caseTypeOutcomeMapService.create(assignBody);
		return ResponseEntity.ok().body(successMessage);
		
	}
	@PostMapping(value = "/assign/RoleToCaseSubCase")
	public  ResponseEntity<?> assignRoleToCase(@RequestBody CaseTypeRoleMap assignBody)  {
		caseTypeRoleMapService.create(assignBody);
		return ResponseEntity.ok().body(successMessage);
		
	}
	
}
