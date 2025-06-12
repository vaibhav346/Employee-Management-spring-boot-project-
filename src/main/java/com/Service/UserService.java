package com.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.User;
import com.Repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository user;

	public String registration(User u) {
		// check for duplicate username
		User existinguser = user.findByUsername(u.getUsername()).orElse(null);
		if (existinguser != null) {
			return "Please enter another username. This is one is already exists";

		} else {
			user.save(u);
			return "Your Registration completed sucessfully";
		}

	}

	public User login(String username, String password) {

		User existinguser = user.findByUsername(username).orElse(null);
		if (existinguser.getPassword().equals(password)) {
			return existinguser;
		}

		return null;

	}

}
