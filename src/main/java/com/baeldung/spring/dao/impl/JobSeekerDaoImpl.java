/**
 * 
 */
package com.baeldung.spring.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPosting;
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
		try{
			JobSeeker js = entityManager.find(JobSeeker.class, jobseekerId);
			JobPosting jp = entityManager.find(JobPosting.class, jobId);
			ja.setJobPosting(jp);
			ja.setJobSeeker(js);
			ja.setResume(resumeFlag);
			if(!resumePath.equals(null)){
				ja.setResumePath(resumePath);
			}
			ja.setState(0);
		}catch(Exception e){
			e.printStackTrace();
		}
		return ja;
	}
}
