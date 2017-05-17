/**
 * 
 */
package com.baeldung.spring.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.JobPostingsView;
import com.baeldung.spring.entity.JobSeeker;

/**
 * @author amayd
 *
 */
@Repository
@Transactional
@Service
public class JobSeekerDaoImpl implements JobSeekerDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public JobApplication apply(int jobseekerId, int jobId, boolean resumeFlag, String resumePath) {
		JobApplication ja = new JobApplication();
		try {
			JobSeeker js = entityManager.find(JobSeeker.class, jobseekerId);
			JobPosting jp = entityManager.find(JobPosting.class, jobId);
			ja.setJobPosting(jp);
			ja.setJobSeeker(js);
			ja.setResume(resumeFlag);
			if (!resumePath.equals(null)) {
				ja.setResumePath(resumePath);
			}
			ja.setState(0);
			entityManager.persist(ja);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ja;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.baeldung.spring.dao.JobSeekerDao#searchJobs(com.baeldung.spring.
	 * entity.JobPostingsView)
	 */
	@Override
	public List<?> searchJobs(JobPostingsView jpv) {
		boolean locationFlag = false, companyFlag = false, salaryFlag = false;
		String selectQuery = "SELECT jobId, title, description, responsibilites, location, salary, companyId, companyName FROM JobPostingsView jpv WHERE";
		if (null != jpv.getLocation()) {
			locationFlag = true;
			selectQuery = selectQuery.concat(" jpv.location IN (:locations) ");
		}
		if (null != jpv.getCompanyName()) {
			companyFlag = true;
			if (locationFlag) {
				selectQuery = selectQuery.concat("AND");
			}
			selectQuery = selectQuery.concat(" jpv.companyName IN (:companies) ");
		}
		if (null != jpv.getCompanyName()) {
			salaryFlag = true;
			if (locationFlag || companyFlag) {
				selectQuery = selectQuery.concat("AND");
			}
			selectQuery = selectQuery.concat(" jpv.salary = (:salary) ");
		}
		Query query = entityManager.createQuery(selectQuery);
		if (locationFlag)
			query.setParameter("locations", jpv.getLocation());
		if (companyFlag)
			query.setParameter("companies", jpv.getCompanyName());
		if (salaryFlag)
			query.setParameter("salary", jpv.getSalary());

		List<?> jpListRes = query.getResultList();
		
		return jpListRes;
		
	}
}
