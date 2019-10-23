package com.vicky.license.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.vicky.license.models.License;

public interface LicenseRepository extends CrudRepository <License, Long> {

	License getLicenseByPersonId(Long id);
	
	//@Query(value = "SELECT seq_name.nextval FROM dual", nativeQuery = true)
	 
	//Long getNextSeriesId();

}
