<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello JSP</title>
</head>
<body>
<h1>JSP Expression</h1>


<%! public int x = 10; %>
<%=x %>

<%= new java.util.Date() %>

</body>
</html>