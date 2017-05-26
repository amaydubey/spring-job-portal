/**
 * 
 */
package com.baeldung.spring.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.baeldung.spring.dao.InterestedDao;
import com.baeldung.spring.dao.JobApplicationDao;
import com.baeldung.spring.dao.JobPostingDao;
import com.baeldung.spring.dao.JobSeekerDao;
import com.baeldung.spring.entity.Company;
import com.baeldung.spring.entity.JobApplication;
import com.baeldung.spring.entity.JobPosting;
import com.baeldung.spring.entity.JobSeeker;
import com.baeldung.spring.mail.EmailServiceImpl;

/**
 * @author amayd
 *
 */

@Controller
@RequestMapping(value = "/application")
public class JobApplicationController {

	@Autowired
	JobSeekerDao jobSeekerDao;

	@Autowired
	EmailServiceImpl emailService;

	@Autowired
	JobPostingDao jobDao;

	@Autowired
	JobApplicationDao jobAppDao;
	
	@Autowired
	InterestedDao interestedDao;
	
	private static String UPLOADED_FOLDER = "C:/";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String applyPage(@RequestParam("userId") String jobSeekerId, @RequestParam("jobId") String jobId, Model model){
		
		return "jobapplication";
	}
	
	
	/**
	 * @param jobSeekerId
	 * @param jobId
	 * @param resumeFlag
	 * @param resumePath
	 * @return The newly created application
	 */
	@RequestMapping(value = "/apply", method = RequestMethod.POST)
	public String apply(@RequestParam("userId") String jobSeekerId, @RequestParam("jobId") String jobId,
			@RequestParam("resumeFlag") boolean resumeFlag, @RequestParam("resumePath") String resumePath,@RequestParam("file") Optional <MultipartFile> file, RedirectAttributes redirectAttributes, Model model) {
		if(resumeFlag == true){
			
			
		System.out.println("In Job Contraoller");
		if (file.equals(Optional.empty())) {
            System.out.println("Inside Empty");
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
        	System.out.println("Inside Upload");
            byte[] bytes = file.get().getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.get().getOriginalFilename());
            JobApplication ja = new JobApplication();
			ja = jobAppDao.apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, path.toString());//apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, path);
			JobSeeker js = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId));
			JobPosting jp = jobDao.getJobPosting(Integer.parseInt(jobId));
			emailService.sendSimpleMessage(js.getEmailId(),
					"You have successfully applied to the position " + jp.getTitle() + " at "
							+ jp.getCompany().getCompanyName(),
					"Hi " + js.getFirstName() + " " + js.getLastName()
							+ ".\n You have successfully completed your application for " + jp.getTitle() + " at "
							+ jp.getCompany().getCompanyName() + ".\n Regards,\nThe FindJobs Team");
			
			Company company = jp.getCompany();
			List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(jobSeekerId));
			int i = 0;
			int j=0;
			if(ij.contains(Integer.parseInt(jobId))){
				i = 1;
			}
			
			List<Integer> il = getAppliedJobs(jobSeekerId);
			if(il.contains(Integer.parseInt(jobId))){
				j = 1;
			}
			
			model.addAttribute("job", jp);
			model.addAttribute("seeker", js);
			model.addAttribute("company", company);
			model.addAttribute("interested", i);
			model.addAttribute("applied", j);
		    System.out.println(path);
	        Files.write(path, bytes);
	        System.out.println(path);
			return "userjobprofile"; 
            
            
       

          ///  redirectAttributes.addFlashAttribute("message",
             //       "You successfully uploaded '" + file.get().getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/userjobprofile";
			
			
		}
		else{
			JobApplication ja = new JobApplication();
			ja = jobAppDao.apply(Integer.parseInt(jobSeekerId), Integer.parseInt(jobId), resumeFlag, resumePath);
			JobSeeker js = jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId));
			JobPosting jp = jobDao.getJobPosting(Integer.parseInt(jobId));
			emailService.sendSimpleMessage(js.getEmailId(),
					"You have successfully applied to the position " + jp.getTitle() + " at "
							+ jp.getCompany().getCompanyName(),
					"Hi " + js.getFirstName() + " " + js.getLastName()
							+ ".\n You have successfully completed your application for " + jp.getTitle() + " at "
							+ jp.getCompany().getCompanyName() + ".\n Regards,\nThe FindJobs Team");
			Company company = jp.getCompany();
			List<?> ij = interestedDao.getAllInterestedJobId(Integer.parseInt(jobSeekerId));
			int i = 0, j=0;
			if(ij.contains(Integer.parseInt(jobId))){
				i = 1;
			}
			
			List<Integer> il = getAppliedJobs(jobSeekerId);
			if(il.contains(Integer.parseInt(jobId))){
				j = 1;
			}
			
			model.addAttribute("job", jp);
			model.addAttribute("seeker", js);
			model.addAttribute("company", company);
			model.addAttribute("interested", i);
			model.addAttribute("applied", j);
			
			return "userjobprofile";
			
		}
		
	}

	/**
	 * @param jobAppId
	 * @return True if the job application was cancelled
	 */
	@RequestMapping(value = "/cancel", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String cancelApplication(@RequestParam("jobApplicationId") String jobAppId) {
		boolean deleted = jobAppDao.cancel(Integer.parseInt(jobAppId));
		if (deleted)
			return "Cancelled";
		return "Unable to delete";
	}

	/**
	 * @param jobAppId
	 * @param state
	 * @return true if the state has been modified
	 */
	@RequestMapping(value = "/modifyapplicationstate", method = RequestMethod.POST)
	public String modifyApplicationState(@RequestParam("jobAppId") String jobAppId,
			@RequestParam("state") String state) {
		JobApplication ja = jobAppDao.modifyJobApplicationStatus(Integer.parseInt(jobAppId), Integer.parseInt(state));
		if (ja == null) {
			return "Error";
		}
		return "modified";
	}
	
	//***************************************************
	@RequestMapping("/viewResume")
    public void downloadPDFResource( HttpServletRequest request, HttpServletResponse response, @RequestParam("Id") int id ) throws IOException
    	{		
			JobApplication j1 =jobAppDao.getJobApplication(id);
			String path= j1.getResumePath();
		
			File file = new File(path);
			System.out.println(file);
				
			if (file.exists()) 
			{
			System.out.println("File Found");	
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() +"\""));
			InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			 
	        //Copy bytes from source to destination(outputstream in this example), closes both streams.
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
			
			}

    	
    	
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,RedirectAttributes redirectAttributes) {
    	
    	if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            System.out.println(path);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "uploadStatus";
    }
	
    @SuppressWarnings("rawtypes")
	public List<Integer> getAppliedJobs(@RequestParam("jobSeekerId") String jobSeekerId){
		List<?> jobSeekerAppliedList =jobSeekerDao.getJobSeeker(Integer.parseInt(jobSeekerId)).getJobApplicationList();
		List<Integer> jobIdList = new ArrayList<Integer>();
		for (Iterator iterator = jobSeekerAppliedList.iterator(); iterator.hasNext();) {
			JobApplication ja = (JobApplication) iterator.next();
			int jobId = ja.getJobPosting().getJobId();
			jobIdList.add(jobId);
		}
		return jobIdList;
	}

    
}
