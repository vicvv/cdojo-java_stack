package com.vicky.dojooverview.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.vicky.dojooverview.models.Answer;
import com.vicky.dojooverview.models.Question;
import com.vicky.dojooverview.models.Tag;

import com.vicky.dojooverview.services.AnswerService;
import com.vicky.dojooverview.services.QuestionService;
import com.vicky.dojooverview.services.TagService;



@Controller
@RequestMapping("/questions")

public class Questions {
	
	private final QuestionService questionService;
	private final TagService tagService;
	private final AnswerService answerService;
	
	
	public Questions(QuestionService questionService, TagService tagService, AnswerService answerService){
	  
		this.questionService = questionService;
	    this.tagService = tagService;
	    this.answerService = answerService;
	}
	
	
	@RequestMapping("")
	public String dashboard(Model model){
		System.out.println("I am in index ...");
		model.addAttribute("questions", questionService.getAll());
		model.addAttribute("tags", tagService.getAll());
		System.out.println(model.containsAttribute("questions"));
		System.out.println(model.containsAttribute("tags"));
	    return "index.jsp";
	}
	@RequestMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question, Model model){
	    Boolean test = false;
	    model.addAttribute("test", test);
	    return "newQuestion.jsp";
	}
	@PostMapping("/new")
    public String createQuestion(@RequestParam("q") String q, @RequestParam("tags") String tagsString){
        System.out.println("I am in new question : " + q + "  " + tagsString);
		
		if(q.equals("")){
            return "redirect:/questions/new";
        }
        Question newQuestion = new Question(q);
        if(tagsString.length() > 0){

            String[] tagList = tagsString.split(",");
            if(tagList.length > 3){
                return "redirect:/questions/new";
            }
            List<Tag> tags = new ArrayList<>();
            for (String tag : tagList){
                Tag tag1;
                if(tagService.findBySubject(tag) == null){
                    tag1 = new Tag(tag);
                    tagService.addTag(tag1);
                    tag1 = tagService.getOne(tag1.getId());
                }else{
                    tag1 = tagService.findBySubject(tag);
                }
                tags.add(tag1);
            }
            newQuestion.setTags(tags);
        }
        questionService.addQuestion(newQuestion);
        
     
        return "redirect:/questions";
    }
	
	@RequestMapping("/{id}")
    public String getOneQuestion(@PathVariable("id") Long id, Model model, @ModelAttribute("answerModel") Answer answerModel){
        Question q = questionService.getOne(id);
        model.addAttribute("q", q);
        return "question.jsp";
    }
    @PostMapping("/{id}")
    public String newAnswer(@Valid @ModelAttribute("answerModel") Answer answerModel, BindingResult result, @PathVariable("id") Long id, Model model){
        Question q = questionService.getOne(id);
        if(result.hasErrors()){
            System.out.println(answerModel);
            model.addAttribute("q", q);
            return "question.jsp";
        }else{
            

        	answerModel.setQuestion(q);
            answerService.addAnswer(answerModel);
            return "redirect:/questions/"+id;
        }
    }	
}
