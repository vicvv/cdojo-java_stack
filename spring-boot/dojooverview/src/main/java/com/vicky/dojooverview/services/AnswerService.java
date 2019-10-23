package com.vicky.dojooverview.services;

import java.util.List;
import com.vicky.dojooverview.models.Answer;
import com.vicky.dojooverview.repositories.AnswerRepository;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class AnswerService {
	private final AnswerRepository answerRepository;
	
	public AnswerService(AnswerRepository answerRepository) {
		this.answerRepository = answerRepository;
	}
	
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);
		
	}
	
	public List<Answer> getAll(){
		return (List<Answer>)answerRepository.findAll();
	}
	
	public Answer getOne(Long id) {
		Optional<Answer> optionalAnswer = answerRepository.findById(id);
		if (optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		}
		else {
			return null;
		}
	}
	
	
	public void deleteAnswer(Answer answer) {
		answerRepository.delete(answer);;
	}

}
