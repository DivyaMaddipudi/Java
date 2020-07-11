<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSTL I18N</title>
</head>
<body>
View Website in:
<a href="?locale=en_US">English(US)</a>
<a href="?locale=es_AR">Spanish</a>
<a href="?locale=ru_RU">Russian</a>
<a href="?locale=hi_IN">Hindi</a>
<br/>
<br/>
<hr/>
<fmt:setLocale value="${param.locale }"/>
<fmt:bundle basename="i18N/website">
<p><fmt:message key="label.hello">Divya</fmt:message>
<p><fmt:message key="label.welcome"/>
<p><fmt:message key="label.thankyou"/>
</fmt:bundle>
<br/>
Locale: ${param.locale}
</body>
</html>