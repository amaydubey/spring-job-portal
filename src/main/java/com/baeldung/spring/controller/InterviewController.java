/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.InterviewDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.dao.impl.InterviewDaoImpl;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.Interview;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.mail.EmailServiceImpl;

/**
 * @author Avdeep
 *
 */
@RestController
public class InterviewController {

	@Autowired
	InterviewDao interviewdao;
	
	@Autowired
	JobSeekerDao jobSeekerDao;
	
	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	EmailServiceImpl emailService;
	
	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping(value = "/createinterview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createInterview(@RequestParam("jobSeekerId") String jobSeekerId, @RequestParam("company") String company, @RequestParam("location") String location, @RequestParam("datetime") String datetime) {
		System.out.println("started");
		Interview interview = new Interview();
		JobSeeker seeker = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId));
		String verificationUrl = "http://localhost:8080/acceptinterview?jobseekerid=" + jobSeekerId;
		interview = interviewdao.createInterview(Integer.parseInt(jobSeekerId),company,location,datetime,"false");
		System.out.println("interview created");
		emailService.sendSimpleMessage(seeker.getEmailId(),"Interview call", "Hi "+seeker.getFirstName()+" "+seeker.getLastName() +", \nYou have been selected to interview for the position at time "+ datetime + " at VENUE : "+ location +".\n If you are intereseted in it please click on the following link : \n" 
				+ verificationUrl);
		return  ResponseEntity.ok(interview);
	}
	
	@RequestMapping(value = "/acceptinterview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> acceptinterview(@RequestParam("jobSeekerId") String jobSeekerId, @RequestParam("companyid") String companyId) {
		System.out.println("started");
		Interview interview = new Interview();
	    Company company = companyDao.getCompany(Integer.parseInt(companyId));
		JobSeeker seeker = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId));
		String result = interviewdao.acceptInterview(Integer.parseInt(jobSeekerId));
		System.out.println("interview created");
		Query query = entityManager.createQuery("SELECT flag from interview int WHERE int.jobseekerid = :jobseekerid");
		query.setParameter("jobseekerid", jobSeekerId);
		List<?> querylist = query.getResultList();
		ArrayList<String> list = new ArrayList<>();
		for (Iterator<?> iterator = querylist.iterator(); iterator.hasNext();) {
			String flag = (String) iterator.next();
			list.add(flag);
		}
		String decision = "";
		if(list.get(0).equals("true"))
		{
			decision = "" ;
		}
		else
		{
			decision = "not";
		}
		
		emailService.sendSimpleMessage(company.getCompanyUser(),"Interview Response",seeker.getFirstName()+" "+seeker.getLastName()+" has decide to "+ decision +" move forward with the interview process");
		return  ResponseEntity.ok(interview);
	}
	
	
	
}















