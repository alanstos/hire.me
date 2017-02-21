package org.hire.me.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping({"/","/home"})
	public String showHomePage() {
		
		System.out.println("show /home");
		 
	    return "redirect:static"; 
	   
	}		

}
