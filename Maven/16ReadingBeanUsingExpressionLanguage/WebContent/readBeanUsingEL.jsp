<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reading bean using Expression Language</title>
</head>
<body>
<jsp:useBean id="user" class="org.divya.beans.User" scope="page"></jsp:useBean>

${user.firstName}
<c:out value="${user.firstName}"></c:out>
${user.getLastName()}
</body>
</html>