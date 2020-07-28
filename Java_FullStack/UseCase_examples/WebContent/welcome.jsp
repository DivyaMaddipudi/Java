<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome page</title>
</head>
<body>

		<ul>
          <li><a href="${pageContext.request.contextPath}/operation?page=history">Transactions History</a></li>
          <li><a href="${pageContext.request.contextPath}/operation?page=balance">Balance</a></li>
          <li><a href="${pageContext.request.contextPath}/operation?page=fundtransfer">Fund Transfer</a></li>
          <li><a href="${pageContext.request.contextPath}/operation?page=logout">Logout</a></li>
        </ul>
</body>
</html>