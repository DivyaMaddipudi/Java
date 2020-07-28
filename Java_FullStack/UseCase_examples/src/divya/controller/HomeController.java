package divya.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import divya.entity.Customers;
import divya.model.CustomersModel;




@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/accounts")
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
 	
	private void checkPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		String email = request.getParameter("email");
		
		if(password.equals(re_password) && (!isUsernameExist(username))) {
			Customers newCustomer = new Customers(username, password, email);
			addCustomer(newCustomer);
			request.setAttribute("successMessage", "Now you can login to the account...");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		} else {
			
			request.setAttribute("errorMessage", "User Exists...! or Password must be same...!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
		}
		
	}
	
	private void addCustomer(Customers newCustomer) {
		
			new CustomersModel().addCustomer(dataSource, newCustomer);
			return;
		
	}


	private boolean isUsernameExist(String username) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap = new CustomersModel().listCustomers(dataSource);	
		
		boolean isUsernameExist = false;
		if(userMap.containsKey(username)) {
			isUsernameExist = true;
		} else {
			isUsernameExist = false;
		}
		return isUsernameExist;
	}

	private void authenticateLoginUser(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(isExistingUser(username, password)) {
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
		}else {
			request.setAttribute("successMessage", "Invalid email_Id or password");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}	
	}
	
	//check user exist or not
	private boolean isExistingUser(String username, String password) {
		HashMap<String, String> userMap = new HashMap<>();
		userMap = new CustomersModel().listCustomers(dataSource);	
		
		boolean isUserExist = false;
		if(userMap.containsKey(username) && userMap.get(username).equals(password)) {
				isUserExist = true;
		} else {
			isUserExist = false;
		}
		return isUserExist;
	}
	
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	
	
}
