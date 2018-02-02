package com.erwat.lr.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erwat.lr.model.CaseTypeCategoryMap;

@Transactional
@Component
public class CaseTypeCategoryMapServiceImp implements CaseTypeCategoryMapService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeCategoryMap> findAll() {
		Query query = em.createNamedQuery("CaseTypeCategoryMap.findAll");
		 List<CaseTypeCategoryMap> items = query.getResultList();

	        return items;
	}

	@Override
	public CaseTypeCategoryMap create(CaseTypeCategoryMap item) {
		em.persist(item);
		return item;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeCategoryMap> findByCaseCategoryId(Integer caseCategoryId) {
		Query query = em.createNamedQuery("CaseTypeCategoryMap.findByCaseCategoryId")
				.setParameter("caseCategoryId", caseCategoryId);
		List<CaseTypeCategoryMap> items = query.getResultList();

    return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeCategoryMap> findByCaseSubCaseId(Integer caseSubCaseId) {
		Query query = em.createNamedQuery("CaseTypeCategoryMap.findByCaseSubCaseId")
				.setParameter("caseSubCaseId", caseSubCaseId);
		List<CaseTypeCategoryMap> items = query.getResultList();

    return items;
	}

}
