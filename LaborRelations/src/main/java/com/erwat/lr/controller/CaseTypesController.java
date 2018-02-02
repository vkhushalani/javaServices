package com.erwat.lr.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.erwat.lr.helper.TileCount;
import com.erwat.lr.model.CaseCategory;
import com.erwat.lr.model.CaseOutcome;
import com.erwat.lr.model.CaseRole;
import com.erwat.lr.model.CaseStatus;
import com.erwat.lr.model.CaseTypeCategoryMap;
import com.erwat.lr.model.CaseTypeOutcomeMap;
import com.erwat.lr.model.CaseTypeRoleMap;
import com.erwat.lr.model.CaseTypeStatusMap;
import com.erwat.lr.model.CaseTypeSubTypeMap;
import com.erwat.lr.model.CaseTypes;
import com.erwat.lr.model.SubCaseType;
import com.erwat.lr.service.CaseCategoryService;
import com.erwat.lr.service.CaseNatureService;
import com.erwat.lr.service.CaseOutcomeService;
import com.erwat.lr.service.CaseRoleService;
import com.erwat.lr.service.CaseStatusService;
import com.erwat.lr.service.CaseTypeCategoryMapService;
import com.erwat.lr.service.CaseTypeOutcomeMapService;
import com.erwat.lr.service.CaseTypeRoleMapService;
import com.erwat.lr.service.CaseTypeService;
import com.erwat.lr.service.CaseTypeStatusMapService;
import com.erwat.lr.service.CaseTypeSubTypeMapService;
import com.erwat.lr.service.SubCaseTypeService;


@RestController
@RequestMapping("/TableMaint")
public class CaseTypesController {

	Logger logger = LoggerFactory.getLogger(CaseTypesController.class);
	
	@Autowired
	 CaseTypeService caseTypeService;
	@Autowired
	SubCaseTypeService subCaseTypeService;
	
	@Autowired
	CaseTypeSubTypeMapService caseTypeSubTypeMapService;
	
	@Autowired
	CaseTypeStatusMapService caseTypeStatusMapService;
	
	@Autowired
	CaseStatusService caseStatusService;
	
	@Autowired
	CaseTypeCategoryMapService caseTypeCategoryMapService;
	
	@Autowired
	CaseCategoryService caseCategoryService;
	
	@Autowired
	CaseTypeOutcomeMapService caseTypeOutcomeMapService;
	
	@Autowired
	CaseOutcomeService caseOutcomeService;
	
	@Autowired
	CaseTypeRoleMapService caseTypeRoleMapService;
	
	@Autowired
	CaseRoleService caseRoleService;
	
	@Autowired
	CaseNatureService caseNatureService;
	
	@GetMapping("/CaseType")
	public ResponseEntity<List<CaseTypes>> getAllCaseTypes(){
		
		List<CaseTypes> caseTypes = caseTypeService.findAll();
	     return ResponseEntity.ok().body(caseTypes);
		
	}
	
	@GetMapping("/CaseType/{id}")
	   public ResponseEntity <CaseTypes> getCaseTypeById(@PathVariable("id") Integer caseId) {
		CaseTypes caseTypes = caseTypeService.findById(caseId);
		return ResponseEntity.ok().body(caseTypes);
	   }
	
	@GetMapping("/CaseType/{id}/SubCaseType")
	   public ResponseEntity <List<SubCaseType>> getSubCaseTypesByCaseId(@PathVariable("id") Integer caseId) {
		List<CaseTypeSubTypeMap> caseSubMapList = caseTypeSubTypeMapService.findByCaseId(caseId);
		List<SubCaseType> subCaseTypes = new ArrayList<SubCaseType>();
		for(CaseTypeSubTypeMap caseSubMap: caseSubMapList){
			
			subCaseTypes.add(subCaseTypeService.findById(caseSubMap.getSubCaseId()));
		}
		return ResponseEntity.ok().body(subCaseTypes);
	   }
	
	@GetMapping("/CaseType/{id}/CaseStatus")
	   public ResponseEntity <List<CaseStatus>> getCaseStatusByCaseId(@PathVariable("id") Integer caseId,@RequestParam(value = "subCaseId") Integer subCaseId) {
		
		CaseTypeSubTypeMap caseSubMap = caseTypeSubTypeMapService.findByCaseSubCaseId(caseId,subCaseId);
		
		List<CaseTypeStatusMap> caseStatusMapList = caseTypeStatusMapService.findByCaseSubCaseId(caseSubMap.getId());
		List<CaseStatus> caseSatuses = new ArrayList<CaseStatus>();
		for(CaseTypeStatusMap caseStatusMap: caseStatusMapList){
			
			caseSatuses.add(caseStatusService.findById(caseStatusMap.getCaseStausId()));
		}
		return ResponseEntity.ok().body(caseSatuses);
	  }
	
