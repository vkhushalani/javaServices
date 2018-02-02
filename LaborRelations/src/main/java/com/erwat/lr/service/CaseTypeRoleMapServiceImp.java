package com.erwat.lr.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.erwat.lr.model.CaseTypeRoleMap;
@Transactional
@Component
public class CaseTypeRoleMapServiceImp implements CaseTypeRoleMapService {

	@PersistenceContext
	 EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeRoleMap> findAll() {
		Query query = em.createNamedQuery("CaseTypeRoleMap.findAll");
		 List<CaseTypeRoleMap> items = query.getResultList();

	        return items;
	}

	@Override
	@Transactional
	public CaseTypeRoleMap create(CaseTypeRoleMap item) {
		em.persist(item);
		return item;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeRoleMap> findByRoleId(Integer roleId) {
		Query query = em.createNamedQuery("CaseTypeRoleMap.findByRoleId")
				.setParameter("roleId", roleId);
		List<CaseTypeRoleMap> items = query.getResultList();

  return items;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<CaseTypeRoleMap> findByCaseSubCaseId(Integer caseSubCaseId) {
		Query query = em.createNamedQuery("CaseTypeOutcomeMap.findByCaseSubCaseId")
				.setParameter("caseSubCaseId", caseSubCaseId);
		List<CaseTypeRoleMap> items = query.getResultList();

  return items;
	}

}
