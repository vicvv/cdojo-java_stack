package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller

public class HomeController {
//	@RequestMapping("/")
//	   @ResponseBody
//	   public String hello() {
//	      return "Hello Spring Boot";
//	   }
	@RequestMapping("/")
    public String index(Model model) {
		model.addAttribute("dojoName", "Burbank");
        return "index.jsp";
    }
        
}