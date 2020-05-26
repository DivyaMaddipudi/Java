package com.foodcart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/FoodCart")

public class FoodCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FoodCart() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get data from model (db)
		
		//redirect to a different page (view)
		
		RequestDispatcher dispatcher =  request.getRequestDispatcher("WEB-INF/views/show-food.jsp");
		dispatcher.forward(request, response);
		
	}


}
