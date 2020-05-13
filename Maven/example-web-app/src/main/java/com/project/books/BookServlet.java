package com.project.books;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns="/readbook")
public class BookServlet extends HttpServlet {
	
		
	  BookService bookService = new BookService();
	  
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  
		  
		  //request.setAttribute("name", request.getParameter("name"));
		  //request.setAttribute("password", request.getParameter("password"));
		  
		  request.setAttribute("books", bookService.returnBooks());
		  request.getRequestDispatcher("/WEB-INF/views/book.jsp").forward(request, response);
	  }
	  

}
