package com.alexismayoral.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexismayoral.dojosandninjas.models.Dojo;
import com.alexismayoral.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}

	@PostMapping("/dojos")
	public String createDojo(@Valid @ModelAttribute("dojo")Dojo dojo, BindingResult result, Model model ) {
		if (result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dojoService.saveDojo(dojo);
			
			return "redirect:/";
		}
	}
	
	@GetMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "showDojo.jsp";
	}
}
