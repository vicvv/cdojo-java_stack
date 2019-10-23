package com.vicky.eventsbeltreviewer.services;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.eventsbeltreviewer.models.Event;
import com.vicky.eventsbeltreviewer.models.User;
import com.vicky.eventsbeltreviewer.repositories.EventRepository;

@Service
public class EventService {
	
	private final EventRepository eventRepository;
	public static Comparator<Event> compareLikes = (Event e1, Event e2) -> 
	((Integer)e1.getUserLikes().size()).compareTo((Integer)(e2.getUserLikes().size()));
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> allEvents(){
		return (List<Event>)eventRepository.findAll();
	}
	
	public Event addEvent(Event event) {
		return eventRepository.save(event);
	}
	
	public void updateEvent(Event event) {
		eventRepository.save(event);
	}
	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}
	
	public Event findEventById(Long id) {
    	Optional<Event> event = eventRepository.findById(id);
    	if(event.isPresent()) {
            return event.get();
    	}
    	else {
    	    return null;
    	}
    }

}
