package com.vicky.ninjaanddojos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.vicky.ninjaanddojos.models.Ninja;
import com.vicky.ninjaanddojos.repositories.NinjaRepository;


@Service

public class NinjaService {
	private final NinjaRepository ninjaRepository;
	
	public NinjaService(NinjaRepository ninjaRepository) {
		this.ninjaRepository = ninjaRepository;
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
	public List<Ninja> all() {
		return (List<Ninja>) ninjaRepository.findAll();
	}
	
}
