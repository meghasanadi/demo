/*package com.samcomm.controller;


import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.sam.springmvc.model.Application;
import com.sam.springmvc.service.ApplicationService;

@Controller
@RequestMapping("/")
@SessionAttributes("roles")

public class ApplicationController {
	
	@Autowired
	AuthenticationTrustResolver authenticationTrustResolver;
	
	@Autowired
	private ApplicationService appService;
	
	@RequestMapping(value =  "/welcome**", method = RequestMethod.GET)
	public ModelAndView welcome(ModelMap model1) {

		ModelAndView model = new ModelAndView();
		Application app=new Application();
		model.addObject("app", app);
		model.addObject("jobid", id);
		
		 List<String> genders = new ArrayList<String>();
         genders.add("Male");
         genders.add("Female");
         model1.addAttribute("genders", genders);
         
         List<String> noticeperiod = new ArrayList<String>();
         noticeperiod.add("0-15days");
         noticeperiod.add("15-30days");
         noticeperiod.add("1-2months");
         noticeperiod.add("2-3months");
         model1.addAttribute("noticeperiod", noticeperiod);
                
		model1.addAttribute("loggedinuser", getPrincipal());
		model.setViewName("userloginSuccessfull");
		return model;

	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(ModelAndView modelView,@ModelAttribute Application app) {
		if (app.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			appService.addApplication(app);
			
			
		} 
		else {
		}
		return new ModelAndView("applysuccessfull");
	}
	
	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
	
	 @SuppressWarnings("unused")
	private void initModelList(Model model) {
		 List<String> genders = new ArrayList<String>();
		         genders.add("Male");
		         genders.add("Female");
		         model.addAttribute("genders", genders);
	 }
	 
	 @RequestMapping(value = "/add-document-{id}", method = RequestMethod.GET)
		public ModelAndView listJob2(ModelAndView model) throws IOException {
			List<Job> listJob2 = jobService.listActiveJobs();
			model.addObject("listJob2", listJob2);
			model.setViewName("home2");
			return model;
		}
	
}
*/