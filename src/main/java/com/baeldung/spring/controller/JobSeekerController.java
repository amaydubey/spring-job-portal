/**
 * 
 */
package com.baeldung.spring.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.dao.impl.JobSeekerDaoImpl;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.Interested;
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

	@Autowired
	JobSeekerDao jobSeekerDao;

	@Autowired
	EmailServiceImpl emailService;
	
	@Autowired
	InterestedDao interestedDao;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * @param searchString
	 * @param locations
	 * @param companies
	 * @param salary
	 * @return Jobs that match the filter criteria
	 */
	@RequestMapping(value = "/searchjobs", method = RequestMethod.GET)
	public String searchJobs(@RequestParam("userId") String userId,
			@RequestParam("searchString") Optional<String> searchString,
			@RequestParam("locations") Optional<String> locations,
			@RequestParam("companies") Optional<String> companies, 
			@RequestParam("min") Optional<String> min,
			@RequestParam("max") Optional<String> max, Model model) {
		JobPostingsView jpv = new JobPostingsView();
		String search = "";
		if (!searchString.equals(Optional.empty())) {
			search = searchString.get();
		}
		
		List<?> jobIds = jobSeekerDao.searchJobs(search);
		if ((!locations.equals(Optional.empty())) && (locations.get()!="")) {
			System.out.println("location");
			jpv.setLocation(locations.get());
		}
		if (!companies.equals(Optional.empty()) && companies.get()!="") {
			System.out.println("comp");
			jpv.setCompanyName(companies.get());
		}
		if (!min.equals(Optional.empty()) && !max.equals(Optional.empty())) {
		String salary = min.get()+","+max.get();
		jpv.setSalary(salary);
		}

		List<?> jp = jobSeekerDao.filterJobs(jpv, jobIds);

		JobSeeker jobseeker = jobSeekerDao.getJobSeeker(Integer.parseInt(userId));
		
		model.addAttribute("jobs", jp);
		model.addAttribute("seeker", jobseeker);
		
		return "jobsearch";
	}

	@Autowired
	CompanyDao companyDao;
	
	@Autowired
	JobPostingDao jobDao;
	
	@RequestMapping(value = "/showjob", method = RequestMethod.GET)
	public String showJob(@RequestParam("userId") String userId, @RequestParam("jobId") String jobId, Model model) {
		
		JobPosting job = jobDao.getJobPosting(Integer.parseInt(jobId));
		Company company = job.getCompany();
		JobSeeker seeker = jobSeekerDao.getJobSeeker(Integer.parseInt(userId));
		List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(userId));
		int i = 0;
		if(ij.contains(Integer.parseInt(jobId))){
			i = 1;
		}
		
		model.addAttribute("job", job);
		model.addAttribute("seeker", seeker);
		model.addAttribute("company", company);
		model.addAttribute("interested", i);
		
		return "userjobprofile";
	}



	/**
	 * @param name
	 * @param email
	 * @param password
	 * @param type
	 * @param model
	 * @return newly created job seeker
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
				model.addAttribute("name", j1.getFirstName());
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
				model.addAttribute("name", c1.getCompanyName());

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

		} catch (Exception se) {
			HttpHeaders httpHeaders = new HttpHeaders();

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

	/**
	 * @param id
	 * @param model
	 * @return updated seeker view
	 */
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String updateSeekerPage(@RequestParam("id") String id, Model model) {

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
	 * @param model
	 * @return updated userprofile view
	 * @throws Exception
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateJobSeeker(@RequestParam("id") String id, @RequestParam("firstname") Optional<String> firstname,
			@RequestParam("lastname") Optional<String> lastname, @RequestParam("emailid") Optional<String> emailid,
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
			jobskr = jobSeekerDao.updateJobSeeker(js);
			System.out.println("updated");
		} else {
			jobskr = jobSeekerDao.createJobSeeker(js);
		}
		System.out.println("done");

		model.addAttribute("seeker", js);
		return "userprofile";

	}

	/**
	 * @param emailId
	 * @param password
	 * @param type
	 * @param model
	 * @return Login
	 */
	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * String login(@RequestParam("emailId") String
	 * emailId, @RequestParam("password") String password,
	 * 
	 * @RequestParam("type") String type, Model model) { List<String> list = new
	 * ArrayList<String>(); String email = emailId; String pwd = password;
	 * System.out.println(email + " : " + pwd);
	 * 
	 * if (type.equals("recruiter")) { list = companyDao.PasswordLookUp(email);
	 * } else if (type.equals("seeker")) { list =
	 * jobSeekerDao.PasswordLookUp(email); }
	 * 
	 * System.out.println(list); if (list.size() == 0) { return
	 * "UserName Invalid"; } else { if (pwd.equals(list.get(0))) { return
	 * "Login Successful"; }
	 * 
	 * } return "Invalid Password";
	 * 
	 * }
	 */

	/**
	 * @param type
	 * @param pin
	 * @param userId
	 * @param model
	 * @return verified
	 */
	/*
	 * @RequestMapping(value = "/register/verify", method = RequestMethod.GET)
	 * public String verification(@RequestParam("type") String
	 * type, @RequestParam("pin") int pin,
	 * 
	 * @RequestParam("userId") int userId, Model model) {
	 * 
	 * if (type.equals("seeker")) {
	 * 
	 * JobSeeker j = jobSeekerDao.getJobSeeker(userId); if
	 * (j.getVerificationCode() == pin) { j.setVerified(true);
	 * jobSeekerDao.verify(j); model.addAttribute("seeker", j); return
	 * "userregister"; } else { return "error";
	 * 
	 * }
	 * 
	 * } else {
	 * 
	 * Company j = companyDao.getCompany(userId); if (j.getVerificationCode() ==
	 * pin) { j.setVerified(true); companyDao.verify(j);
	 * model.addAttribute("company", j); return "companyprofile"; } else {
	 * return "error"; }
	 * 
	 * }
	 * 
	 * }
	 */
	/**
	 * @param id
	 * @param name
	 * @param headquarters
	 * @param user
	 * @param description
	 * @param model
	 * @return updated company
	 */
	@RequestMapping(value = "/update/company", method = RequestMethod.POST)
	public String companyupdate(@RequestParam("id") String id, @RequestParam("companyName") Optional<String> name,
			@RequestParam("headquarters") Optional<String> headquarters,
			@RequestParam("companyUser") Optional<String> user,
			@RequestParam("description") Optional<String> description, Model model) {

		Company c = new Company();

		c.setCompanyId(Integer.parseInt(id));

		if (!name.equals(Optional.empty())) {

			c.setCompanyName(name.get());
		}
		if (!user.equals(Optional.empty())) {

			c.setCompanyUser(user.get());
		}
		if (!headquarters.equals(Optional.empty())) {
			c.setHeadquarters(headquarters.get());
		}
		if (!description.equals(Optional.empty())) {
			c.setDescription(description.get());
		}

		Company company = companyDao.getCompany(Integer.parseInt(id));
		Company c1 = null;
		if (company != null) {
			c1 = companyDao.updateCompany(c);

		} else {
			return "error";
		}
		System.out.println("done");
		model.addAttribute("company", c1);
		return "companyprofile";

	}

	@RequestMapping(value = "/interested", method = RequestMethod.POST)
	public String createInterest(@RequestParam("userId") String userId, @RequestParam("jobId") String jobId, Model model) {

		try {
			Interested in = new Interested();
			in.setJobId(Integer.parseInt(jobId));
			in.setJobSeekerId(Integer.parseInt(userId));
			Interested i1 = interestedDao.createInterest(in);
			
		} catch (Exception e) {

			HttpHeaders httpHeaders = new HttpHeaders();

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
		JobPosting job = jobDao.getJobPosting(Integer.parseInt(jobId));
		Company company = job.getCompany();
		JobSeeker seeker = jobSeekerDao.getJobSeeker(Integer.parseInt(userId));
		List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(userId));
		int i = 0;
		if(ij.contains(Integer.parseInt(jobId))){
			i = 1;
		}
		String message="<div class=\"alert alert-success\">This job has been <strong>Successfully added</strong> to your interests</div>";
		
		
		model.addAttribute("job", job);
		model.addAttribute("seeker", seeker);
		model.addAttribute("company", company);
		model.addAttribute("interested", i);
		model.addAttribute("message", message);
		
		return "userjobprofile";
	}

	/**
	 * @param userId
	 * @param jobId
	 * @return "deleted" if the interest is deleted
	 */
	@RequestMapping(value = "/interested/delete", method = RequestMethod.POST)
	public String deleteInterest(@RequestParam("userId") String userId, @RequestParam("jobId") String jobId, Model model) {

		try {
			List<?> querylist = interestedDao.getInterestedJobId(Integer.parseInt(jobId), Integer.parseInt(userId));
			boolean interestDeleted = interestedDao.deleteInterest(Integer.parseInt(querylist.get(0).toString()));
			if (interestDeleted) {
				JobPosting job = jobDao.getJobPosting(Integer.parseInt(jobId));
				Company company = job.getCompany();
				JobSeeker seeker = jobSeekerDao.getJobSeeker(Integer.parseInt(userId));
				List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(userId));
				int i = 0;
				if(ij.contains(Integer.parseInt(jobId))){
					i = 1;
				}

				String message="<div class=\"alert alert-danger\">This job has been <strong>Successfully removed</strong> from your interests</div>";
				
				model.addAttribute("job", job);
				model.addAttribute("seeker", seeker);
				model.addAttribute("company", company);
				model.addAttribute("interested", i);
				model.addAttribute("message", message);
				
				return "userjobprofile";

			} else {
				return "error";
			}

		} catch (Exception e) {

			HttpHeaders httpHeaders = new HttpHeaders();

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

	/**
	 * @param jobSeekerId
	 * @return List of the jobs the job seeker is interested in
	 */
	@RequestMapping(value = "/getinterestedjobs", method = RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getInterestedJobsForJobSeeker(@RequestParam("jobSeekerId") String jobSeekerId) {
		List<?> jobSeekerInterestsList = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId)).getInterestedjobs();
		return ResponseEntity.ok(jobSeekerInterestsList);
	}
	
	/**
	 * @param jobSeekerId
	 * @return Job applications list for the job seeker
	 */
	@RequestMapping(value="/getappliedjobs", method = RequestMethod.GET)
	public ResponseEntity<?> getAppliedJobs(@RequestParam("jobSeekerId") String jobSeekerId){
		List<?> jobSeekerAppliedList = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId)).getJobApplicationList();
		return ResponseEntity.ok(jobSeekerAppliedList);
	}

}