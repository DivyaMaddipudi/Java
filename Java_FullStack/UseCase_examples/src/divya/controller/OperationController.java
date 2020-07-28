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
			//printBalance(request, response);
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
			break;
		}
	}


	private void transferFund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int transferAmount = Integer.parseInt(request.getParameter("transferAmount"));
		int balance = INITIAL_AMT;
		String type = request.getParameter("type");
		int cusId = Integer.parseInt(request.getParameter("cusId"));
		System.out.println(cusId);

		if(balance < transferAmount) {
			// implement if balance is < transfer amount
			request.setAttribute("errorMessage", "Insufficient balance");
			request.getRequestDispatcher("fundTransfer.jsp").forward(request, response);

		} else {
			switch(type) {
			case "credit":
				balance = balance + transferAmount;

				Transactions newTransaction = new Transactions(cusId, transferAmount, type);
				addTransaction(newTransaction);

				updateBalance(cusId, balance);
				request.setAttribute("successMessage", "Money Transfered successfully");
				request.getRequestDispatcher("listTransactions.jsp").forward(request, response);
				break;
			case "debit":
				balance = balance - transferAmount;

				Transactions newTransaction1 = new Transactions(cusId, transferAmount, type);
				addTransaction(newTransaction1);

				updateBalance(cusId, balance);
				request.setAttribute("successMessage", "Money Transfered successfully");
				request.getRequestDispatcher("listTransactions.jsp").forward(request, response);

			}
		}


	}

	private void addTransaction(Transactions newTransaction) {

		new TransactionsModel().addTransaction(dataSource, newTransaction);
		return;
	}

	//Void update balance

	private void updateBalance(int cusId, int newBalance) {
		new CustomersModel().updateBalance(cusId, newBalance, dataSource);
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

	public void errorPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", "error Page");
		request.getRequestDispatcher("error.jsp").forward(request, response);
	}


}
