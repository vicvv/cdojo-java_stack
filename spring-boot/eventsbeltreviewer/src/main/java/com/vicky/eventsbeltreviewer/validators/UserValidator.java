package com.vicky.eventsbeltreviewer.validators;



import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.vicky.eventsbeltreviewer.models.User;
import com.vicky.eventsbeltreviewer.services.UserService;

@Component
public class UserValidator implements Validator {
	
	private UserService userService;
	
	public UserValidator(UserService userService) {
		this.userService = userService;
	}

	@Override
    public boolean supports(Class<?> cla$$) {
        return User.class.equals(cla$$);
    }
    
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("passwordConfirmation", "Match");
		
		}
		
		if(userService.findByEmail(user.getEmail()) != null) {
    		errors.rejectValue("email", "Taken");
    }
	
	}
}
