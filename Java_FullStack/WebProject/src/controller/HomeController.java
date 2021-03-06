package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

	@Resource(name = "jdbc/project")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		action = action.toLowerCase();

		switch (action) {
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
	private void checkPassword(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");

		if (password.equals(re_password) && (!isMailIdExist(email))) {
			LoginUsers newUser = new LoginUsers(request.getParameter("name"), email, password);
			addUser(newUser);
			request.setAttribute("successMessage", "Now you can login to the account...");
			request.setAttribute("title", "Login Page");
			request.getRequestDispatcher("login.jsp").forward(request, response);

		} else {

			request.setAttribute("errorMessage", "User Exists...! or Password must be same...!");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

	}

//adds user to the db
	private void addUser(LoginUsers newUser) {
		new LoginUsersModel().addUser(dataSource, newUser);
		return;
	}

//check whether mail id exist or not in signup page
	private boolean isMailIdExist(String email) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap = new LoginUsersModel().listUser(dataSource);

		boolean isMailExist = false;
		if (userMap.containsKey(email)) {
			isMailExist = true;
		} else {
			isMailExist = false;
		}
		return isMailExist;
	}

//authenticating logging user
	private void authenticateLoginUser(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		int userId = getUsersId(email);

		if (isExistingUser(email, password)) {

			request.getSession().invalidate();

			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);

			newSession.setAttribute("email", email);
			newSession.setAttribute("userId", userId);
			
			request.setAttribute("successMessage", "Invalid email_Id or password");
			request.setAttribute("title", "Welcome");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		} else {
			request.setAttribute("successMessage", "Invalid email_Id or password");
			request.setAttribute("title", "Login Page");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

//check user exist or not
	private boolean isExistingUser(String email, String password) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap = new LoginUsersModel().listUser(dataSource);

		boolean isUserExist = false;
		if (userMap.containsKey(email) && userMap.get(email).equals(password)) {
			isUserExist = true;
		} else {
			isUserExist = false;
		}
		return isUserExist;
	}

// return id of the user

	private int getUsersId(String email) {

		HashMap<String, String> userIdMap = new HashMap<>();
		userIdMap = new LoginUsersModel().getUserId(dataSource);

		String userId = userIdMap.get(email);
		int id = Integer.parseInt(userId);

		return id;

	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
}
