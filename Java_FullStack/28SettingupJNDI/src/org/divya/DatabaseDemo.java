package org.divya;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class DatabaseDemo
 */
@WebServlet("/DatabaseDemo")
public class DatabaseDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Resource(name="jdbc/project")
	private DataSource dataSource;
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	//1. Initialize connection objects
		PrintWriter out = response.getWriter();
		Connection connect = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			connect = dataSource.getConnection();
		
		//2. create sql query
		String query = "select * from users";
		stmt = connect.createStatement();
		
		rs = stmt.executeQuery(query);
		while(rs.next()) {
			out.print("<br>" + rs.getString("email"));
		}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
    }

}
