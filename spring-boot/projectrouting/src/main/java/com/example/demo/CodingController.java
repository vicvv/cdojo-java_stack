package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coding")

public class CodingController {
	@RequestMapping("/")
	public String index() {
		return "from coding index!";
	}
	
	@RequestMapping("/java")
	public String lang1() {
		return "Hello from coding java!";
	}
	@RequestMapping("/python")
	public String lang2() {
		return "Hello from coding python!";
	}
}
