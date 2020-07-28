<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="divya.entity.Transactions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Transactions</title>
</head>
<body>
	
	<%
		int balance = 0;
		balance = (int) request.getSession().getAttribute("balance");
	%>
	<p><font color="red">${successMessage}</font></p>
	<strong>List Transactions</strong>
	<hr>
	<table border="1">
	<thead>
	<th>Transaction Amount</th>
	<th>Transaction Type</th>
	<th>Transaction Date</th>
	</thead>
	
	<%
	List<Transactions> listUsers = (List)request.getAttribute("listTransactions");
	java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	for(int i=0;i<listUsers.size();i++) {
		out.print("<tr>");
		out.print("<td>" +listUsers.get(i).getTransc_amt() + "</td>");
		out.print("<td>" +listUsers.get(i).getTransc_type()+ "</td>");
		out.print("<td>" +sdf.format(listUsers.get(i).getTransc_date()) + "</td>");
		out.print("</tr>");
		
	}
	out.print("<tr>");
	out.print("<td>" + "</td>");
	out.print("<td>" + "Total Balance:" +"</td>");
	out.print("<td>" + balance +"</td>");
	out.print("</tr>");
	
	%>
		
	</table>
</body>
</html>