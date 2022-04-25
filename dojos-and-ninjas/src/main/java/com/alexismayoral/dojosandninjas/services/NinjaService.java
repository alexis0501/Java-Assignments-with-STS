package com.alexismayoral.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexismayoral.dojosandninjas.models.Ninja;
import com.alexismayoral.dojosandninjas.repositories.NinjaRepo;

@Service
public class NinjaService {
	
	private final NinjaRepo ninjaRepo;
	
	public NinjaService(NinjaRepo n) {
		this.ninjaRepo = n;
	}
	
	public List<Ninja> allNinjas(){
		return ninjaRepo.findAll();
	}
	
	public Ninja saveNinja(Ninja n) {
		return ninjaRepo.save(n);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optn = ninjaRepo.findById(id);
		if (optn.isPresent()) {
			return optn.get();
		} else return null;
	}
	
	public void deleteNinja(Long id) {
		ninjaRepo.deleteById(id);
	}
}
