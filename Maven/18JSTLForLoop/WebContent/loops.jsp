<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL For Loop</title>
</head>
<body>
<%------------- Basic Forloop -----------%>

<c:forEach var="i" begin="0" end="30" step="3">
${i}
<br />
</c:forEach>

<%------------- Forloop for JSP elements -----------%>

<%
String[] names = new String[3];
names[0] ="Satya";
names[1] = "Divya";
names[2] = "Maddipudi";
%>

<c:forEach items="<%=names%>" var="name">
${name}
</c:forEach>

</body>
</html>