package com.vicky.dojooverview.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicky.dojooverview.services.AnswerService;

@Controller
@RequestMapping("/answers")

public class Answers {
	
	private final AnswerService answerService;
	
	public Answers(AnswerService answerService) {
		this.answerService = answerService;
	}

}
