package com.Auth.Repository;

import com.Auth.Model.UserProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthRepository extends JpaRepository<UserProfile, Long> {
	
	public UserProfile findByMobileNumber(long mobilNumber);

}
