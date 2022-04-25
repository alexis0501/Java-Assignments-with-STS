package com.alexismayoral.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.alexismayoral.bookclub.models.LoginUser;
import com.alexismayoral.bookclub.models.User;
import com.alexismayoral.bookclub.repositories.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepo;
	
	//new change
	public User getUserById(Long id) {
		Optional<User> optU = userRepo.findById(id);
		if(optU.isPresent()) {
			return optU.get();
		}else return null;
	}
	
	public User register(User newUser, BindingResult result) {

		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());

		if(potentialUser.isPresent()) {
			result.rejectValue("email", "reject", "The email already exists");
		}

        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "identical", "The password and confirm password do not match");
        }	

        if(result.hasErrors()) {
        	return null;
        }

        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
		
	}
	
	public User login(LoginUser newLogin, BindingResult result ) {
        
		Optional<User> potentialUser = userRepo.findByEmail(newLogin.getEmail());
		

		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "reject", "Unknown email");
			return null;
		}
		

		User user = potentialUser.get();

		
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
		    result.rejectValue("password", "identical", "Invalid Password!");
		}

    

		if(result.hasErrors()) {
			return null;
		}
		return user;
		
	}	
}
