/**
 * 
 */
package com.baeldung.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.dao.impl.JobSeekerDaoImpl;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPostingsView;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.mail.EmailServiceImpl;

/**
 * @author ashay
 *
 */
@Controller

@RequestMapping(value = "/")
public class JobSeekerController {

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
	EmailServiceImpl emailService;

	/**
	 * @param jobSeekerId
	 * @param jobId
	 * @param resumeFlag
	 * @param resumePath
	 * @return The newly created application
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> apply(@RequestParam("jobSeekerId") String jobSeekerId, @RequestParam("jobId") String jobId,
			@RequestParam("resumeFlag") boolean resumeFlag, @RequestParam("resumePath") String resumePath) {
		JobApplication ja = new JobApplication();
		ja = jobSeekerDao.apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, resumePath);
		return ResponseEntity.ok(ja);
	}

	/**
	 * @param searchString
	 * @param locations
	 * @param companies
	 * @param salary
	 * @return Jobs that match the filter criteria
	 */
	@RequestMapping(value = "/searchjobs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> searchJobs(@RequestParam("searchString") Optional<String> searchString, @RequestParam("locations") Optional<String> locations,
			@RequestParam("companies") Optional<String> companies, @RequestParam("salary") Optional<String> salary) {
		JobPostingsView jpv = new JobPostingsView();
		String search = searchString.get();
		List<?> jobIds = jobSeekerDao.searchJobs(search);
		System.out.println("*******************************jobId: "+ jobIds);

		System.out.println("************************" + locations + " " + locations.equals(Optional.empty()));
		if (!locations.equals(Optional.empty())) {
			jpv.setLocation(locations.get());
		}
		if (!companies.equals(Optional.empty())) {
			jpv.setCompanyName(companies.get());
		}
		if (!salary.equals(Optional.empty())) {
			jpv.setSalary(salary.get());
		}
		List<?> jp = jobSeekerDao.filterJobs(jpv, jobIds);
		return ResponseEntity.ok(jp);
	}

