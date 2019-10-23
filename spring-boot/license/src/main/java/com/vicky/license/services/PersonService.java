package com.vicky.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.vicky.license.models.Person;
import com.vicky.license.repositories.PersonRepository;


@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	// add one person
	public void addPerson(Person person) {
		personRepository.save(person);
		
	}
	
	// find all persons
	
	public List<Person> getAllPersons(){
		
		return (List<Person>)personRepository.findAll();
		
	}
	
	// find by id
	
	public Person findPerson(Long id) {
		
		Optional<Person> optionalPerson = personRepository.findById(id);
		if (optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
		
	}
	
	public void deletePerson(Long id) {
		personRepository.deleteById(id);
	}
	
//	public Person getPersonById(Long id) {
//		return personRepository.findOne(id);
//	}

}
