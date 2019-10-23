package com.vicky.languages.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.vicky.languages.models.Language;

import java.util.List;
//import antlr.collections.List;

@Repository

public interface LanguageRepository extends CrudRepository<Language, Long>{
	// this method retrieves all the books from the database
    List<Language> findAll();
    // this method find a book by their description
    List<Language> findByName(String search);
    // this method counts how many titles contain a certain string
    Long countByNameContaining(String search);
    // this method deletes a book that starts with a specific title
    Long deleteByNameStartingWith(String search);

	
}
