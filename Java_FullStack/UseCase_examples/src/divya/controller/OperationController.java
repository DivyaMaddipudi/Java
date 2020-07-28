package divya.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import divya.entity.Customers;
import divya.entity.Transactions;
import divya.model.CustomersModel;
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
			break;
		default:
			errorPage(request, response);
			break;
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		action = action.toLowerCase();

		switch (action) {
		case "transferfund":
			transferFund(request, response);
			break;

		default:
			errorPage(request, response);
			break;
		}
	}


	private void transferFund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));
		int balance = INITIAL_AMT;
		System.out.println(balance);
		String type = request.getParameter("type");
		int cusId = Integer.parseInt(request.getParameter("cusId"));
		System.out.println(cusId);

		String username = request.getParameter("username");
		System.out.println(username);
		
		if(balance < transferAmount) {
			// implement if balance is < transfer amount
			request.setAttribute("errorMessage", "Insufficient balance");
			request.getRequestDispatcher("fundTransfer.jsp").forward(request, response);

		} else {
			switch(type) {
			case "credit":
				balance = balance + transferAmount;
				System.out.println(balance);
				
				Customers newBalance = new Customers(cusId, balance);
				updateBalance(newBalance);
				
				response.sendRedirect(request.getContextPath() + "/operation?page=history&cusId="+cusId);
//				Transactions newTransaction = new Transactions(cusId, transferAmount, type);
//				addTransaction(newTransaction);

				
				request.setAttribute("successMessage", "Money Transfered successfully");
				break;
			case "debit":
				balance = balance - transferAmount;
				System.out.println(balance);
				
				Customers newBalance1 = new Customers(cusId, balance);
				updateBalance(newBalance1);
				
				response.sendRedirect(request.getContextPath() + "/operation?page=history&cusId="+cusId);
//				Transactions newTransaction1 = new Transactions(cusId, transferAmount, type);
//				addTransaction(newTransaction1);


				request.setAttribute("successMessage", "Money Transfered successfully");
				
				break;
			default:
				errorPage(request, response);
				break;
			}
		}


	}

	private void addTransaction(Transactions newTransaction) {

		new TransactionsModel().addTransaction(newTransaction, dataSource);
		return;
	}

	//Void update balance

	private void updateBalance(Customers newBalance) {
		new CustomersModel().updateBalance(newBalance, dataSource);
		
		return;

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

	//getting balance 
	private int getBalance(int cusId) {
		int balance;
		balance = new CustomersModel().getBalanceById(cusId, dataSource);	
		return balance;
	}
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}


}
