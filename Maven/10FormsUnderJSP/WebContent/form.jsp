<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Demo</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/Controller" method="POST">
	Name: <input type="text" name="name" required><br>
	Gender: <input type="radio" name="gender" value="Male" checked="checked">Male
			<input type="radio" name="gender" value="Female">Female<br>
	Languages Known: <input type="checkbox" name="language" value="English">English
					 <input type="checkbox" name="language" value="German">German
					 <input type="checkbox" name="language" value="French">French<br>
					 
	Country: <select name="country">
			 <option value="India">India</option>
			 <option value="Usa">USA</option>
			 <option value="France">France</option>
			 <option value="Canada">Canada</option>
			 <option value="Australia">Australia</option>
			 </select> <br>
			 <input type="submit" value="submit">
</form>
</body>
</html>