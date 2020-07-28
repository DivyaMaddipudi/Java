package divya.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import divya.entity.Transactions;
import divya.model.TransactionsModel;

/**
 * Servlet implementation class Operation
 */
@WebServlet("/operation")
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	final static int INITIAL_AMT = 1000;
 
	@Resource(name="jdbc/accounts")
	private DataSource dataSource;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		page = page.toLowerCase();
		
		switch(page) {
		case "history":
			printTransactions(request, response);
			break;	
		case "balance":
			printBalance(request, response);
		case "fundtransfer":
			transfer(request, response);
		default:
			errorPage(request, response);
			break;
		}
	}

	private void printBalance(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void transfer(HttpServletRequest request, HttpServletResponse response) {
		
		
	}

	private void printTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cusId = request.getParameter("cusId");
		int customerId = Integer.parseInt(cusId);
		System.out.println(customerId);
		
		List<Transactions> listIdWiseTransactions = new ArrayList<>();
		
		listIdWiseTransactions = new TransactionsModel().listTransactionsById(customerId, dataSource);
		request.setAttribute("listTransactions", listIdWiseTransactions);
		request.getRequestDispatcher("listTransactions.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}


}
