<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get Property</title>
</head>
<body>
<jsp:useBean id="user" class="org.divya.beans.User" scope="request"></jsp:useBean>


First Name: <jsp:getProperty property="firstName" name="user"/>  
<%-- name is id value in the above line  --%>
Last Name: <jsp:getProperty property="lastName" name="user"/>

</body>
</html>