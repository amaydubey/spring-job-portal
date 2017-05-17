/**
 * 
 */
package com.baeldung.spring.dao;

import com.baeldung.spring.entity.JobApplication;

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

}
