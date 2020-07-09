package org.divya.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch(action) {
		case "login":
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		default:
			break;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		switch(action) {
		case "loginSubmit":
			authenticate(request, response);
			break;
		default:
			break;
		}
	}
	
	public void authenticate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		String action = request.getParameter("action");
		response.getWriter().print(action);
		
		if(userName.equals("Satya") && password.equals("test")) {
			
			request.getSession().invalidate();
			
			HttpSession newSession = request.getSession(true);
			newSession.setMaxInactiveInterval(300);
			newSession.setAttribute("userName", userName);
			
			response.sendRedirect(request.getContextPath()+"/MemberAreaController?action=memberArea");
		} else {
			response.sendRedirect(request.getContextPath()+"/Controller?action=login");
		}
	}

}
