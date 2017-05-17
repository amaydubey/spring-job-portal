package com.baeldung.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.json.XML;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.entity.JobPosting;


/**
 * @author surendra
 *
 */
@Controller
@RequestMapping("/JobPosting")
public class JobPostingController {

	@Autowired
	JobPostingDao jobDao;

	@RequestMapping(method = RequestMethod.GET)
    public String showHomePage() {
        return "postjob";
    }
	
	/**
	 * @param Title
	 * @param Description
	 * @param Responsibilities
	 * @param Location
	 * @param Salary
	 * @param State
	 * @return JobPosting Created
	 */
	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST)
	public String createJobPosting(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("responsibilities") String responsibilities,
			@RequestParam("location") String location, @RequestParam("salary") String salary, @RequestParam("state") int state, @RequestParam("cid") int cid, Model model) {

		System.out.println("ashay");
		JobPosting j = new JobPosting();
		j.setTitle(title);
		j.setDescription(description);
		j.setResponsibilities(responsibilities);
		j.setLocation(location);
		j.setSalary(salary);
		j.setState(state);
//		j.setCompany();
		
		System.out.println(model);
		

		try{
				
			JobPosting p1 =jobDao.createJobPosting(j, cid);
			model.addAttribute("job", p1);
			String cname = p1.getCompany().getCompanyName();
			model.addAttribute("companyname", cname);
			return "jobprofile";
			
		}
		catch(Exception e){
			HttpHeaders httpHeaders= new HttpHeaders();
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "another passenger with the phone number  already exists.");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return "error";
		}	

	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteJobPosting(@PathVariable("id") int id) {
		
		Map<String, Object> message = new HashMap<String, Object>();
		Map<String, Object> response = new HashMap<String, Object>();
		HttpHeaders httpHeaders= new HttpHeaders();
		
		if (jobDao.deleteJobPosting(id)){
			message.put("code", "200");
			message.put("msg", "Job Posting with JobID "+id+" is deleted successfully");
			response.put("Response", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity<String>(json_resp, httpHeaders, HttpStatus.OK);
		}
		else{
			System.out.println("Hello");
			message.put("code", "404");
			message.put("msg", "Sorry, the requested Job posting with JobID "+id+" does not exist");
			response.put("Response", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);

			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}
			
}	
	
}