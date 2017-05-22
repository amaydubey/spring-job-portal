/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.CompanyDao;

/**
 * @author amayd
 *
 */
@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyDao companyDao;

	/**
	 * @param companyId
	 * @param state
	 * @return List of jobs posted by the company
	 */
	@RequestMapping(value = "/getjobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> getJobs(@RequestParam("companyId") String companyId, @RequestParam("state") String state) {
		List<?> companyJobPostings = new ArrayList<String>();
		companyJobPostings = companyDao.getJobsByCompany(Integer.parseInt(companyId), Integer.parseInt(state));
		return ResponseEntity.ok(companyJobPostings);
	}

}
