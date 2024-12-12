package com.ayur.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayur.Model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Integer> {
	 UserDetails findByUserEmail(String userEmail);
	 UserDetails findByUserEmailAndUserPassword(String userEmail, String userPassword);
}
