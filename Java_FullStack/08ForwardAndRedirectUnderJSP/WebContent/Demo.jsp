<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Demo</title>
</head>
<body>
It's from the original page
<%--  <jsp:forward page="Forward.jsp"></jsp:forward>  --%>
<%
	request.getRequestDispatcher("Forward.jsp").forward(request, response);
	//response.sendRedirect("Redirect.jsp");
%>
</body>
</html>