package com.vicky.eventsbeltreviewer.controllers;

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

import com.vicky.eventsbeltreviewer.models.Event;
import com.vicky.eventsbeltreviewer.models.Message;
import com.vicky.eventsbeltreviewer.models.User;
import com.vicky.eventsbeltreviewer.services.EventService;
import com.vicky.eventsbeltreviewer.services.MessageService;
import com.vicky.eventsbeltreviewer.services.UserService;


@Controller
@RequestMapping("/events")
public class EventController {
	
	private final EventService eventService;
	private final UserService userService;
	private final MessageService messageService;
	
	public EventController(EventService eventService,UserService userService,MessageService messageService) {
		this.eventService = eventService;
		this.userService = userService;
		this.messageService = messageService;
	}
	
	ArrayList<String> state = new ArrayList<String>(Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN",
			"MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI",
			"SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV", "WI", "WY"));
	
	//Dashboard
	//Show all events joined or not in state and out of state
	@GetMapping("/")
	public String dashboard(@Valid @ModelAttribute("eventObj") Event event, 
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
		session.setAttribute("states", state);
        List<Event> events = eventService.allEvents();
        List<Event> instate = new ArrayList<Event>();
        List<Event> outofstate = new ArrayList<Event>();
        
        for(Event origin: events) {
        	if(origin.getState().equals(user.getState())) {
        		instate.add(origin);
        		System.out.println("Instate " + instate);
        	}
        	else {
        		outofstate.add(origin);
        		System.out.println("Out Instate " + outofstate);
        	}
        }
        model.addAttribute("instate", instate);
        model.addAttribute("outofstate", outofstate);
        model.addAttribute("newevent", new Event());
		return "dashboard.jsp";
	}
	
	
	
	@GetMapping("/ordered/ASC")
	public String dashordered(@Valid @ModelAttribute("eventObj") Event event, 
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
		session.setAttribute("states", state);
        List<Event> events = eventService.allEvents();
        List<Event> instate = new ArrayList<Event>();
        List<Event> outofstate = new ArrayList<Event>();
        
        for(Event origin: events) {
        	if(origin.getState().equals(user.getState())) {
        		instate.add(origin);
        		Collections.sort(instate, eventService.compareLikes);
        		System.out.println("Instate " + instate);
        	}
        	else {
        		outofstate.add(origin);
        		System.out.println("Out Instate " + outofstate);
        	}
        }
        model.addAttribute("instate", instate);
        model.addAttribute("outofstate", outofstate);
        model.addAttribute("newevent", new Event());
		return "dashboard.jsp";
	}
	
	// view event
	@GetMapping("/{id}")
	public String viewEvent(@PathVariable("id") Long id, @Valid @ModelAttribute("messageObj") Message message, BindingResult result, Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findUserById((Long) session.getAttribute("userId"));
		Event event = eventService.findEventById(id);
		List<Message> messages = event.getMessages();
		System.out.println(messages);
		Collections.reverse(messages);
		model.addAttribute("event", event);
		model.addAttribute("user", user);
		model.addAttribute("attendees", event.getJoinedUsers());
//		model.addAttribute("messages", messages);
		System.out.println("**************");
		
		
		boolean mylike = false;
		int totalLikes = event.getUserLikes().size();
		for (int i = 0 ; i < event.getUserLikes().size(); i++) {
			if (user == event.getUserLikes().get(i)) {
				
				mylike = true;
			}
			
		}
		
		model.addAttribute("like", mylike);
		model.addAttribute("totall", totalLikes);
		return "details.jsp";
	}
	
	
	
