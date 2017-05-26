/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.dao.JobApplicationDao;
import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.mail.EmailServiceImpl;

/**
 * @author amayd
 *
 */

@RestController
@RequestMapping(value = "/application")
public class JobApplicationController {

	@Autowired
	JobSeekerDao jobSeekerDao;

	@Autowired
	EmailServiceImpl emailService;

	@Autowired
	JobPostingDao jobDao;

	@Autowired
	JobApplicationDao jobAppDao;
	
	@Autowired
	InterestedDao interestedDao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String applyPage(@RequestParam("userId") String jobSeekerId, @RequestParam("jobId") String jobId, Model model){
		
		return "jobapplication";
	}
	
	
	/**
	 * @param jobSeekerId
	 * @param jobId
	 * @param resumeFlag
	 * @param resumePath
	 * @return The newly created application
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(@RequestParam("userId") String jobSeekerId, @RequestParam("jobId") String jobId,
			@RequestParam("resumeFlag") boolean resumeFlag, @RequestParam("resumePath") String resumePath, Model model) {
		JobApplication ja = new JobApplication();
		ja = jobAppDao.apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, resumePath);
		JobSeeker js = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId));
		JobPosting jp = jobDao.getJobPosting(Integer.parseInt(jobId));
		emailService.sendSimpleMessage(js.getEmailId(),
				"You have successfully applied to the position " + jp.getTitle() + " at "
						+ jp.getCompany().getCompanyName(),
				"Hi " + js.getFirstName() + " " + js.getLastName()
						+ ".\n You have successfully completed your application for " + jp.getTitle() + " at "
						+ jp.getCompany().getCompanyName() + ".\n Regards,\nThe FindJobs Team");
		Company company = jp.getCompany();
		List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(jobSeekerId));
		int i = 0;
		if(ij.contains(Integer.parseInt(jobId))){
			i = 1;
		}
		
		model.addAttribute("job", jp);
		model.addAttribute("seeker", js);
		model.addAttribute("company", company);
		model.addAttribute("interested", i);
		model.addAttribute("applied", 1);
		
		return "userjobprofile";
	}

	/**
	 * @param jobAppId
	 * @return True if the job application was cancelled
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String cancelApplication(@RequestParam("jobApplicationId") String jobAppId) {
		boolean deleted = jobAppDao.cancel(Integer.parseInt(jobAppId));
		if (deleted)
			return "Cancelled";
		return "Unable to delete";
	}

	/**
	 * @param jobAppId
	 * @param state
	 * @return true if the state has been modified
	 */
	@RequestMapping(value = "/modifyapplicationstate", method = RequestMethod.POST)
	public String modifyApplicationState(@RequestParam("jobAppId") String jobAppId,
			@RequestParam("state") String state) {
		JobApplication ja = jobAppDao.modifyJobApplicationStatus(Integer.parseInt(jobAppId), Integer.parseInt(state));
		if (ja == null) {
			return "Error";
		}
		return "modified";
	}

}
