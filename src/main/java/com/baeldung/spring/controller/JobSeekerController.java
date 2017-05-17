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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baeldung.spring.dao.CompanyDao;
import com.baeldung.spring.dao.JobSeekerDao;
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
@RequestMapping(value="/register")
public class JobSeekerController {

    @RequestMapping(value="/jobboard", method = RequestMethod.GET)
    public String showHomePage() {
        return "index";
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
	@SuppressWarnings("finally")
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> createJobSeeker(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("type") String type) throws IOException, SQLException {

		    int randomPIN = (int)(Math.random()*9000)+1000;
		    String[] splited = name.split("\\s+");
		    
		 try{  
		    
		    if(type.equals("seeker")){
		    	
		    	JobSeeker j = new JobSeeker();
			    j.setFirstName(splited[0]);
			    j.setLastName(splited[1]);
			    j.setPassword(password);
			    j.setEmailId(email);
			    j.setVerificationCode(randomPIN);
			    j.setVerified(false);
			    
			    JobSeeker j1 =jobSeekerDao.createJobSeeker(j);
			    
			    emailService.sendSimpleMessage(email, "Verification Pin", Integer.toString(randomPIN));
			    
			    
				return ResponseEntity.ok(j1);
		    	
		    }
		    
		    else{
		    	
		    	Company c = new Company();
		    	c.setVerified(false);
		    	c.setVerificationCode(randomPIN);
		    	c.setCompanyName(name);
		    	c.setCompanyUser(email);
		    	c.setPassword(password);
		    	c.setHeadquarters("head");
		    	
		    	Company c1 = companyDao.createCompany(c);
		    	
			    emailService.sendSimpleMessage(email, "Verification Pin", Integer.toString(randomPIN));
		    	
		    	//Company c1 =companyDao.
				return ResponseEntity.ok(c1);
		    }
		    

			
		}
		catch(SQLException se){
			HttpHeaders httpHeaders= new HttpHeaders();
			Map<String, Object> message = new HashMap<String, Object>();
			Map<String, Object> response = new HashMap<String, Object>();
			message.put("code", "400");
			message.put("msg", "Email Already Exists");
			response.put("BadRequest", message);
			JSONObject json_test = new JSONObject(response);
			String json_resp = json_test.toString();
			
			httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
			
			
			
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
			return new ResponseEntity <String>(json_resp, httpHeaders, HttpStatus.NOT_FOUND);
		}	
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
	 */
	@RequestMapping(value="/update",method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> updateJobSeeker(@RequestParam("id") String id, @RequestParam("firstname") Optional<String> firstname, @RequestParam("lastname") Optional<String> lastname,
			@RequestParam("emailid") Optional<String> emailid, @RequestParam("highesteducation") Optional<Integer> highesteducation,
			@RequestParam("password") Optional<String> password, @RequestParam("skills") Optional<String> skills, @RequestParam("workex") Optional<Integer> workex) 
	{
		JobSeeker js = new JobSeeker();
		
		js.setJobseekerId(Integer.parseInt(id));
		
		if(!emailid .equals( Optional.empty()))
		{
			System.out.println("emailid done : "+emailid.get() + ":::: " + emailid);
			js.setEmailId(emailid.get());
		}
		if(!firstname.equals( Optional.empty()))
		{
			System.out.println("fname done");
			js.setFirstName(firstname.get());
		}
		if(!lastname.equals( Optional.empty()))
		{
			System.out.println("lname done");
			js.setLastName(lastname.get());
		}
		if(!highesteducation.equals( Optional.empty()))
		{
			System.out.println("highest edu");
			js.setHighestEducation(highesteducation.get());
		}
		if(!password .equals( Optional.empty()))
		{
			System.out.println("password");
			js.setPassword(password.get());
		}
		if(!skills .equals( Optional.empty()))
		{
			System.out.println("skills : "+skills);
			js.setSkills(skills.get());
			System.out.println("huhuhuh : "+skills.get());
		}
		
		if(!workex .equals( Optional.empty()))
		{
			System.out.println("workex : "+workex);
			js.setWorkEx(workex.get());
		}
		
		
		JobSeeker jobseeker = jobSeekerDao.getJobSeeker(Integer.parseInt(id));
		JobSeeker jobskr = null;
		if(jobseeker != null)
		{
			jobskr = jobSeekerDao.updateJobSeeker(js);
			System.out.println("updated");
		}
		System.out.println("done");
		return ResponseEntity.ok(jobskr);
		
	}
	
	
	

	/**
	 * @param emailId
	 * @param password
	 * @param type
	 * @return
	 */
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String Login(@RequestParam("emailId") String emailId, @RequestParam("password") String password,@RequestParam("type") String type)
	{
		List<String> list = new ArrayList<String>();
		String email = emailId;
		String pwd = password;
		System.out.println(email+" : " + pwd);
		
		if(type.equals("recruiter"))
		{
			list = companyDao.PasswordLookUp(email);
		}
		else if (type.equals("seeker"))
		{
			list = jobSeekerDao.PasswordLookUp(email);
		}
		
		System.out.println(list);
		if(list.size()==0)
		{
			return "UserName Invalid";
		}
		else
		{
			if(pwd.equals(list.get(0)))
			{
				return "Login Successful";
			}
			
		}
		return "Invalid Password";
			
		
	}
}