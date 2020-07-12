package org.divya.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.divya.entity.User;
import org.divya.model.UsersModel;

/**
 * Servlet implementation class HomeController
 */
@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	@Resource(name = "jdbc/project")
	private DataSource dataSource;
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		page = page.toLowerCase();
		
		switch(page) {
		case "home":
			request.setAttribute("title","home");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		case "about":
			request.setAttribute("title","about");
			request.getRequestDispatcher("aboutUs.jsp").forward(request, response);
			break;
		case "users":
			List<User> listUser = new ArrayList<>();
			listUser = new UsersModel().listUser(dataSource);
			request.setAttribute("listUser", listUser);
			request.setAttribute("title","list users");
			request.getRequestDispatcher("users.jsp").forward(request, response);
			break;
		default:
			request.setAttribute("title","error page");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
		
	}

}
