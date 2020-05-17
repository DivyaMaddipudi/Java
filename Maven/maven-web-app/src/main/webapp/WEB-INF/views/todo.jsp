<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Todo</title>
</head>
<body>
<p>Welcome ${name} </p>
<p>Your Todo's are:</p>
<ol>
	
	<C:forEach items="${todos}" var="todo">
	<li>${todo.name} &nbsp; &nbsp; <a href="\delete-todo.do?todo=${todo.name}">Delete</a></li>
	</C:forEach>
	
</ol>

<form action="/todo.do" method="post">
	<input type = "text" name="todo"/> <input type="submit" value = "Add"/>
</form>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/css/bootstrap.min.css"></script>

</body>
</html>


<!-- Valid User  -> Welcome.jsp -->
<!-- Invalid User -> Login.jst -->