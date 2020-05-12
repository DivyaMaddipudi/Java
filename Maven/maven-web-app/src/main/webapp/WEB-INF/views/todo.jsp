<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo</title>
</head>
<body>
<p>Welcome ${name} </p>
<p>Your Todo's are:</p>
<ol>
	
	<C:forEach items="${todos}" var="todo">
	<li>${todo.name} </li>
	</C:forEach>
	
</ol>
</body>
</html>


<!-- Valid User  -> Welcome.jsp -->
<!-- Invalid User -> Login.jst -->