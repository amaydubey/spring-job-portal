package com.baeldung.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.entity.Company;
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
	
	@Autowired
	CompanyDao companyDao;

	@RequestMapping(method = RequestMethod.GET)
    public String showHomePage(@RequestParam("cid") String cid, Model model) {
		Company company = companyDao.getCompany(Integer.parseInt(cid));
		model.addAttribute("company", company);
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
	@RequestMapping(method = RequestMethod.POST)
	public String createJobPosting(@RequestParam("title") String title,
			@RequestParam("description") String description, @RequestParam("responsibilities") String responsibilities,

			@RequestParam("location") String location, @RequestParam("salary") String salary,  @RequestParam("cid") String cid, Model model) {


		System.out.println("ashay");
		JobPosting j = new JobPosting();
		j.setTitle(title);
		j.setDescription(description);
		j.setResponsibilities(responsibilities);
		j.setLocation(location);
		j.setSalary(salary);
//		j.setCompany();
		
		
		

		try{
				
			JobPosting p1 =jobDao.createJobPosting(j, Integer.parseInt(cid));
			model.addAttribute("job", p1);
			Company company = companyDao.getCompany(Integer.parseInt(cid));
			model.addAttribute("company", company);
			return "jobprofile";
			
		}
		catch(Exception e){
		
			return "error";
		}	

	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteJobPosting(@PathVariable("id") int id, Model model) {
		
		
		
		if (jobDao.deleteJobPosting(id)){
			String message = "Job Posting with JobID "+id+" is deleted successfully";
			model.addAttribute("message", message);
			return "message";
		}
		else{
			return "error";
		}
			
}	
	
}