package com.Auth.Controller;

import com.Auth.Exception.DatabaseConnectionException;
import com.Auth.Model.LogInModel;
import com.Auth.Model.ResponseModel;
import com.Auth.Model.UserProfile;
import com.Auth.Model.UserProfileResponse;
import com.Auth.Service.AuthServiceImpl;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuthController {
	
	
	
	@Autowired
	AuthServiceImpl authService;
	
	@PostMapping("user/create")
	public ResponseEntity<UserProfile> createUserProfile(@RequestBody UserProfile userProfile){
		return new ResponseEntity<>(authService.CreateProfile(userProfile), HttpStatus.OK);
	}
	
	@PostMapping("user/login")
	public ResponseEntity<?> AuthUser(@RequestBody LogInModel logInetails){
		ResponseModel response = new ResponseModel();
		if(authService.authUser(logInetails)==1) {
			response.setMessage("logIn suuccessful");
			response.setStatusCode(HttpStatus.ACCEPTED.value()); // 202
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else if(authService.authUser(logInetails)==2) {
			response.setMessage("Inccorect login Details");
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value()); // 406
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			response.setMessage("User not yet registered on this platform,  please sing Up >> click Join");
			response.setStatusCode(HttpStatus.BAD_REQUEST.value()); // 400
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}
	
	@GetMapping("user/profile")
	public ResponseEntity<UserProfileResponse> getUserProgile(@RequestParam long mobileNumber) throws Exception{
		UserProfileResponse temp = authService.getProfile(mobileNumber);
		if(temp!=null) {
			return new ResponseEntity<UserProfileResponse>(temp, HttpStatus.OK);
		}
		else {
			throw new DatabaseConnectionException("Data base connection exeption");
		}

	}
	@GetMapping("check")
	public UserProfile getuser() {
		
		UserProfile user = new UserProfile();
		user.setFirstName("ajit");
		user.setLastName("Satpute");
		user.setMobileNumber(982208859);
		
		return user;
		
	}


}
