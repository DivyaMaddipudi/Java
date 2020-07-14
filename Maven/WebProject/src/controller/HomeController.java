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
			checkPassword(request, response);
			break;
			
		case "loginsubmit":
			request.setAttribute("title", "Login page");
			authenticateLoginUser(request, response);
			break;		
			
		default:
			errorPage(request, response);
			break;
			
		}
	}
	
	// checks password and re_password are same or not!
	private void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		
		if(password.equals(re_password)) {
			LoginUsers newUser = new LoginUsers(request.getParameter("name"), email, password);
			addUser(newUser);
			request.setAttribute("successMessage", "Now you can login to the account...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			
			request.setAttribute("errorMessage", "Password must be same...!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
	
	//adds user to the db
	private void addUser(LoginUsers newUser) {
			new LoginUsersModel().addUser(dataSource, newUser);
			return;
		}
	
	private void authenticateLoginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
			request.setAttribute("successMessage", "Invalid email_Id or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}
	}
	
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	

}
