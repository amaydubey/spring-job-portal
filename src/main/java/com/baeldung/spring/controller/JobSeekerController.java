/**
 * 
 */
package com.baeldung.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.spring.dao.JobSeekerDao;

/**
 * @author ashay
 *
 */
@Controller
@RequestMapping(value="/home")
public class JobSeekerController {

    @RequestMapping(value="/temp", method = RequestMethod.GET)
    public String showHomePage() {
    	System.out.println("ashay");
        return "home";
    }
}