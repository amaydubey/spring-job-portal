/**
 * 
 */
package com.baeldung.spring.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.mail.EmailServiceImpl;

/**
 * @author ashay
 *
 */
@Controller

@RequestMapping(value = "/")
public class MainController {

	/**
	 * @return Homepage
	 */
	@RequestMapping(value = "/findjobs", method = RequestMethod.GET)
	public String showHomePage() {
		return "index";
	}

	/**
	 * @return Register page
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showRegisterPage() {
		return "register";
	}

	@Autowired
	JobSeekerDao jobSeekerDao;
	
	@Autowired
	CompanyDao companyDao;

	@Autowired
	EmailServiceImpl emailService;

		/**
	 * @param emailId
	 * @param password
	 * @param type
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam("emailId") String emailId, @RequestParam("password") String password,
			@RequestParam("type") String type, Model model) {
		List<String> list = new ArrayList<String>();
		String email = emailId;
		String pwd = password;
		System.out.println(email + " : " + pwd);

		if (type.equals("recruiter")) {
			list = companyDao.PasswordLookUp(email);
		} else if (type.equals("seeker")) {
			list = jobSeekerDao.PasswordLookUp(email);
		}

		System.out.println(list);
		if (list.size() == 0) {
			return "UserName Invalid";
		} else {
			if (pwd.equals(list.get(0))) {
				return "Login Successful";
			}

		}
		return "Invalid Password";

	}

	/**
	 * @param type
	 * @param pin
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/register/verify", method = RequestMethod.GET)
	public String verification(@RequestParam("type") String type, @RequestParam("pin") int pin,
			@RequestParam("userId") int userId, Model model) {

		if (type.equals("seeker")) {

			JobSeeker j = jobSeekerDao.getJobSeeker(userId);
			if (j.getVerificationCode() == pin) {
				j.setVerified(true);
				jobSeekerDao.verify(j);
				model.addAttribute("seeker", j);
				return "userregister";
			} else {
				return "error";

			}

		} else {

			Company j = companyDao.getCompany(userId);
			if (j.getVerificationCode() == pin) {
				j.setVerified(true);
				companyDao.verify(j);
				model.addAttribute("company", j);
				return "companyregister";
			} else {
				return "error";
			}

		}

		

	}
	
	
}