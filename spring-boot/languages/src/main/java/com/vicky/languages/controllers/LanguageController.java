package com.vicky.languages.controllers;

import java.util.List;

import javax.validation.Valid;


import java.io.*; 
import java.util.ArrayList; 
import javax.servlet.*; 
import javax.servlet.http.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicky.languages.models.Language;
import com.vicky.languages.services.LanguageService;


@Controller
public class LanguageController {
	
	private final LanguageService languageService;
	
	public LanguageController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	
	
	@RequestMapping("/languages")
	public String index(Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("newlanguage", new Language());
		return "languages/index.jsp";
		
	}
	

	 
	 @PostMapping("/languages")
		public String create(@Valid @ModelAttribute("language") Language newlanguage, BindingResult result, RedirectAttributes errors) {
			if(result.hasErrors()) {
				errors.addFlashAttribute("errors", result.getAllErrors());
				return "redirect:/languages";
			} else {
				languageService.createLanguage(newlanguage);
				return "redirect:/languages";
			}
		}
	 
	 // view one language
	 @RequestMapping("/languages/{id}")
	 public String showlanguage(Model model, @PathVariable("id") Long id, Language language) {
	     language = languageService.findLanguage(id);
	     model.addAttribute("language", language);
		 return "/languages/show.jsp";
	 }
	 
	 // edit language route
	 
	 @RequestMapping("/languages/{id}/edit")
	 public String edit(@PathVariable("id") Long id, Model model) {
	     Language language = languageService.findLanguage(id);
	     model.addAttribute("language", language);
	     return "/languages/edit.jsp";
	 }
	 
	 // edit language form
	 @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
	     if (result.hasErrors()) {
	         return "/languages/edit.jsp";
	     } else {
	         languageService.saveLanguage(language);
	         return "redirect:/languages";
	     }
	 }
//	 // delete language
//	 @RequestMapping(value="/languages/delete/{id}", method=RequestMethod.DELETE)
//	 public String destroy(@PathVariable("id") Long id) {
//	     languageService.deleteLanguage(id);
//	     return "redirect:/languages";
//	 }
	 
	// delete language
		 @RequestMapping(value="/languages/delete/{id}")
		 public String destroy2(@PathVariable("id") Long id) {
		     languageService.deleteLanguage(id);
		     return "redirect:/languages";
		 }

}
