<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
<%
out.println("Name: " + request.getParameter("name"));
out.println("Initial: " + request.getParameter("name2"));
%>
</body>
</html>