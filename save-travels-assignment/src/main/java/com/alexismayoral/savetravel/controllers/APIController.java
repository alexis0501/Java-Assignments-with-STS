package com.alexismayoral.savetravel.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alexismayoral.savetravel.models.Travel;
import com.alexismayoral.savetravel.services.TravelService;

@RestController
@RequestMapping("/api")
public class APIController {

	private final TravelService travelService;
	
	public APIController(TravelService travelService) {
		this.travelService = travelService; 
	}
	
	@GetMapping("/expenses")
	public List<Travel> findAllTravels(){
		return travelService.allTravels();
	}
	
	@PostMapping("/expenses")
	public Travel createTravel(
		@RequestParam("amount") Integer amount,
		@RequestParam("expense") String expense,
		@RequestParam("vendor") String vendor,
		@RequestParam("description") String description
			) {
		Travel newTravel = new Travel(amount, expense, vendor, description);
		return travelService.createTravel(newTravel);
	}
	
	@GetMapping("expenses/{id}")
	public Travel oneTravel(@PathVariable("id") Long id) {
		return travelService.findTravel(id);
	}
	
	@PutMapping("/expenses/{id}")
	public Travel updateTravel(
			@PathVariable("id") Long id,
			@RequestParam("amount") Integer amount,
			@RequestParam("expense") String expense,
			@RequestParam("vendor") String vendor,
			@RequestParam("description") String description
			) {
		Travel updateTravel = travelService.findTravel(id);
		updateTravel.setAmount(amount);
		updateTravel.setExpense(expense);
		updateTravel.setVendor(vendor);
		updateTravel.setDescription(description);
		return travelService.updateTravel(updateTravel);
	}
	
	@DeleteMapping("/expenses/{id}")
	public void deleteTravel(@PathVariable("id")Long id) {
		travelService.deleteTravel(id);
	}
	
	
}
