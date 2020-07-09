<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Member Area</title>
</head>
<body>
	<%
		String username = null, sessionID = null;

		username = request.getSession().getAttribute("username").toString();
		sessionID = request.getSession().getId();
	%>
	Username:
	<%=username%><br /> Current session:
	<%=sessionID%>
	<br /> Member Area!!

	<form action="<%=request.getContextPath()%>/MemberAreaController" method="get">
		<input type="hidden" name="action" value="destroy"> 
		<input type="submit" value="logout">
	</form>
</body>
</html>