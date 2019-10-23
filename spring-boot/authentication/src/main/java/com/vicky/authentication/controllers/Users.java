package com.vicky.authentication.controllers;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicky.authentication.models.User;
import com.vicky.authentication.services.UserService;
import com.vicky.authentication.validator.UserValidator;

import java.security.Principal;



@Controller
public class Users {
	private final UserService userService;
	private final UserValidator userValidator;
 
 public Users(UserService userService,UserValidator userValidator) {
     this.userService = userService;
     this.userValidator = userValidator;
 }
 
 @RequestMapping("/registration")
 public String registerForm(@ModelAttribute("user") User user) {
     return "registrationPage.jsp";
 }


 @RequestMapping(value="/registration", method=RequestMethod.POST)
 public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 userValidator.validate(user, result);
	 // if result has errors, return the registration page (don't worry about validations just now)
     // else, save the user in the database, save the user id in session, and redirect them to the /home route	 
	 if (result.hasErrors()) {
		 return "registrationPage.jsp";
	 }
	 User u = userService.registerUser(user);
	 session.setAttribute("userId", u.getId());
	 return "redirect:/home";
	
 }
 
 @RequestMapping("/login")
 public String login() {
     return "loginPage.jsp";
 }
 
 @RequestMapping(value="/login", method=RequestMethod.POST)
 public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
	
	boolean isAuthenticated = userService.authenticateUser(email, password);
	if (isAuthenticated) {
		User u = userService.findByEmail(email);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
	} else {
		model.addAttribute("error", "Invalid Credentials, try again");
		return "loginPage.jsp";
	}	
     
 }
 
 @RequestMapping("/home")
 public String home(HttpSession session, Model model) {
	// get user from session, save them in the model and return the home page
	 Long userId = (Long) session.getAttribute("userId");
	 User u = userService.findUserById(userId);
	 return "homePage.jsp";
	 		
     }
 @RequestMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/login";
 }
}