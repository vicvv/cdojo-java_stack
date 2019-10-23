package com.vicky.ninjaanddojos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vicky.ninjaanddojos.models.Ninja;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

}
