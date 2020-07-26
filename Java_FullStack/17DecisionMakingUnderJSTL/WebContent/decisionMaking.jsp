<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Decision Making Under JSTL</title>
</head>
<body>
<%------------ Decision Tag (no else is JSTL) -----------%>
<%--- 
	<c:if test="${param.name == 'Satya'}">
		Hello Satya
	</c:if>
		Hello User
--%>
	
<%------------ CHOOSE, When Tags -----------%>

<c:choose>
	<c:when test="${param.lang == 'java' }">
	Learning Java
	</c:when>
	
	<c:when test="${param.lang == 'PHP' }">
	Learning PHP
	</c:when>
	
	<c:otherwise>
	Learning Something good!
	</c:otherwise>
	
</c:choose>

</body>
</html>