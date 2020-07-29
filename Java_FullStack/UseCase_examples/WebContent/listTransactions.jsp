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
	
	<p><font color="red">${successMessage}</font></p>
	<strong>List Of Transactions</strong>
	<hr>
	<table border="1">
	<thead>
	<th>Transaction Amount</th>
	<th>Transaction Type</th>
	<th>Transaction Date</th>
	</thead>
	
	<%
	List<Transactions> listTransactions = (List)request.getAttribute("listTransactions");
	String balance = (String) request.getAttribute("currentbalance");
	out.print(balance);
	if(listTransactions.size() > 5) {
	for(int i=0;i<5;i++) {
		out.print("<tr>");
		out.print("<td>" +listTransactions.get(i).getTransc_amt() + "</td>");
		out.print("<td>" +listTransactions.get(i).getTransc_type()+ "</td>");
		out.print("<td>" +listTransactions.get(i).getTransc_date() + "</td>");
		out.print("</tr>");
		
	}
	out.print("<tr>");
	out.print("<td>" + "</td>");
	out.print("<td>" + "Total Balance:" +"</td>");
	out.print("<td>" + balance +"</td>");
	out.print("</tr>");
	} else {
		for(int i=0;i<listTransactions.size();i++) {
			out.print("<tr>");
			out.print("<td>" +listTransactions.get(i).getTransc_amt() + "</td>");
			out.print("<td>" +listTransactions.get(i).getTransc_type()+ "</td>");
			out.print("<td>" +listTransactions.get(i).getTransc_date() + "</td>");
			out.print("</tr>");
			
		}
		out.print("<tr>");
		out.print("<td>" + "</td>");
		out.print("<td>" + "Total Balance:" +"</td>");
		out.print("<td>" + balance +"</td>");
		out.print("</tr>");
	}
	
	%>
		
	</table>
</body>
</html>