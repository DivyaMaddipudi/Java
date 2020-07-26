<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Property</title>
</head>
<body>
<jsp:useBean id="user" class="org.divya.beans.User" scope="request"></jsp:useBean>

<jsp:setProperty property="firstName" name="user" value="Satya"/>
<jsp:setProperty property="lastName" name="user" value="Divya"/>
Values has been set

<%-- Forwading req object of setPropety to getProperty --%>
<%
request.getRequestDispatcher("getProperty.jsp").forward(request, response);
%>

</body>
</html>