<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fund Transfer</title>
</head>
<body>
<%
		String username = null, customerId = null;

		username = request.getSession().getAttribute("username").toString();
		customerId = request.getSession().getAttribute("cusId").toString();
%>

Username: <%=username%><br />
cus_id: <%=customerId %>


	<form action="${pageContext.request.contextPath}/operation" method="post">
		<p><font color="red">${errorMessage}</font></p>
		Amount: <input type="number" name="transferAmount" placeholder="transferAmount" required="required"> 
		<br/>
		<label for="transactionType">Transaction type:</label>
		 <select name="type" required="required">
			<option value="credit">Credit</option>
			<option value="debit">Debit</option>
		</select>
		<br/>
		
		<input type="hidden" name="action" value="transferFund">
		<input type="hidden" name="cusId" value="<%= customerId %>">
		
		<input type="submit" name="transfer" id="transfer" value="Transfer"/>
	</form>

</body>
</html>