package com.alexismayoral.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

//import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.alexismayoral.dojosandninjas.models.Dojo;
import com.alexismayoral.dojosandninjas.models.Ninja;
import com.alexismayoral.dojosandninjas.services.DojoService;
import com.alexismayoral.dojosandninjas.services.NinjaService;

@Controller
public class NinjasController {

	@Autowired
	NinjaService ninjaService;
	
	@Autowired
	DojoService dojoService;
	
	@GetMapping("/ninjas/new")
	public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("dojos", allDojos);
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Dojo> allDojos = dojoService.allDojos();
			model.addAttribute("dojos", allDojos);
			return "newNinja.jsp";
		} else {
			ninjaService.saveNinja(ninja);
			
			return "redirect:/";
		}
	}
}
