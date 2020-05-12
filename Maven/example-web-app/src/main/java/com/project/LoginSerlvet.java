package com.project;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/login")
public class LoginSerlvet extends HttpServlet {

	  UserAuthService authService = new UserAuthService();
	
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  
		  
		  //request.setAttribute("fname", request.getParameter("fname"));
		  //request.setAttribute("lname", request.getParameter("lname"));
		  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		  
	  }

	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		  
		  
		  String fname = request.getParameter("fname");
		  String lname = request.getParameter("lname");
		  String password = request.getParameter("password");
		  
		  boolean isValidUser = authService.isValid(fname, lname, password);
		  
		  if(isValidUser) {
			  request.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(request, response);
		  } else {
			  request.setAttribute("errorMessage1", "Wrong Values Entered....!");
			  request.setAttribute("errorMessage2", "Check Details Properly....!");
			  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		  }
		  
		  
	  }

	

}
