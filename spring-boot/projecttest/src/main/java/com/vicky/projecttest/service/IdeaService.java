package com.vicky.projecttest.service;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.projecttest.model.Idea;
import com.vicky.projecttest.repository.IdeaRepository;





@Service

public class IdeaService {
	
	
	
	private final IdeaRepository ideaRepository;
//	public static Comparator<Idea> compareLikes = 
//			(Idea i1, Idea i2) -> 
//	((Integer)i1.getJoinedUsers()).compareTo((Integer)(i2.getUserLikes().size()));
	
	public IdeaService(IdeaRepository ideaRepository) {
		this.ideaRepository = ideaRepository;
	}
	
	public List<Idea> allIdeas(){
		return (List<Idea>)ideaRepository.findAll();
	}
	
	public Idea addIdea(Idea idea) {
		return ideaRepository.save(idea);
	}
	
	public void updateIdea(Idea idea) {
		ideaRepository.save(idea);
	}
	public void deleteIdea(Idea idea) {
		ideaRepository.delete(idea);
	}
	
	public Idea findIdeaById(Long id) {
    	Optional<Idea> idea = ideaRepository.findById(id);
    	if(idea.isPresent()) {
            return idea.get();
    	}
    	else {
    	    return null;
    	}
    }

}


