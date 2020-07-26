<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Catch Tag</title>
</head>
<body>
<c:catch var="exception">
<% int x = 10/0; %>
</c:catch>
${exception}
<br/>

${exception.message}
<br/>

Testing.....
</body>
</html>