package com.erwat.lr.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erwat.lr.model.CaseTypeOutcomeMap;

@Transactional
@Component
public class CaseTypeOutcomeMapServiceImp implements CaseTypeOutcomeMapService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeOutcomeMap> findAll() {
		Query query = em.createNamedQuery("CaseTypeOutcomeMap.findAll");
		 List<CaseTypeOutcomeMap> items = query.getResultList();

	        return items;
	}

	@Override
	@Transactional
	public CaseTypeOutcomeMap create(CaseTypeOutcomeMap item) {
		em.persist(item);
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeOutcomeMap> findByOutcomeId(Integer outcomeId) {
		Query query = em.createNamedQuery("CaseTypeStatusMap.findByOutcomeId")
				.setParameter("outcomeId", outcomeId);
		List<CaseTypeOutcomeMap> items = query.getResultList();

   return items;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeOutcomeMap> findByCaseSubCaseId(Integer caseSubCaseId) {
		Query query = em.createNamedQuery("CaseTypeOutcomeMap.findByCaseSubCaseId")
				.setParameter("caseSubCaseId", caseSubCaseId);
		List<CaseTypeOutcomeMap> items = query.getResultList();

   return items;
	}

}
