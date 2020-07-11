<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Foreach and If in xml</title>
</head>
<body>
	<c:import url="Users.xml" var="XMLFile" />
	<x:parse xml="${XMLFile }" var="XMLDoc" />

	<table border = 1> 
	<x:forEach select="$XMLDoc/Users/User"> 
	<tr>
		<x:if select="age > 25">
		
		<td> <x:out select="name" /> </td>
		
		<td> <x:out select="gender" /> </td>
		
		<td> <x:out select="age" /> </td>
		
		</x:if>
	</tr>
	</x:forEach>
	</table>
</body>
</html>