// redirect to edit event page
	
	@GetMapping("/{id}/edit")
	public String editPage(@PathVariable("id") Long id, @ModelAttribute("event") Event event, Model model, HttpSession session) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		User user = userService.findUserById((Long)session.getAttribute("userId"));
		if(eventService.findEventById(id).getUser().getId() == user.getId()) {
			model.addAttribute("event", eventService.findEventById(id));
			return "edit.jsp";
		}
		else {
			return "redirect:/";
		}
	}
	
	
	//CRUD
		// create new event 
		@PostMapping("/addevent")
		public String createEvent(@Valid @ModelAttribute("newevent") Event newevent, BindingResult result, HttpSession session) {
			System.out.println(" I am in new event newevent ");
			if(result.hasErrors()) {
				return "dashboard.jsp";
			}
			else {
				System.out.println("newevent: " + newevent);
				eventService.addEvent(newevent);
				return "redirect:/events/";
				
			}	
		}
				
		// edit event
		@PutMapping("/{id}/edit")
		public String editEvent(@Valid @PathVariable("id") Long id, @ModelAttribute("event") Event event, BindingResult result, Model model, HttpSession session) {
			User user = userService.findUserById((Long)session.getAttribute("userId"));
			if(eventService.findEventById(id).getUser().getId() == user.getId()) {
				if(result.hasErrors()) {
					model.addAttribute("event", eventService.findEventById(id));
					return "edit.jsp";
				}
				else {
					Event eventEdit = eventService.findEventById(id);
					model.addAttribute("event", eventEdit);
					model.addAttribute("user", user);
					event.setUser(user);
					event.setJoinedUsers(event.getJoinedUsers());
					eventService.updateEvent(event);
					return "redirect:/events/";
				}
			}
			else {
				return "redirect:/events/";
			}
		}
		
		// join event
		@RequestMapping("/{id}/join")
		public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findEventById(id);
			List<User> attendees = event.getJoinedUsers();
			attendees.add(user);
			event.setJoinedUsers(attendees);
			userService.updateUser(user);	// try to update user				
			return "redirect:/events/";
		}
		
		
		
		// un-join event
		
	    @RequestMapping("/{id}/cancel")
	    public String cancelEvent(@PathVariable("id") Long id, HttpSession session) {
	    	User user = userService.findUserById((Long) session.getAttribute("userId"));
			Event event = eventService.findEventById(id);
	    	List<User> attendees = event.getJoinedUsers();
	        for(int i=0; i<attendees.size(); i++) {
	            if(attendees.get(i).getId() == user.getId()) {
	            	attendees.remove(i);
	            }
	        }
	        event.setJoinedUsers(attendees);
	        userService.updateUser(user);
	    	return "redirect:/events/";
	    }
	    
	    
	 // like event
	 		@RequestMapping("/{id}/like")
	 		public String likeEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
	 			User user = userService.findUserById((Long) session.getAttribute("userId"));
	 			Event event = eventService.findEventById(id);
	 			List<User> likes = event.getUserLikes();
	 			likes.add(user);
	 			event.setUserLikes(likes);
	 			userService.updateUser(user);
	 			// try to update user	
//	 			List<Event> eventLikes = userService.findLikesByEventId(id);
//	 			int likeCount = 0;
//	 			for (Event like : eventLikes) {
//	 				if (like.getId() == (Long) session.getAttribute("userId")) {
//	 					likeCount = likeCount + 1;
//	 				}
//	 			}
//	 			
//	 			if (likeCount > 0) {
//	 				session.setAttribute("liked", "yes");
//	 			}
//	 			if (likeCount == 0) {
//	 				session.setAttribute("liked", "no");
//	 			}
	 			return "redirect:/events/"  + id;
	 		}
	 		
	 		
	 		
	 		// un-like event
	 		
	 	    @RequestMapping("/{id}/unlike")
	 	    public String unlikeEvent(@PathVariable("id") Long id, HttpSession session) {
	 	    	User user = userService.findUserById((Long) session.getAttribute("userId"));
	 			Event event = eventService.findEventById(id);
	 	    	List<User> likes = event.getUserLikes();
	 	        for(int i=0; i<likes.size(); i++) {
	 	            if(likes.get(i).getId() == user.getId()) {
	 	            	likes.remove(i);
	 	            }
	 	        }
	 	        event.setUserLikes(likes);
	 	        userService.updateUser(user);
	 	    	return "redirect:/events/"  + id;
	 	    }
	    
	    // delete event if you dare
	    
	    @RequestMapping("/{id}/delete")
	    public String delete(@PathVariable("id") Long id,HttpSession session) {
	    	System.out.println("Delete idea");
	    
	    	Event event = eventService.findEventById(id);
	    	if (event.getUser().getId() == (Long)session.getAttribute("userId")) {
	    	for(User user: event.getJoinedUsers()) {
	    		List<Event> myevents = user.getJoinedevents();
	    		myevents.remove(event);
	    		user.setJoinedevents(myevents);;
	    		userService.updateUser(user);
	    	}

	    	eventService.deleteEvent(event);
	    	return "redirect:/events/";
	    	}
	    	else { return "redirect:/events/";}
	    		
	    }
		
		@PostMapping("/addmsg/{id}")
		public String addMessage(@PathVariable("id") Long id, @ModelAttribute("messageObj") Message message, Model model, HttpSession session) {
			User user = userService.findUserById((Long) session.getAttribute("userId"));
			model.addAttribute("user", user);
			messageService.createMessage(message);
			return "redirect:/events/" + id;
			
//			Event event = eventService.findEvent(id);
//			Long userId = (Long) session.getAttribute("userId");
//			User user = userService.findUserById(userId);
			
//			Message newMessage = new Message();
//			newMessage.setUser(user);
//			newMessage.setEvent(event);
//			newMessage.setMessage(message.getMessage());
//
//			messageService.createMessage(newMessage);
//			event.getMessages().add(newMessage);
//			eventService.updateEvent(event);
			
		}

}
