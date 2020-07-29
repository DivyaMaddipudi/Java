package divya.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
			getBalance(request, response);
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
		
		
		String type = request.getParameter("type");
		int cusId = Integer.parseInt(request.getParameter("cusId"));
		System.out.println(cusId);
		
		int balance = getBalanceById(cusId);
		System.out.println(balance);
		
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
				String updatedBalance = String.valueOf(updateBalance(newBalance));
				
				
				
//				Transactions newTransaction = new Transactions(cusId, transferAmount, type);
//				addTransaction(newTransaction);
//				
				request.setAttribute("balance", updatedBalance);
				request.getRequestDispatcher("transfer.jsp").forward(request, response);

				
				break;
			case "debit":
				balance = balance - transferAmount;
				System.out.println(balance);
				
				Customers newBalance1 = new Customers(cusId, balance);
				String updatedBalance1 = String.valueOf(updateBalance(newBalance1));
				
//				
//				Transactions newTransaction1 = new Transactions(cusId, transferAmount, type);
//				addTransaction(newTransaction1);
//				
				request.setAttribute("balance", updatedBalance1);
				request.getRequestDispatcher("transfer.jsp").forward(request, response);
				break;
			default:
				errorPage(request, response);
				break;
			}
		}


	}

//	private void addTransaction(Transactions newTransaction) {
//
//		new TransactionsModel().addTransaction(newTransaction, dataSource);
//		return;
//	}

	//Void update balance

	private int updateBalance(Customers newBalance) {
		int updatedBalance = new CustomersModel().updateBalance(newBalance, dataSource);
		
		return updatedBalance;

	}

	private void printTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cusId = request.getParameter("cusId");
		int customerId = Integer.parseInt(cusId);

		List<Transactions> listIdWiseTransactions = new ArrayList<>();
		
		String getCurrentBalance = String.valueOf(getBalanceById(customerId));
		listIdWiseTransactions = new TransactionsModel().listTransactionsById(customerId, dataSource);
		request.setAttribute("listTransactions", listIdWiseTransactions);
		request.setAttribute("currentbalance", getCurrentBalance);
		request.getRequestDispatcher("listTransactions.jsp").forward(request, response);

	}

	private void getBalance(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cusId = Integer.parseInt(request.getParameter("cusId"));
		String getBalance = String.valueOf(getBalanceById(cusId));

		System.out.println(getBalance +" remain");
		
		request.setAttribute("balanceRemained", getBalance);
		request.getRequestDispatcher("balance.jsp").forward(request, response);
		
	}
	
	//getting balance 
	private int getBalanceById(int cusId) {
		int balance;
		balance = new CustomersModel().getBalanceById(cusId, dataSource);	
		return balance;
	}
	
	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}


}
