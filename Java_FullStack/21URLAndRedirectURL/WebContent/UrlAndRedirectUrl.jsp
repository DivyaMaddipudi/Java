<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Url and Redirect Url</title>
</head>
<body>
<a href="<c:url value="/AnotherPage.jsp"/>">Another Page</a>

<c:redirect url="https://www.google.com/"></c:redirect>
</body>
</html>