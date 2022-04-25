package com.alexismayoral.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexismayoral.dojosandninjas.models.Dojo;
import com.alexismayoral.dojosandninjas.repositories.DojoRepo;

@Service
public class DojoService {

	private final DojoRepo dojoRepo;
	
	public DojoService(DojoRepo d) {
		this.dojoRepo = d;
	}
	
	public List<Dojo> allDojos(){
		return dojoRepo.findAll();
	}
	
	public Dojo saveDojo(Dojo d) {
		return dojoRepo.save(d);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optd = dojoRepo.findById(id);
		if (optd.isPresent()) {
			return optd.get();
		} else return null;
	}
	
	public void deleteDojo(Long id) {
		
		dojoRepo.deleteById(id);
	}
}
