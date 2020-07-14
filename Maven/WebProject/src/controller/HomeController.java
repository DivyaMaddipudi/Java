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
		
		List<LoginUsers> listUsers = new ArrayList<>();
		listUsers = new LoginUsersModel().listUser(dataSource);	
		
		for(int i=0;i<listUsers.size();i++) {
			if(listUsers.get(i).getEmail().contains(email) && listUsers.get(i).getPassword().contains(password)) {
				
				System.out.println("userfound");
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
			} else {
				System.out.println("user notfound");
				request.setAttribute("successMessage", "Invalid email_Id or password");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
	
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}
