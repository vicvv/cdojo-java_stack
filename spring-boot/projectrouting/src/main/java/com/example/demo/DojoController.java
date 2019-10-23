package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{location}")
	
	public String showLesson(@PathVariable("location") String location ){
		
		if (location.equals("dojo") ) {return location + " is cool";}		
		else if (location == "san jose") {return location + " is hq";}		
		else return location;
	
	}
}
