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

import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.entity.Interested;
import com.baeldung.spring.entity.JobPosting;

/**
 * @author ashay
 *
 */
@Repository
@Transactional
@Service
public class InterestedDaoImpl implements InterestedDao {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * @Override public List<String> PasswordLookUp(String emailid) {
	 * 
	 * Query query = entityManager.
	 * createQuery("SELECT password FROM Company c WHERE c.companyUser = :emailId "
	 * ); query.setParameter("emailId", emailid); List<String> list = new
	 * ArrayList<String>(); List<?> querylist = query.getResultList(); for
	 * (Iterator<?> iterator = querylist.iterator(); iterator.hasNext();) {
	 * String pwd = (String) iterator.next(); System.out.println(pwd +
	 * " is the password"); list.add(pwd); }
	 * System.out.println("list :::::::::::::::::::::::::::::       " + list);
	 * return list; }
	 */
	@Override
	public Interested createInterest(Interested c) throws Exception {
		try {
			entityManager.persist(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}

	@Override
	public Interested getInterest(int id) {
		Interested is = null;

		is = entityManager.find(Interested.class, id);

		return is;
	}

	@Override
	public boolean deleteInterest(int id) {
		Interested i = getInterest(id);
		if (i != null) {
			entityManager.remove(i);
		} else {
			return false;
		}
		return true;
	}
	
	/**
	 * @param jobId
	 * @param userId
	 * @return Job Id for interested list
	 */
	public List<?> getInterestedJobId(int jobId, int userId) {
		Query query = entityManager.createQuery("SELECT ID FROM Interested jd WHERE jd.jobId = :jobid and jd.jobSeekerId =:userid");
		query.setParameter("jobid", jobId);
		query.setParameter("userid", userId);
		List<?> querylist = query.getResultList();
		return querylist;
	}

}