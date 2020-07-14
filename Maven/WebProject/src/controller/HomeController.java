package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
		case "signup":
			LoginUsers newUser = new LoginUsers(request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
			addUser(newUser);
			
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			request.setAttribute("title", "welcome");
			break;
		case "savediary":
			
			String date1 = request.getParameter("start");
	        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

		    Date date = null;
		    
		    try {
		    	date = dateFormat.parse(date1);
		    } catch (ParseException e) {
                e.printStackTrace();
            }

			
	        java.sql.Date sDate = new java.sql.Date(date.getTime());

	        
			Diary newDiaryContent = new Diary(sDate, request.getParameter("content"));
			addDiaryContent(newDiaryContent);
			response.sendRedirect(request.getContextPath() + "/home?action=savediary");
			//request.getRequestDispatcher("diarySaved.jsp").forward(request, response);
			
		default:
			errorPage(request, response);
			
		}
	}

	
	private void addUser(LoginUsers newUser) {
		new LoginUsersModel().addUser(dataSource, newUser);
		return;
	}
	
	private void addDiaryContent(Diary newDiaryContent) {
		new DiaryModel().addDiaryContent(dataSource, newDiaryContent);
		return;
	}
	
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}
	

}
