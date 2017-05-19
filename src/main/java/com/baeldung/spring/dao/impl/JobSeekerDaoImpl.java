/**
 * 
 */
package com.baeldung.spring.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
	public List<?> filterJobs(JobPostingsView jpv) {
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
		if (null != jpv.getSalary()) {
			salaryFlag = true;
			if (locationFlag || companyFlag) {
				selectQuery = selectQuery.concat("AND");
			}
			selectQuery = selectQuery.concat(" jpv.salary = (:salary) ");
		}
		Query query = entityManager.createQuery(selectQuery);
		if (locationFlag){
			String[] location = jpv.getLocation().split(",");
			List<String> locationList = Arrays.asList(location);
			query.setParameter("locations", locationList);
		}
		if (companyFlag){
			String[] companyArray = jpv.getCompanyName().split(",");
			List<String> companyList = Arrays.asList(companyArray);
			query.setParameter("companies", companyList);
		}
		if (salaryFlag)
			query.setParameter("salary", jpv.getSalary());

		List<?> jpListRes = query.getResultList();
		
		return jpListRes;
		
	}
	
	@Override
	public JobSeeker createJobSeeker(JobSeeker jseeker) throws Exception {
		try {
			entityManager.persist(jseeker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jseeker;
	}
	
	@Override
	public JobSeeker getJobSeeker (int id) {
		JobSeeker js = null;
		
			js = entityManager.find(JobSeeker.class, id);
		
		return js;
	}
	
	
	
	@Override
	public JobSeeker updateJobSeeker (JobSeeker js)
	{
		JobSeeker jobseeker = getJobSeeker(js.getJobseekerId());
		jobseeker.setEmailId(js.getEmailId());
		jobseeker.setFirstName(js.getFirstName());
		jobseeker.setLastName(js.getLastName());
		jobseeker.setHighestEducation(js.getHighestEducation());
		jobseeker.setPassword(js.getPassword());
		jobseeker.setSkills(js.getSkills());
		jobseeker.setWorkEx(js.getWorkEx());
		try {
			if(jobseeker!=null){
				entityManager.merge(jobseeker);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobseeker;
	}
	
	
	@Override
	public List<String> PasswordLookUp(String emailid) {
		
		Query query = entityManager.createQuery("SELECT password FROM JobSeeker js WHERE js.emailId = :emailId ");
		query.setParameter("emailId", emailid);
		List<String> list = new ArrayList<String>();
		List<?> querylist = query.getResultList();
		for (Iterator<?> iterator = querylist.iterator(); iterator.hasNext();) {
			String pwd = (String) iterator.next();
			System.out.println(pwd +" is the password");
			list.add(pwd);
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.dao.JobSeekerDao#verify(com.baeldung.spring.entity.JobSeeker)
	 */
	@Override
	public void verify(JobSeeker j) {
		JobSeeker jobseeker = getJobSeeker(j.getJobseekerId());
		jobseeker.setVerified(true);
		try {
			if(jobseeker!=null){
				entityManager.merge(jobseeker);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.baeldung.spring.dao.JobSeekerDao#searchJobs(java.lang.String)
	 */
	@Override
	public List<?> searchJobs(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

}
