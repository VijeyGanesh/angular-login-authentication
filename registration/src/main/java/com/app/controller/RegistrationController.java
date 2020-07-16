package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.User;
import com.app.service.RegistrationService;

@RestController
public class RegistrationController {

	@Autowired
	private RegistrationService service;

	@PostMapping("/registeruser")
	public User registerUser(@RequestBody User user) throws Exception {

		String emailId = user.getEmailId();
		if (emailId != null && !emailId.isEmpty()) {
			User userObj = service.fetchUserByEmailId(emailId);
			if (userObj != null) {
				throw new Exception("User with " + emailId + " already exists!");
			}
		}
		User userInput = null;
		userInput = service.saveUser(user);
		return userInput;

	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		String tempEmailId = user.getEmailId();
		String tempPass = user.getPassword();
		User userObj = null;
		if (tempEmailId != null && tempPass != null) {
			userObj = service.fetchUserByEmailIdAndPassword(tempEmailId, tempPass);
		}
		if(userObj == null) {
			throw new Exception("Bad Credentials");
		}
		return userObj;

	}
}
