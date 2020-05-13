<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
<p> Already Read Books are:</p>
<ol>
	<C:forEach items="${books}" var="book">
	<li>
	${book.name}
	</li>
	</C:forEach>
</ol>
</body>
</html>