package com.vicky.projecttest.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.vicky.projecttest.model.User;
import com.vicky.projecttest.service.UserService;
import com.vicky.projecttest.validators.UserValidator;

//import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;



@Controller
public class UserController {
	private final UserService userService;
	private final UserValidator userValidator;
 
 public UserController(UserService userService,UserValidator userValidator) {
     this.userService = userService;
     this.userValidator = userValidator;
 }
 
 ArrayList<String> state = new ArrayList<String>(Arrays.asList("","AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
			"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
 
 @RequestMapping("/")
 
 public String index(@ModelAttribute("user") User user, Model model) {
	 model.addAttribute("state", state);
     return "index.jsp";
 }

 //register user and redirect to index to login
 
 @PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, Model model, HttpSession session) {
		userValidator.validate(user, result);
		if(result.hasErrors()) {
			model.addAttribute("state", state);
			return "index.jsp";
		}
//		boolean isDuplicate = userService.duplicateUser(user.getEmail());
//		if(isDuplicate) {
//			model.addAttribute("error", "this email was already used!");
//			return "index.jsp";
//		}
		User u = userService.registerUser(user);
		//System.out.println("My user" + u);
		session.setAttribute("userId", u.getId());
		return "redirect:/";
	}
	
	@PostMapping("login")
	public String signIn(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User user = userService.findByEmail(email);
			session.setAttribute("userId", user.getId());
			return "redirect:/dashboard";
		}
		else {
			model.addAttribute("error", "Invalid Credentials! Please try again with the correct user information!");
			return "index.jsp";	
		}
	}
	
	@RequestMapping("/dashboard")
	 public String home(HttpSession session, Model model) {
		// get user from session, save them in the model and return the home page
		 Long userId = (Long) session.getAttribute("userId");
		 User user = userService.findUserById(userId);
		 //System.out.println(user + " "+ String.format(" " , userId));
		 return "redirect:/ideas/";
		 		
	    }
	
	 @RequestMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
 
}
