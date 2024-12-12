package com.ayur.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayur.Model.UserDetails;
import com.ayur.Repository.UserDetailsRepository;
import com.ayur.Service.UserDetailsService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Override
	public UserDetails saveUserDetails(UserDetails userDetails) {
		// TODO Auto-generated method stub
		 UserDetails existingUser = userDetailsRepository.findByUserEmail(userDetails.getUserEmail());
	        if(existingUser != null) {
	            throw new RuntimeException("Email already exists");
	        }
	        // Save the new user details
	        return userDetailsRepository.save(userDetails);
	}

	@Override
	public UserDetails loginUserDetails(String userEmail, String userPassword) {
		// TODO Auto-generated method stub
		return userDetailsRepository.findByUserEmailAndUserPassword(userEmail, userPassword);
	}

	@Override
	public UserDetails findUserDetailsByUserEmail(String userEmail) {
		// TODO Auto-generated method stub
		return userDetailsRepository.findByUserEmail(userEmail);
	}

}
