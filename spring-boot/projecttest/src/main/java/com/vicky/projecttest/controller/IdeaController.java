package com.vicky.projecttest.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.vicky.projecttest.model.Idea;
import com.vicky.projecttest.model.User;
import com.vicky.projecttest.service.IdeaService;
import com.vicky.projecttest.service.UserService;



@Controller
@RequestMapping("/ideas")

public class IdeaController {
	
	private final IdeaService ideaService;
	private final UserService userService;
	
	
	public IdeaController(IdeaService ideaService,UserService userService) {
		this.ideaService = ideaService;
		this.userService = userService;
		
	}
	
	@GetMapping("/")
	public String dashboard(@Valid @ModelAttribute("ideaObj") Idea idea, 
			BindingResult result, 
			HttpSession session, Model model) 
	{
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		//System.out.println("userid " + session.getAttribute("userId"));
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		//System.out.println("User: " + user );
		model.addAttribute("user", user);
		
        List<Idea> ideas = ideaService.allIdeas();
                
        model.addAttribute("ideas", ideas);
        //model.addAttribute("newidea", new Idea());
		return "dashboard.jsp";
	}
	
	// view idea
		@RequestMapping("/{id}")
		public String viewIdea(@PathVariable("id") Long id,  Model model, HttpSession session) {
			System.out.println("I am in edit method");
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Idea idea = ideaService.findIdeaById(id);
			
			model.addAttribute("idea", idea);
			model.addAttribute("user", user);
			model.addAttribute("attendees", idea.getJoinedUsers());

			System.out.println("**************");
			
			return "details.jsp";
		}
		
		
		
	// redirect to edit idea page
		
		@GetMapping("/{id}/edit")
		public String editPage(@PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, Model model, HttpSession session) {
			if(session.getAttribute("userId") == null) {
				return "redirect:/";
			}
			User user = userService.findUserById((Long)session.getAttribute("userId"));
			if(ideaService.findIdeaById(id).getUser().getId() == user.getId()) {
				model.addAttribute("idea", ideaService.findIdeaById(id));
				return "edit.jsp";
			}
			else {
				return "redirect:/";
			}
		}
		
		
		//CRUD
			// create new idea 
		
		@GetMapping("/new")
		public String newIdea(Model model,HttpSession session) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("newidea", new Idea());
			model.addAttribute("user", user);
			return "new.jsp";
		}
		
			@PostMapping("/new/addidea")
			public String createIdea(@Valid @ModelAttribute("newidea") Idea newidea, BindingResult result, HttpSession session, Model model) {
				User user = userService.findUserById((Long) session.getAttribute("userId"));
				model.addAttribute("user", user);
				System.out.println(" I am in new idea newidea ");
				if(result.hasErrors()) {
					return "dashboard.jsp";
				}
				else {
					System.out.println("newidea: " + newidea);
					ideaService.addIdea(newidea);
					return "redirect:/ideas/";
					
				}	
			}
					
			// edit idea
			@PutMapping("/{id}/edit")
			public String editIdea(@Valid @PathVariable("id") Long id, @ModelAttribute("idea") Idea idea, BindingResult result, Model model, HttpSession session) {
				User user = userService.findUserById((Long)session.getAttribute("userId"));
				if(ideaService.findIdeaById(id).getUser().getId() == user.getId()) {
					if(result.hasErrors()) {
						model.addAttribute("idea", ideaService.findIdeaById(id));
						return "edit.jsp";
					}
					else {
						Idea ideaEdit = ideaService.findIdeaById(id);
						model.addAttribute("idea", ideaEdit);
						model.addAttribute("user", user);
						idea.setUser(user);
						idea.setJoinedUsers(idea.getJoinedUsers());
						ideaService.updateIdea(idea);
						return "redirect:/ideas/";
					}
				}
				else {
					return "redirect:/ideas/";
				}
			}
			
			// join idea
			@RequestMapping("/{id}/join")
			public String joinIdea(@PathVariable("id") Long id, HttpSession session) {
				User user = userService.findUserById((Long) session.getAttribute("userId"));
				Idea idea = ideaService.findIdeaById(id);
				List<User> attendees = idea.getJoinedUsers();
				attendees.add(user);
				idea.setJoinedUsers(attendees);
				userService.updateUser(user);	// try to update user				
				return "redirect:/ideas/";
			}
			
			
			
			// un-join idea
			
		    @RequestMapping("/{id}/cancel")
		    public String cancelIdea(@PathVariable("id") Long id, HttpSession session) {
		    	User user = userService.findUserById((Long) session.getAttribute("userId"));
				Idea idea = ideaService.findIdeaById(id);
		    	List<User> attendees = idea.getJoinedUsers();
		        for(int i=0; i<attendees.size(); i++) {
		            if(attendees.get(i).getId() == user.getId()) {
		            	attendees.remove(i);
		            }
		        }
		        idea.setJoinedUsers(attendees);
		        userService.updateUser(user);
		    	return "redirect:/ideas/";
		    }
		    
		    
		    // delete idea
		    @RequestMapping("/{id}/delete")
		    public String delete(@PathVariable("id") Long id,HttpSession session) {
		    	
		    
		    	Idea idea = ideaService.findIdeaById(id);
		    	if (idea.getUser().getId() == (Long)session.getAttribute("userId")) {
		    	for(User user: idea.getJoinedUsers()) {
		    		List<Idea> myideas = user.getLikedideas();
		    		myideas.remove(idea);
		    		user.setLikedideas(myideas);;
		    		userService.updateUser(user);
		    	}

		    	ideaService.deleteIdea(idea);
		    	return "redirect:/ideas/";
		    	}
		    	else { return "redirect:/ideas/";}
		    		
		    }
}

