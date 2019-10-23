package com.vicky.license.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vicky.license.models.Person;


public interface  PersonRepository  extends CrudRepository<Person, Long>{
	
//	@Query("SELECT firstname, lastname, number, state  from persons join licenses on licenses.person_id = persons.id;")
//    List<Object[]> joinPersonsAndLicenses();

}
