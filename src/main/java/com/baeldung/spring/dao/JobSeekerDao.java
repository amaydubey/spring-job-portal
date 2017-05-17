/**
 * 
 */
package com.baeldung.spring.dao;

import java.util.List;

import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPostingsView;

/**
 * @author amayd
 *
 */
public interface JobSeekerDao {

	/**
	 * @param jobseekerId
	 * @param jobId
	 * @param resumeFlag
	 * @param resumePath
	 * @return The newly created job application
	 */
	JobApplication apply(int jobseekerId, int jobId, boolean resumeFlag, String resumePath);
	
	/**
	 * @param jpv
	 * @return Job Postings according to the provided parameter
	 */
	List<?> searchJobs(JobPostingsView jpv);

}
