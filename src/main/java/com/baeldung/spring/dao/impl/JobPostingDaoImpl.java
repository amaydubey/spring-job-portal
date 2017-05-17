package com.baeldung.spring.dao.impl;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.entity.JobPosting;


@Repository
@Transactional
@Service
public class JobPostingDaoImpl implements JobPostingDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public JobPosting createJobPosting(JobPosting job) throws Exception {
		try {
			entityManager.persist(job);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return job;
	}

	@Override
	public JobPosting getJobPosting(int id) {
		JobPosting j = null;
		
			j = entityManager.find(JobPosting.class, id);
		
		return j;
	}

	@Override
	public boolean deleteJobPosting(int id) {
		JobPosting p = getJobPosting(id);
		if(p!=null){
			entityManager.remove(p);
		} else {
			return false;
		}
		return true;
	}

	@Override
	public JobPosting updateJobPosting(JobPosting p) {
		JobPosting p1 = getJobPosting(p.getJobId());
		p1.setDescription(p.getDescription());
		p1.setLocation(p.getLocation());
		p1.setResponsibilities(p.getResponsibilities());
		p1.setSalary(p.getSalary());
		p1.setState(p.getState());
		p1.setTitle(p.getTitle());
		try {
			if(p1!=null){
				entityManager.merge(p1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p1;
	}
}