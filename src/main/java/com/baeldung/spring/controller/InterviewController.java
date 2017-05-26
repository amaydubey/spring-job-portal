/**
 * 
 */
package com.baeldung.spring.controller;

import java.sql.Date;
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

import com.baeldung.spring.dao.InterviewDao;
import com.baeldung.spring.dao.JobApplicationDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.Interview;
import com.baeldung.spring.entity.JobApplication;
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
	JobApplicationDao jobAppDao;

	@Autowired
	EmailServiceImpl emailService;

	@PersistenceContext
	private EntityManager entityManager;

	@RequestMapping(value = "/createinterview", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createInterview(@RequestParam("appId") String appId,
			@RequestParam("location") String location, @RequestParam("datetime") String datetime) {
		System.out.println("started");
		JobApplication ja = jobAppDao.getJobApplication(Integer.parseInt(appId));
		JobSeeker jobSeeker = ja.getJobSeeker();
		ja.setInterviewFlag(true);
		ja.setInterviewLocation(location);
		ja.setInterviewTime(Date.valueOf(datetime));
		ja.setInterviewAccepted(false);
		jobAppDao.updateApplication(ja);
		String verificationUrl = "http://localhost:8080/acceptinterview?jobseekerid=" + ja.getAppId();
		System.out.println("interview created");
		emailService.sendSimpleMessage(jobSeeker.getEmailId(), "Interview call",
				"Hi " + jobSeeker.getFirstName() + " " + jobSeeker.getLastName()
						+ ", \nYou have been selected to interview for the position at time " + datetime
						+ " at VENUE : " + location
						+ ".\n If you are intereseted in it please click on the following link : \n" + verificationUrl);
		return ResponseEntity.ok(ja);
	}

	@RequestMapping(value = "/acceptinterview", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> acceptinterview(@RequestParam("appId") String appId) {
		System.out.println("started");
		JobApplication ja = jobAppDao.getJobApplication(Integer.parseInt(appId));
		JobSeeker jobSeeker = ja.getJobSeeker();
		ja.setInterviewAccepted(false);
		jobAppDao.updateApplication(ja);
		Company c = ja.getJobPosting().getCompany();

		emailService.sendSimpleMessage(c.getCompanyUser(), "Interview Response", jobSeeker.getFirstName() + " "
				+ jobSeeker.getLastName() + " has decide to move forward with the interview process");
		return ResponseEntity.ok(ja);
	}

}
