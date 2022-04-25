package com.alexismayoral.savetravel.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.alexismayoral.savetravel.models.Travel;
import com.alexismayoral.savetravel.services.TravelService;

@Controller
public class HomeController {
	
	@Autowired
	private TravelService travelService;
	
	@GetMapping("/expenses")
	public String allTravels(Model model) {
//		List<Travel> travels = travelService.allTravels();
//		model.addAttribute("travels", travels);
//		model.addAttribute("travels", travelService.allTravels());
//		model.addAttribute("travel", newTravel());
		model.addAttribute("travels", travelService.allTravels());
		model.addAttribute("travel", new Travel());
		return "expenses.jsp";
	}
	
	@GetMapping("/expenses/{id}")
	public String oneTravel(@PathVariable("id")Long id, Model model) {
		Travel oneTravel = travelService.findTravel(id);
		model.addAttribute("travel",oneTravel);
		return "showTravel.jsp";
	}

	
//	@GetMapping("/travels/new")
//	public String renderCreateForm(Model model) {
//		Travel emptyTravel = new Travel();
//		model.addAttribute("travel", emptyTravel);
//		return "create.jsp";
//	}
//	
//	@PostMapping("/travels/new")
//	public String processCreateTravel(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
//		if(result.hasErrors()) {
//			return "create.jsp";
//		}else {
//			travelService.createTravel(travel);
//			return"redirect:/expenses";
//		}
//	}
	
	@GetMapping("/travels/{id}/edit")
	public String renderEditForm(@PathVariable("id")Long id, Model model) {
		Travel oneTravel = travelService.findTravel(id);
		model.addAttribute("travel",oneTravel);
		return "editform.jsp";
	}
	
	@PutMapping("/travels/{id}/edit")
	public String processEdit(@Valid @ModelAttribute("travel") Travel travel, BindingResult result) {
		if(result.hasErrors()) {
			return "editform.jsp";
		}else {
			travelService.createTravel(travel);
			return"redirect:/expenses";
		}
	}
	 
	@DeleteMapping("/travels/{id}")
	public String deleteTravel(@PathVariable("id")Long id) {
		travelService.deleteTravel(id);
		return "redirect:/expenses";
	}
	
	@PostMapping("/process")
	public String processCombine(@Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("travels", travelService.allTravels());
			return "editform.jsp";
		}else {
			travelService.createTravel(travel);
			return"redirect:/expenses";
		}
	}	
	
}
