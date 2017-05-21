package com.baeldung.spring.dao;

import com.baeldung.spring.entity.JobPosting;


/**
 * @author surendrary
 *
 */
public interface JobPostingDao {
	
	/**
	 * @param job
	 * @param cid
	 * @return New JobPosting
	 * @throws Exception 
	 */
	JobPosting createJobPosting(JobPosting job, int cid) throws Exception;
	
	/**
	 * @param id
	 * @return Requested JobPosting
	 */
	JobPosting getJobPosting(int id);

	/**
	 * @param id
	 * @return True if JobPosting is Deleted
	 */
	boolean deleteJobPosting(int id);

	/**
	 * @param job
	 * @return Updated Job Posting
	 */
	JobPosting updateJobPosting(JobPosting job);

}