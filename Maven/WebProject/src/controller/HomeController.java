package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import entity.Diary;
import entity.LoginUsers;
import model.DiaryModel;
import model.LoginUsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/project")
	private DataSource dataSource;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		action = action.toLowerCase();
		
		switch(action) {
		case "signupsubmit":
			String name = request.getParameter("name");
			LoginUsers newUser = new LoginUsers(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
			addUser(newUser);
			
			response.getWriter().print("User Added!!");
			
	
		case "loginsubmit":
			request.setAttribute("title", "Login page");
			authenticateUser(request, response);
			break;		
			
		default:
			errorPage(request, response);
			break;
			
		}
	}
	
	private void addUser(LoginUsers newUser) {
		new LoginUsersModel().addUser(dataSource, newUser);
		return;
	}
		
	private void authenticateUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		boolean isUser = new LoginUsersModel().getUserDetails(dataSource, email, password);	
		
		if(isUser) {
			request.getSession().invalidate();
			
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			
			newSession.setAttribute("username", email);
			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	

}
