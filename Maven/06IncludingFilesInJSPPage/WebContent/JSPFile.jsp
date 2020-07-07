<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Include files in JSP</title>
</head>
<body>

<%--displaying file content(static content) --%>
<%@ include file="file.txt" %>
<br>
<%-- or (for adding dynamic content) --%>
<jsp:include page="file2.txt"></jsp:include>

</body>
</html>