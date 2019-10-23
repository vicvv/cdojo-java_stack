package com.vicky.dojooverview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.dojooverview.models.Tag;
import com.vicky.dojooverview.repositories.TagRepository;

@Service
public class TagService {
	
	private final TagRepository tagRepository;
	
	public TagService(TagRepository tagRepository) {
		this.tagRepository = tagRepository;
	}

	public void addTag(Tag tag) {
		tagRepository.save(tag);
	}
	
	public List<Tag> getAll(){
		return (List<Tag>) tagRepository.findAll();
	}
	
	public Tag getOne(Long id) {
		Optional<Tag> optionalTag = tagRepository.findById(id);
        if(optionalTag.isPresent()) {
            return optionalTag.get();
        } else {
            return null;
        }
    }
	
	public void deleteTag(Tag tag) {
		tagRepository.delete(tag);
	}
	
	public Tag findBySubject(String t){
        return tagRepository.findByTEquals(t);
    }
	

}
