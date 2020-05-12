package com.project;

public class UserAuthService {
	
	public static boolean isValid(String fname, String lname, String password) {
		if(fname.equals("Divya") && lname.equals("Maddipudi") && password.equals("12345"))
			return true;
		return false;
	}

}
