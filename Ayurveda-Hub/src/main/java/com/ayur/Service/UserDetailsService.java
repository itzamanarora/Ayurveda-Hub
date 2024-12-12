package com.ayur.Service;


import com.ayur.Model.UserDetails;

public interface UserDetailsService {
	public UserDetails saveUserDetails(UserDetails userDetails);
	public UserDetails loginUserDetails(String userEmail, String userPassword);
	public UserDetails findUserDetailsByUserEmail(String userEmail);
}
