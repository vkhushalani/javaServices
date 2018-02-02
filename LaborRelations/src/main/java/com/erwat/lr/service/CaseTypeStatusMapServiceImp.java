package com.erwat.lr.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erwat.lr.model.CaseTypeStatusMap;

@Transactional
@Component
public class CaseTypeStatusMapServiceImp implements CaseTypeStatusMapService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeStatusMap> findAll() {
		Query query = em.createNamedQuery("CaseTypeStatusMap.findAll");
		 List<CaseTypeStatusMap> items = query.getResultList();

	        return items;
	}

	@Override
	@Transactional
	public CaseTypeStatusMap create(CaseTypeStatusMap item) {
		em.persist(item);
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeStatusMap> findByCaseStatusId(Integer caseStatusId) {
		Query query = em.createNamedQuery("CaseTypeStatusMap.findByCaseStatusId")
				.setParameter("caseStatusId", caseStatusId);
		List<CaseTypeStatusMap> items = query.getResultList();

    return items;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeStatusMap> findByCaseSubCaseId(Integer caseSubCaseId) {
		Query query = em.createNamedQuery("CaseTypeStatusMap.findByCaseSubCaseId")
				.setParameter("caseSubCaseId", caseSubCaseId);
		List<CaseTypeStatusMap> items = query.getResultList();

    return items;
	}

}
