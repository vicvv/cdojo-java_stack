package com.vicky.license.controllers;

import org.springframework.stereotype.Controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.vicky.license.models.License;
import com.vicky.license.models.Person;
import com.vicky.license.services.LicenseService;
import com.vicky.license.services.PersonService;



@Controller
@RequestMapping("/")
public class MainController {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public MainController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);		
		return "index.jsp";
		
	}
	
	
	@RequestMapping("/persons/new")
	public String showAddPerson(Model model, @ModelAttribute("person") Person person) {
		System.out.println("I am in add new person");
		return "add.jsp";
	}
		
	
	@PostMapping("/persons/new")
	public String AddPerson(@Valid @ModelAttribute("person") Person person, BindingResult result, RedirectAttributes errors) {
		System.out.println("I am in add new person");
		
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/persons/new";
		} else {
			personService.addPerson(person);
			return "redirect:/";
		}
	}
	
	
	@RequestMapping("/licenses/new")
	public String showAddLicense(Model model, @ModelAttribute("license") License license) {
		List<Person> persons = personService.getAllPersons();
		model.addAttribute("persons", persons);
		return "addlicense.jsp";
	}
	@PostMapping("/licenses/new")
	public String addLicense(@Valid @ModelAttribute("license") License license, BindingResult result, RedirectAttributes errors) {
		System.out.println(license.getExpirationDate());
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/licenses/new";
		} else {
			licenseService.addOneLicense(license);
			return "redirect:/";
		}
	}
	
	// view person license
	@RequestMapping("/persons/{id}")
	public String showOnePersonLicense(Model model, @PathVariable("id") Long id) {
		Person person = personService.findPerson(id);
		if(person == null) {
			return "redirect:/";
		}
		model.addAttribute("person", person);
		return "showlicense.jsp";
	}
	
	
	@RequestMapping("persons/{personId}/delete")
	public String deletePerson(@PathVariable("personId") Long personId) {
		personService.deletePerson(personId);
		return "redirect:/";
	}
	
	

}