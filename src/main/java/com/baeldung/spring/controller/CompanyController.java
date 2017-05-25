/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobSeeker;

/**
 * @author amayd
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyDao companyDao;

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String showJobSeeker(@PathVariable("id") int id, Model model){
		
		Company company = companyDao.getCompany(id);
		
		model.addAttribute("company", company);
		return "companyprofile"; 
	}
	
	/**
	 * @param companyId
	 * @param state
	 * @return List of jobs posted by the company
	 */
	@RequestMapping(value = "/getjobs", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> getJobs(@RequestParam("companyId") String companyId, @RequestParam("state") String state) {
		List<?> companyJobPostings = new ArrayList<String>();
		companyJobPostings = companyDao.getJobsByCompany(Integer.parseInt(companyId), Integer.parseInt(state));
		return ResponseEntity.ok(companyJobPostings);
	}

}
