package com.vicky.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.vicky.languages.models.Language;
//import com.vicky.languages.services.LanguageService;
import com.vicky.languages.services.LanguageService;


@RestController
public class LanguagesAPI {
	
	private final LanguageService languageService;
	public LanguagesAPI(LanguageService languageService) {
		this.languageService = languageService;
	}

    @RequestMapping("/api/languages")
    public List<Language> index() {
        return languageService.allLanguages();
    }
    
    @RequestMapping(value ="api/languages", method=RequestMethod.POST)
    public Language create(@RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {
    	Language language = new Language(name, creator, version);
    	return languageService.createLanguage(language);
    }
    

    //show
    @RequestMapping("/api/languages/{id}")
    public Language show(@PathVariable("id") Long id) {
        Language language = languageService.findLanguage(id);
        return language;
    }
    
    // update
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.PUT)
    public Language update(@PathVariable("id") Long id, @RequestParam(value="name") String name, @RequestParam(value="creator") String creator, @RequestParam(value="version") String version) {    
    	Language language = languageService.findLanguage(id);
    	language.setName(name);
    	language.setCreator(creator);
    	language.setVersion(version);
    	return language;
    }
    
    // delete
    @RequestMapping(value="/api/languages/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
    }
}


