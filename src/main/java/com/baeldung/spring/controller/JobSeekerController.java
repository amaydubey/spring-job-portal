/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPostingsView;

/**
 * @author ashay
 *
 */
@Controller
@RequestMapping(value="/")
public class JobSeekerController {

    @RequestMapping(value="/jobboard", method = RequestMethod.GET)
    public String showHomePage() {
        return "index";
    }
    
    @Autowired
    JobSeekerDao jobSeekerDao;
    
    /**
	 * @param jobSeekerId
	 * @param jobId
	 * @param resumeFlag
	 * @param resumePath
	 * @return The newly created application
	 */
	@RequestMapping(value="/apply", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> apply(@RequestParam("jobSeekerId") String jobSeekerId, @RequestParam("jobId") String jobId, @RequestParam("resumeFlag") boolean resumeFlag, @RequestParam("resumePath") String resumePath){
		JobApplication ja = new JobApplication();
		ja = jobSeekerDao.apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, resumePath);
		return ResponseEntity.ok(ja);
	}
	
	/**
	 * @param locations
	 * @return
	 */
	@RequestMapping(value="/searchjobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> searchJobs(@RequestParam("locations") Optional<String> locations, @RequestParam("companies") Optional<String> companies, @RequestParam("salary") Optional<String> salary){
		JobPostingsView jpv = new JobPostingsView();
		
		System.out.println("************************" + locations + " " + locations.equals(Optional.empty()));
		if(!locations.equals(Optional.empty())){
			jpv.setLocation(locations.get());
		}
		if(!companies.equals(Optional.empty())){
			jpv.setCompanyName(companies.get());
		}
		if(!salary.equals(Optional.empty())){
			jpv.setSalary(salary.get());
		}
		List<?> jp = jobSeekerDao.searchJobs(jpv);
		return ResponseEntity.ok(jp);
	}
}