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


@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/project")
	private DataSource dataSource;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
		
		case "listusers":
			listUsers(request, response);
			break;
		case "addusers":
			addUserFormLoader(request, response);
			break;
		case "updateuser":
			updateUserFormLoader(request, response);
			break;
		case "deleteuser":
			String userId = request.getParameter("usersId");
			deleteUser(Integer.parseInt(userId));
			listUsers(request, response);
			break;
		default:
			errorPage(request, response);
			break;
			
		}
		
	}
	
	
	private void deleteUser(int UsersId) {
		new UsersModel().deleteUser(dataSource, UsersId);
		return;
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("form");
		operation = operation.toLowerCase();
		
		switch(operation) {
		case "adduseroperation": 
		User newUser = new User(request.getParameter("username"), request.getParameter("email"));
		addUserOperation(newUser);
		listUsers(request, response);
			break;
		case "updateuseroperation":
			User updatedUser = new User(Integer.parseInt(request.getParameter("usersId")), request.getParameter("username"), request.getParameter("email"));
			updateUserOperation(dataSource, updatedUser);
			listUsers(request, response);
			break;
		default:
			errorPage(request, response);
			break;
		}
		
		
	}
	
	private void updateUserOperation(DataSource dataSource2, User updatedUser) {
		new UsersModel().updateUser(dataSource, updatedUser);
		return;
		
	}

	public void addUserOperation(User newUser) {
		new UsersModel().addUser(dataSource, newUser);
		return;
		
	}
	
	public void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> listUser = new ArrayList<>();
		listUser = new UsersModel().listUsers(dataSource);
		
		request.setAttribute("listUser", listUser);
		request.setAttribute("title", "list of users");
		request.getRequestDispatcher("listUsers.jsp").forward(request, response);
		
	}
	private void updateUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setAttribute("title", "update user");
		request.getRequestDispatcher("updateUser.jsp").forward(request, response);
		
	}

	
	public void addUserFormLoader(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "add users");
		request.getRequestDispatcher("addUsers.jsp").forward(request, response);
	}
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "Error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);

	}
}
