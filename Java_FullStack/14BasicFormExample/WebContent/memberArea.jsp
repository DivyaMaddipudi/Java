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
		String userName=null, sessionID=null;
		
		userName = request.getSession().getAttribute("userName").toString();
		sessionID = request.getSession().getId();	
	%>
	Username: <%=userName %> <br />	
	Current Session: <%=sessionID %> <br />

	Member Area!!
	<form action="<%=request.getContextPath()%>/MemberAreaController" method="get">
		<input type="hidden" name="action" value="destroy">
		<input	type="submit" value="logout">
	</form>
</body>
</html>