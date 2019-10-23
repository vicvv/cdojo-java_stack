package com.vicky.license.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.vicky.license.models.License;
import com.vicky.license.repositories.LicenseRepository;
import com.vicky.license.repositories.PersonRepository;


@Service
public class LicenseService {
	private static String linPrefix = "00000";
	private static Long linid;
	private final LicenseRepository licenseRepository;
	private final PersonRepository personRepository;
	
	public LicenseService(LicenseRepository licenseRepository, PersonRepository personRepository) {
		this.licenseRepository = licenseRepository;
		this.personRepository = personRepository;
	}
	
	public void addOneLicense(License license) {
		
		ArrayList<License> lic = (ArrayList<License>)licenseRepository.findAll();
		
		int num = lic.size() + 1;
		
		String res = String.format("%06d", num);

		license.setNumber(res);
		
		licenseRepository.save(license);
	}
	
	public License getLicenseById(Long id) {
		return licenseRepository.getLicenseByPersonId(id);
	}
	public void deleteLicense(Long id) {
		licenseRepository.deleteById(id);
	}
}
