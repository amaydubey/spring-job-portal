/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.JobSeeker;

/**
 * @author amayd
 *
 */
@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	JobPostingDao jobDao;
	
	@Autowired
	InterestedDao interestedDao;
	
	@Autowired
	JobSeekerDao jobSeekerDao;

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String showJobSeeker(@PathVariable("id") int id, Model model){
		
		Company company = companyDao.getCompany(id);
		
		model.addAttribute("company", company);
		return "companyprofile"; 
	}
	
	@RequestMapping(value = "/showjob", method = RequestMethod.GET)
	public String showJob(@RequestParam("cid") String cid, @RequestParam("jobId") String jobId, Model model) {
		
		
		JobPosting p1 = jobDao.getJobPosting(Integer.parseInt(jobId));
		Company company = companyDao.getCompany(Integer.parseInt(cid));
		model.addAttribute("job", p1);
		model.addAttribute("company", company);
		return "jobprofile";
	}
	
	@RequestMapping(value = "/showapplicants", method = RequestMethod.GET)
	public String showJobApplicants(@RequestParam("jobId") String jobId, Model model) {
		
		
		JobPosting p1 = jobDao.getJobPosting(Integer.parseInt(jobId));
		model.addAttribute("job", p1);
		return "jobprofile";
	}
	
	/**
	 * @param companyId
	 * @param state
	 * @return List of jobs posted by the company
	 */
	@RequestMapping(value = "/getjobs", method = RequestMethod.GET)
	public String getJobs(@RequestParam("companyId") String companyId, Model model) {
		List<?> companyJobPostings = new ArrayList<String>();
		companyJobPostings = companyDao.getJobsByCompany(Integer.parseInt(companyId));
		Company company = companyDao.getCompany(Integer.parseInt(companyId));
		
		model.addAttribute("jobs", companyJobPostings);
		model.addAttribute("company", company);
		
		return "companyjobs";
	}

}
