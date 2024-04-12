package com.Auth.Service;

import com.Auth.Model.LogInModel;
import com.Auth.Model.UserProfile;
import com.Auth.Model.UserProfileResponse;

import org.springframework.stereotype.Service;

@Service
public interface AuthService {
	

	public UserProfile CreateProfile(UserProfile user);
	public int authUser(LogInModel login);
	public UserProfileResponse getProfile(long mobileNumber);
	
}
