<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL Other tags</title>
</head>
<body>

<c:set var="we" value="org.divya.tags"/>
${fn:startsWith("org.divya.tags", "om") } <br />
${fn:endsWith(we, "tags") } <br />
${fn:contains(we, "Tags") } <br />
${fn:containsIgnoreCase(we, "Tags") } <br/>

<!-- 

Other Functions:

toLowerCase()
toUpperCase()
indexOf()
replace()
subString()
substringBefore()
subStringAfter()

 -->

</body>
</html>