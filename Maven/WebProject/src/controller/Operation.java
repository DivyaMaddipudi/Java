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
		
	}

   	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   		String action = request.getParameter("diaryForm");
		action = action.toLowerCase();
		
		switch(action) {
		case "savediary":	
			String date1 = request.getParameter("start");	
	        java.sql.Date sDate = toSqlDate(date1);
	        
			Diary newDiaryContent = new Diary(sDate, request.getParameter("content"));
			addDiaryContent(newDiaryContent);
			
			request.setAttribute("title", "Diary saved");
			request.getRequestDispatcher("diarySaved.jsp").forward(request, response);
			
			break;
			
			
		default:
			errorPage(request, response);
			break;

		}
	}
   	private void addDiaryContent(Diary newDiaryContent) {
		new DiaryModel().addDiaryContent(dataSource, newDiaryContent);
		return;
	}
   	
	private java.sql.Date toSqlDate(String date1) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	    Date date = null;
	  
	    try {
	    	date = dateFormat.parse(date1);
	    } catch (ParseException e) {
            e.printStackTrace();
        }

        java.sql.Date sDate = new java.sql.Date(date.getTime());
        
		return sDate;

	}

	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}


}
