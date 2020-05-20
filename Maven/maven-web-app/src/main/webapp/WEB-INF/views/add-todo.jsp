<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<title>Todo</title>

<style>
	.footer {
		position: absolute;
		bottom: 0;
		width: 100%;
		height: 60px;
		background-color: #f5f5f5;
	}
</style>

</head>
<body>
	
	<nav class="navbar navbar-default">

		<a href="/" class="navbar-brand">Brand</a>

		<ul class="nav navbar-nav">
			<li class="active"><a href="#">Home</a></li>
			<li><a href="/list-todo.do">Todos</a></li>
			<li><a href="http://www.in28minutes.com">In28Minutes</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="/logout.do">Logout</a></li>
		</ul>

	</nav>


	<div class="container">
		Your New Todos:
		<form action="/add-todo.do" method="post">
		<fieldset class="form-group">
			<label>Description <input type = "text" name="todo" class ="form-control"/></label>
		</fieldset>
		<fieldset class="form-group">
			<label>Category <input type = "text" name="category" class ="form-control"/></label>
		</fieldset>
			 <input type="submit" value = "Add" class="btn btn-success"/>
		</form>
		</div>
		
	<footer class="footer">
		<p>footer content</p>
	</footer>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/css/bootstrap.min.css"></script>

</body>
</html>


<!-- Valid User  -> Welcome.jsp -->
<!-- Invalid User -> Login.jst -->