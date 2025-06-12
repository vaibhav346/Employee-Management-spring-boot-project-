package com.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DTO.UserDTO;
import com.Entity.User;
import com.Service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserContorller {

	@Autowired
	UserService user;

	@PostMapping("/registe")
	public String registe(@RequestBody User u) {
		return user.registration(u);
	}

	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserDTO userdto) {
		User u = user.login(userdto.getUsername(), userdto.getPassword());
		if (u != null) {
			return ResponseEntity.ok(u);
		}

		else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username or Password");
		}
	}

}
