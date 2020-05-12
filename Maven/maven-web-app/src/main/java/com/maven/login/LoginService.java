package com.maven.login;

public class LoginService {
	
	public boolean isUserValid(String user, String password) {
		if(user.equals("divya") && password.equals("dummy")) 
			return true;
		
		return false;
	}

}
