<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL length function</title>
</head>
<body>
<%
String[] names = {"satya", "riya", "veenai", "ram"};
%>
<c:set var="namesArray" value= "<%=names %>" />
${fn:length(namesArray) }
</body>
</html>