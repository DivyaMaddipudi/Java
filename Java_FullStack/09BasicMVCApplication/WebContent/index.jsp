<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>
Home Page
<br>
<a href="<%=request.getContextPath() %>/Controller?page=login">Login</a>
<br>
<a href="<%=request.getContextPath() %>/Controller?page=signup">SignUp</a>
<br>
<a href="<%=request.getContextPath() %>/Controller?page=about">About</a>
</body>
</html>