	@GetMapping("/CaseType/{id}/CaseCategory")
	   public ResponseEntity <List<CaseCategory>> getCaseCategoryByCaseId(@PathVariable("id") Integer caseId,@RequestParam(value = "subCaseId") Integer subCaseId) {
		CaseTypeSubTypeMap caseSubMap = caseTypeSubTypeMapService.findByCaseSubCaseId(caseId,subCaseId);
		List<CaseTypeCategoryMap> caseCategoryMapList = caseTypeCategoryMapService.findByCaseSubCaseId(caseSubMap.getId());
		List<CaseCategory> caseCategory = new ArrayList<CaseCategory>();
		for(CaseTypeCategoryMap caseCategoryMap: caseCategoryMapList){
			
			caseCategory.add(caseCategoryService.findById(caseCategoryMap.getCaseCategoryId()));
		}
		return ResponseEntity.ok().body(caseCategory);
	  }
	@GetMapping("/CaseType/{id}/CaseOutcome")
	   public ResponseEntity <List<CaseOutcome>> getCaseOutcomeByCaseId(@PathVariable("id") Integer caseId,@RequestParam(value = "subCaseId") Integer subCaseId) {
		CaseTypeSubTypeMap caseSubMap = caseTypeSubTypeMapService.findByCaseSubCaseId(caseId,subCaseId);
		List<CaseTypeOutcomeMap> caseOutcomeMapList = caseTypeOutcomeMapService.findByCaseSubCaseId(caseSubMap.getId());
		List<CaseOutcome> caseOutcome = new ArrayList<CaseOutcome>();
		for(CaseTypeOutcomeMap caseOutcomeMap: caseOutcomeMapList){
			
			caseOutcome.add(caseOutcomeService.findById(caseOutcomeMap.getOutComeId()));
		}
		return ResponseEntity.ok().body(caseOutcome);
	  }
	
	@GetMapping("/CaseType/{id}/CaseRole")
	   public ResponseEntity <List<CaseRole>> getCaseRoleByCaseId(@PathVariable("id") Integer caseId,@RequestParam(value = "subCaseId") Integer subCaseId) {
		CaseTypeSubTypeMap caseSubMap = caseTypeSubTypeMapService.findByCaseSubCaseId(caseId,subCaseId);
		List<CaseTypeRoleMap> caseRoleMapList = caseTypeRoleMapService.findByCaseSubCaseId(caseSubMap.getId());;
		List<CaseRole> caseRole = new ArrayList<CaseRole>();
		for(CaseTypeRoleMap caseRoleMap: caseRoleMapList){
			
			caseRole.add(caseRoleService.findById(caseRoleMap.getOutComeId()));
		}
		return ResponseEntity.ok().body(caseRole);
	  }
	
	
	@PostMapping(value = "/CaseType")
	public ResponseEntity<CaseTypes> createCaseType(@RequestBody CaseTypes caseType)  {
		caseType =  caseTypeService.create(caseType);
		return ResponseEntity.ok().body(caseType);
		
	}
	
	@PutMapping(value = "/CaseType")
	public ResponseEntity<CaseTypes> updateCaseType(@RequestBody CaseTypes caseType)  {
		caseType =  caseTypeService.update(caseType);
		return ResponseEntity.ok().body(caseType);
		
	}
	@GetMapping("/tilesCount")
	public ResponseEntity <List<TileCount>> getTileCount(){
		List<TileCount> tileCountList = new ArrayList<TileCount>();
		TileCount tileCount;
		
		//Case Type
		tileCount = new TileCount();
		tileCount.setKey("CaseType");
		tileCount.setCount(caseTypeService.findAll().size());
		tileCountList.add(tileCount);
		
		//Sub Case 
		tileCount = new TileCount();
		tileCount.setKey("SubCaseType");
		tileCount.setCount(subCaseTypeService.findAll().size());
		tileCountList.add(tileCount);
		
		// Case Status
		tileCount = new TileCount();
		tileCount.setKey("CaseStatus");
		tileCount.setCount(caseStatusService.findAll().size());
		tileCountList.add(tileCount);
		
		//Case Category
		tileCount = new TileCount();
		tileCount.setKey("CaseCategory");
		tileCount.setCount(caseCategoryService.findAll().size());
		tileCountList.add(tileCount);
		
		//Case Nature
		tileCount = new TileCount();
		tileCount.setKey("CaseNature");
		tileCount.setCount(caseNatureService.findAll().size());
		tileCountList.add(tileCount);
		
		// Case Outcome
		tileCount = new TileCount();
		tileCount.setKey("CaseOutcome");
		tileCount.setCount(caseOutcomeService.findAll().size());
		tileCountList.add(tileCount);
		
		//Case Role
		tileCount = new TileCount();
		tileCount.setKey("CaseRole");
		tileCount.setCount(caseRoleService.findAll().size());
		tileCountList.add(tileCount);
		
		return ResponseEntity.ok().body(tileCountList);
		
	}
	
}
