package com.vicky.eventsbeltreviewer.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.vicky.eventsbeltreviewer.models.Event;
import com.vicky.eventsbeltreviewer.models.User;
import com.vicky.eventsbeltreviewer.repositories.EventRepository;
import com.vicky.eventsbeltreviewer.repositories.UserRepository;



@Service
public class UserService {
    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    
    public UserService(UserRepository userRepository, EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    // find user by email
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
   
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public boolean duplicateUser(String email) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        }
        else {
        	return true;
        }
    }
    
    public User updateUser(User user) {
    	return userRepository.save(user);
    }

	
}

