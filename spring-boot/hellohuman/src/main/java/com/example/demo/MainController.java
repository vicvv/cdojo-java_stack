package com.example.demo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class MainController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="fname", defaultValue="Human") String fname, 
			@RequestParam(value="lname", defaultValue="lastname") String lastname) {
		
		String s = fname;
		if(!lastname.equals("lastname")) {
			s.concat("lastname" + " "+ lastname);
		}
		
		return s;
	}

}
