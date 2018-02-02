package com.erwat.lr.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.erwat.lr.model.CaseCategory;
import com.erwat.lr.service.CaseCategoryService;

@RestController
@RequestMapping("/TableMaint")
public class CaseCategoryController {
	Logger logger = LoggerFactory.getLogger(CaseCategoryController.class);
	@Autowired
	CaseCategoryService caseCategoryService;

	@GetMapping("/CaseCategory")
	public ResponseEntity<List<CaseCategory>> getAll(){
		
		List<CaseCategory> caseCategories = caseCategoryService.findAll();
	     return ResponseEntity.ok().body(caseCategories);
		
	}
	
	@GetMapping("/CaseCategory/{id}")
	 public ResponseEntity <CaseCategory> getById(@PathVariable("id") Integer id) {
		CaseCategory caseCategory = caseCategoryService.findById(id);
		return ResponseEntity.ok().body(caseCategory);
	   }
	@PostMapping(value = "/CaseCategory")
	public ResponseEntity<CaseCategory> create(@RequestBody CaseCategory caseCategory)  {
		caseCategory =  caseCategoryService.create(caseCategory);
		 return ResponseEntity.ok().body(caseCategory);
		
	}
	
	@PutMapping(value = "/CaseCategory")
	public ResponseEntity<CaseCategory> update(@RequestBody CaseCategory caseCategory)  {
		caseCategory =  caseCategoryService.update(caseCategory);
		 return ResponseEntity.ok().body(caseCategory);
		
	}
}


