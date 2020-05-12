<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Example Project</title>
</head>
<body>
<form action="/login" method = "post">
	<center><p>${errorMessage1}</p></center>
	<center><p>${errorMessage2}</p></center>
	First Name: <input type="text" name="fname"/>
	<br>
	<br>
	Last Name: <input type="text" name="lname"/>
	<br>
	<br>
  	Password: <input type="password" name="password"/>
  	<br>
	<br>
  <center><input type="submit" value="login"/></center>
</form> 

</body>
</html>