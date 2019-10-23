package com.vicky.ninjaanddojos.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicky.ninjaanddojos.models.Ninja;
import com.vicky.ninjaanddojos.services.DojoService;
import com.vicky.ninjaanddojos.services.NinjaService;

@Controller
@RequestMapping("/ninjas")
public class NinjaController {
	
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	public NinjaController(DojoService dojoService, NinjaService ninjaService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninjas")
	public String index(Model model) {
		model.addAttribute("ninjas", ninjaService.all());
		return "ninjas.jsp";
		
	}
	
	@RequestMapping("/new")
	public String show(Model model) {
		model.addAttribute("ninja", new Ninja());
		model.addAttribute("dojos", dojoService.getAllDojos());
		return "ninjanew.jsp";
	}
	@PostMapping("/new")
	public String add(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, RedirectAttributes errors) {
		if(result.hasErrors()) {
			errors.addFlashAttribute("errors", result.getAllErrors());
			return "redirect:/ninjas/new";
		} else {
			ninjaService.addNinja(ninja);
			return "redirect:/";
		}
	}

}
