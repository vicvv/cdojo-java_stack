package com.example.demo;

import java.util.Date;
import java.text.SimpleDateFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")

public class MainController {
	@RequestMapping("")
	public String index() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String displaydate(Model model) {
		model.addAttribute("now", new Date());
		return "displaydate.jsp";
	}
	@RequestMapping("/time")
	public String displaytime(Model model) {
		model.addAttribute("now", new Date());
		return "displaytime.jsp";
	}

}
