<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Current Balance</title>
</head>
<body>
Remaing balance after fund:
<%
String balance =  (String) request.getAttribute("balanceRemained");
out.print(balance);
%>
</body>
</html>