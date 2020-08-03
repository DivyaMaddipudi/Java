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
import javax.sql.DataSource;

import entity.Diary;
import model.DiaryModel;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/Operation")
public class Operation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/project")
	private DataSource dataSource;

       
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		page = page.toLowerCase();

		switch (page) {
		case "history":
			viewHistory(request, response);
			break;
		case "deletecontent":
			deleteContent(request, response);
			break;
		case "logout":
			request.getSession().invalidate();
			request.setAttribute("title", "Login Page");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		default:
			errorPage(request, response);
			break;

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String action = request.getParameter("diaryForm");
		action = action.toLowerCase();
		
		switch(action) {
		
		case "savediary":	
	        int usersId = Integer.parseInt(request.getParameter("userId"));

			Diary newDiaryContent = new Diary(usersId, request.getParameter("content"));
			addDiaryContent(newDiaryContent);
			
			request.setAttribute("title", "Saved Content");
			request.getRequestDispatcher("diarySaved.jsp").forward(request, response);
			
			break;	
			
		default:
			errorPage(request, response);
			break;

		}
	}
	
   	
	private void deleteContent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		System.out.println(userId);
		
		deleteDiaryContent(userId);
		
		viewHistory(request, response);
		return;
		
	}
   	
	private void deleteDiaryContent(int userId) {
		new DiaryModel().deleteDiaryContent(userId, dataSource);
		return;
	}

	private void viewHistory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int userId = Integer.parseInt(request.getParameter("userId"));
		
		request.setAttribute("userId", userId);

		List<Diary> diaryHistory = new ArrayList<>();
		
		diaryHistory = new DiaryModel().printHistory(dataSource, userId);
		
		request.setAttribute("title", "History");
		request.setAttribute("diaryHistory", diaryHistory);
		request.getRequestDispatcher("diaryHistory.jsp").forward(request, response);
		
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
