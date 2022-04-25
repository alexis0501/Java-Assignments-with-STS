 package com.alexismayoral.savetravel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexismayoral.savetravel.models.Travel;
import com.alexismayoral.savetravel.repositories.TravelRepository;

@Service
public class TravelService {
	
	
	private final TravelRepository travelRepo;
	
	public TravelService(TravelRepository travelRepo) {
		this.travelRepo = travelRepo;
	}
	
	public List<Travel> allTravels(){
		return travelRepo.findAll();
	}
	
	public Travel findTravel(Long id) {
		Optional<Travel> optionalTravel = travelRepo.findById(id);
		if(optionalTravel.isPresent()) {
			optionalTravel.get();
			return optionalTravel.get();
		}else {
			return  null;
		}
	
	}
	
	public Travel createTravel(Travel travel) {
		return travelRepo.save(travel);
	}	
	
	public Travel updateTravel(Travel travel) {
		return travelRepo.save(travel);
	}
	
	public void deleteTravel(Long id) {
		travelRepo.deleteById(id);
	}
	
	
	
	
	
	
	
}
