package com.vicky.languages.services;

import org.springframework.stereotype.Service;

import com.vicky.languages.models.Language;
import com.vicky.languages.repositories.LanguageRepository;

import java.util.List;
import java.util.Optional;


@Service
public class LanguageService {
private final LanguageRepository languageRepository;
	
	public LanguageService(LanguageRepository LanguageRepository) {
		this.languageRepository = LanguageRepository;
	}
	
	// returns all the Languages
    public List<Language> allLanguages() {
        return languageRepository.findAll();
    }
    // creates a Language
    public Language createLanguage(Language b) {
        return languageRepository.save(b);
    }
    // retrieves a Language
    public Language findLanguage(Long id) {
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()) {
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    
    // update Language
    public Language saveLanguage(Language b) {
    	return languageRepository.save(b);
    }
    
    // delete Language
    public void deleteLanguage(Long id) {
    	languageRepository.deleteById(id);
    } 
}