package com.example.demo;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/")
public class MainController {
	
	@RequestMapping("")
	public String index(HttpSession session, @ModelAttribute("error") String error) {
		session.setAttribute("error", error);
		session.setAttribute("correct", "false");
		return "index.jsp";
	}
//	When form is submitted with guess: check if the guess was "bushido". if not add a flash attribute "error" 
//	and redirect back to index. If the guess was "bushido" remove the attribute "error" from session and set 
	//the session "correct" attribute to "true" and redirect to "/code"
	
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public String guess(HttpSession session, @RequestParam("guess") String guess, RedirectAttributes redirectAttributes) {
		if(guess.equals("bushido")) {
			session.removeAttribute("error");
			session.setAttribute("correct", "true");
			return "redirect:/code";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
//	when routed to "/code" check to see if the session attribute "correct" is "true". 
// If yes return the code page. If not flash an error and redirect back to index
	
	@RequestMapping("/code")
	public String correct(HttpSession session, RedirectAttributes redirectAttributes) {
		System.out.println(session.getAttribute("error"));
		if(session.getAttribute("correct") == "true") {
			return "correct.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "YOU CAN NOT ENTER WITHOUT THE CODE.");
			return "redirect:/";
		}
	}
	

}
