package com.platform.makerserv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * Controller to login into the system
 */

@Controller

public class LoginController {
	
	@GetMapping( "/login" )
	public ModelAndView login() {
		
		ModelAndView view = new ModelAndView();
		view.setViewName( "login.html" );
		
		return view;
		
	}

}
