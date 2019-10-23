package com.vicky.dojooverview.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.vicky.dojooverview.models.Question;
import com.vicky.dojooverview.repositories.QuestionRepository;

@Service
public class QuestionService {
	
	private final QuestionRepository questionRepository;
	
	public QuestionService (QuestionRepository questionRepository) {		
		this.questionRepository = questionRepository;
		
	}
	public void addQuestion(Question q) {		
		questionRepository.save(q);
		
	}	
	public List<Question> getAll(){
		return (List<Question>) questionRepository.findAll();
	}
	public Question getOne(Long id) {
		Optional<Question> optionalQuestion = questionRepository.findById(id);
        if(optionalQuestion.isPresent()) {
            return optionalQuestion.get();
        } else {
            return null;
        }
    }
	
	public void deleteQuestion(Question q) {
		questionRepository.delete(q);
				
	}	

}