	@Autowired
	CompanyDao companyDao;

	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param type
	 * @return
	 * @throws IOException
	 * @throws SQLException
	 */
	@RequestMapping(value = "/createuser", method = RequestMethod.POST)
	public String createJobSeeker(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("type") String type, Model model)
			throws IOException, SQLException {

		int randomPIN = (int) (Math.random() * 9000) + 1000;
		String[] splited = name.split("\\s+");

		try {

			if (type.equals("seeker")) {

				JobSeeker j = new JobSeeker();
				j.setFirstName(splited[0]);
				j.setLastName(splited[1]);
				j.setPassword(password);
				j.setEmailId(email);
				j.setVerificationCode(randomPIN);
				j.setVerified(false);

				JobSeeker j1 = jobSeekerDao.createJobSeeker(j);

				String verificationUrl = "http://localhost:8080/register/verify?userId=" + j1.getJobseekerId() + "&pin="
						+ randomPIN + "&type=seeker";

				emailService.sendSimpleMessage(email, "Verification Pin", verificationUrl);
				model.addAttribute("name",j1.getFirstName());
				return "codesent";

			}

			else {

				Company c = new Company();
				c.setVerified(false);
				c.setVerificationCode(randomPIN);
				c.setCompanyName(name);
				c.setCompanyUser(email);
				c.setPassword(password);
				c.setHeadquarters("head");

				Company c1 = companyDao.createCompany(c);

				String verificationUrl = "http://localhost:8080/register/verify?userId=" + c1.getCompanyId() + "&pin="
						+ randomPIN + "&type=recruiter";

				emailService.sendSimpleMessage(email, "Verification Pin", verificationUrl);
			    model.addAttribute("name",c1.getCompanyName());

				// Company c1 =companyDao.
				return "codesent";
			}


		} catch (SQLException se) {
			HttpHeaders httpHeaders = new HttpHeaders();
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "Email Already Exists");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return "error";
			
			
			
		}
		catch(Exception se){
			HttpHeaders httpHeaders= new HttpHeaders();

			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "Error Occured");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();

			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return "error";
		}	
}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateSeekerPage(@RequestParam("id") String id, Model model){
		
		JobSeeker j1 = new JobSeekerDaoImpl().getJobSeeker(Integer.parseInt(id));
		model.addAttribute("j", j1);
		return "updateSeeker";
	}
	
	
	/**
	 * @param id
	 * @param firstname
	 * @param lastname
	 * @param emailid
	 * @param highesteducation
	 * @param password
	 * @param skills
	 * @param workex
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateJobSeeker(@RequestParam("id") String id,
			@RequestParam("firstname") Optional<String> firstname, @RequestParam("lastname") Optional<String> lastname,
			@RequestParam("emailid") Optional<String> emailid,
			@RequestParam("highesteducation") Optional<String> highesteducation,
			@RequestParam("password") Optional<String> password, @RequestParam("skills") Optional<String> skills,
			@RequestParam("workex") Optional<String> workex, Model model) throws Exception {
		JobSeeker js = new JobSeeker();

		js.setJobseekerId(Integer.parseInt(id));

		if (!emailid.equals(Optional.empty())) {
			System.out.println("emailid done : " + emailid.get() + ":::: " + emailid);
			js.setEmailId(emailid.get());
		}
		if (!firstname.equals(Optional.empty())) {
			System.out.println("fname done");
			js.setFirstName(firstname.get());
		}
		if (!lastname.equals(Optional.empty())) {
			System.out.println("lname done");
			js.setLastName(lastname.get());
		}
		if (!highesteducation.equals(Optional.empty())) {
			System.out.println("highest edu");
			js.setHighestEducation(Integer.parseInt(highesteducation.get()));
		}
		if (!password.equals(Optional.empty())) {
			System.out.println("password");
			js.setPassword(password.get());
		}
		if (!skills.equals(Optional.empty())) {
			System.out.println("skills : " + skills);
			js.setSkills(skills.get());
			System.out.println("huhuhuh : " + skills.get());
		}

		if (!workex.equals(Optional.empty())) {
			System.out.println("workex : " + workex);
			js.setWorkEx(Integer.parseInt(workex.get()));
		}

		JobSeeker jobseeker = jobSeekerDao.getJobSeeker(Integer.parseInt(id));
		JobSeeker jobskr = null;
		if (jobseeker != null) {
			jobskr  = jobSeekerDao.updateJobSeeker(js);
			System.out.println("updated");
		} else {
			jobskr  = jobSeekerDao.createJobSeeker(js);
		}
		System.out.println("done");
		
		model.addAttribute("seeker", js);
		return "userprofile";

	}

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
				return "companyprofile";
			} else {
				return "error";
			}

		}

		

	}
	
	@RequestMapping(value="/update/company",method = RequestMethod.PUT)
    public ResponseEntity<?> companyupdate(@RequestParam("id") String id,@RequestParam("companyName") Optional<String> name,
@RequestParam("headquarters") Optional<String> headquarters,
@RequestParam("companyUser") Optional<String>
user,@RequestParam("description") Optional<String> description)
    {

        Company  c = new Company();

        c.setCompanyId(Integer.parseInt(id));

        if(!name .equals( Optional.empty()))
        {

            c.setCompanyName(name.get());
        }
        if(!headquarters.equals( Optional.empty()))
        {
            c.setHeadquarters(headquarters.get());
        }
        if(!description.equals( Optional.empty()))
        {
            c.setDescription(description.get());
        }



        Company company = companyDao.getCompany(Integer.parseInt(id));
        Company c1 = null;
        if(company != null)
        {
            c1 = companyDao.updateCompany(c);

        }
        System.out.println("done");
        return ResponseEntity.ok(c1);

    }
}