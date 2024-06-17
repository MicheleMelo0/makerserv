package com.platform.makerserv.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.makerserv.dto.RegisterDTO;

/*
 * Sing up controller
 */

@RestController
@RequestMapping( "/register" )

public class RegisterController {
	
	@PostMapping	
	void registerUser( @RequestBody RegisterDTO data ) {
		
		System.out.println( data.name() );
		
	}

}
