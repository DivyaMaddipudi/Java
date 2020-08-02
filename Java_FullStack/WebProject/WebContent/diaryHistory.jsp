<%@include file="/include/header.jsp" %>
<%@ page import="java.util.List"%>
<%@ page import="entity.Diary"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>History</title>
</head>
<body>
	<div class="main">
        <section class="signup">
            <!-- <img src="images/signup-bg.jpg" alt=""> -->
            <div class="container">
                <div class="signup-content">
                <h1>	History ! </h1>
                	<table width="500" border="1">
					<%
						List<Diary> diaryHistory = (List<Diary>) request.getAttribute("diaryHistory");
						
						
						out.print("<tr>");
						out.print("<th>"+ "Date" +"</td>");
						out.print("<th>"+ "Content" +"</td>");
						out.print("</tr>");
						
						for(int i=0;i<diaryHistory.size();i++) {
						out.print("<tr>");
						out.print("<td>" +diaryHistory.get(i).getDate() + "</td>");
						out.print("<td>" +diaryHistory.get(i).getContent()+ "</td>");
						out.print("</tr>");
						
						
					}
					%>
					</table>
                	<p> Click here to return to <a href="welcome.jsp">Home Page</a> </p>
                </div>
            </div>
        </section>
    </div>

</body>
</html>
<%@include file="/include/footer.jsp" %>
