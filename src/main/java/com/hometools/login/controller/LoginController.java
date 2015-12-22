/**
 * 
 */
package com.hometools.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hometools.forms.LandingPageForm;

/**
 * Controller for the Login module.
 * All the activities urls for user sign up and sign in
 * application will be under this controller
 * Initial Landing Page url is also present here.
 * 
 * 
 * @author adityacherla
 *
 */

@Controller
public class LoginController {
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showLandingPage(@ModelAttribute("landingPageForm")LandingPageForm form){
		return "LandingPage";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String registerUser(@ModelAttribute("landingPageForm")LandingPageForm form) {
		
		return "LandingPage";
	}
	
	
	
	

}
