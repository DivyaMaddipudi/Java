<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Property</title>
</head>
<body>
<jsp:useBean id="user" class="org.divya.beans.User" scope="session"></jsp:useBean>
<form action="getSessionProperty.jsp" method="post">
First Name: <input type="text" name="firstName" value='<jsp:getProperty property="firstName" name="user"/>'required><br>
Last Name: <input type="text" name="lastName" value='<jsp:getProperty property="lastName" name="user"/>'required><br>
<input type="submit" value="submit">
</form>
</body>
</html>