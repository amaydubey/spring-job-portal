package com.baeldung.spring.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.entity.Company;;



@Repository
@Transactional
@Service
public class CompanyDaoImpl implements CompanyDao {
	

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<String> PasswordLookUp(String emailid) {
		
		Query query = entityManager.createQuery("SELECT password FROM Company c WHERE c.companyUser = :emailId ");
		query.setParameter("emailId", emailid);
		List<String> list = new ArrayList<String>();
		List<?> querylist = query.getResultList();
		for (Iterator<?> iterator = querylist.iterator(); iterator.hasNext();) {
			String pwd = (String) iterator.next();
			System.out.println(pwd +" is the password");
			list.add(pwd);
		}
		System.out.println("list :::::::::::::::::::::::::::::       "+list);
		return list;
	}
	
	@Override
	public Company createCompany(Company c) throws Exception {
		try {
			entityManager.persist(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

}