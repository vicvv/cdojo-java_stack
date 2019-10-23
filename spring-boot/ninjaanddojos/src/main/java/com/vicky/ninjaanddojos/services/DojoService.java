package com.vicky.ninjaanddojos.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.vicky.ninjaanddojos.models.Dojo;
import com.vicky.ninjaanddojos.repositories.DojoRepository;

@Service
public class DojoService {

	private final DojoRepository dojoRepository;
	
	public DojoService(DojoRepository dojoRepository) {
		this.dojoRepository = dojoRepository;
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	public List<Dojo> getAllDojos(){
		return (List<Dojo>)dojoRepository.findAll();
	}
	
	// retrieves one Dojo
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }

    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    } 

}
