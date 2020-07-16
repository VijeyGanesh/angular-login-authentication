package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.User;
import com.app.repository.RegistrationRepository;

@Service
public class RegistrationService {

	@Autowired
	RegistrationRepository registrationRepository;

	public User saveUser(User user) {
		return registrationRepository.save(user);

	}

	public User fetchUserByEmailId(String emailId) {
		return registrationRepository.findByEmailId(emailId);
	}
	
	public User fetchUserByEmailIdAndPassword(String emailId,String password) {
		return registrationRepository.findByEmailIdAndPassword(emailId,password);	
	}
}
