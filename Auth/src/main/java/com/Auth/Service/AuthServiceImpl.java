package com.Auth.Service;

import com.Auth.Model.LogInModel;
import com.Auth.Model.UserProfile;
import com.Auth.Model.UserProfileResponse;
import com.Auth.Repository.AuthRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	AuthRepository authRepo;

	@Override
	public UserProfile CreateProfile(UserProfile user) {
		
		try {
			if(authRepo.findByMobileNumber(user.getMobileNumber())==null) {
				System.out.println("we are in------------");
				return authRepo.save(user);
				
			}
			else {
				System.out.println("Inside Else");
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int authUser(LogInModel login) {
		UserProfile dbUser = authRepo.findByMobileNumber(login.getMobileNumber());
		if(dbUser==null) {
			return 3;
		}
		else {
			if(dbUser.getPassword().equals(login.getPassword())) {
				return 1;
			}
			else {
				return 2;
			}
		}

	}

	@Override
	public UserProfileResponse getProfile(long mobileNumber) {
		try {
			UserProfileResponse response= new UserProfileResponse();
			UserProfile user=  authRepo.findByMobileNumber(mobileNumber);
			response.setImgUrl(user.getImgUrl());
			response.setMoblieNumber(user.getMobileNumber());
			response.setUserName(user.getFirstName()+" " +user.getLastName());
			return response;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}


}
