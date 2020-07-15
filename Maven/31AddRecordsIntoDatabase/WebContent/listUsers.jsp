<%@include file="include/header.jsp"%>
<%@ page import="java.util.List" %>
<%@ page import="org.divya.entity.User" %>

<div class="container mtb">
	<div class="row">
		<div class="col-lg-4 col-lg-offset-1">
			<h1>List Users</h1>
			<hr>
			<table border="1">
			<thead>
			<th>User ID </th>
			<th> Username </th>
			<th> Email </th>
			<th> Operation </th>
			</thead>
			<%
			List<User> listUsers = (List)request.getAttribute("listUser");
			String updateURL;
			String deleteURL;
			
			for(int i=0;i<listUsers.size();i++) {
				out.print("<tr>");
				
				out.print("<td>" + listUsers.get(i).getUsers_id() + "</td>");
				out.print("<td>" + listUsers.get(i).getUsername() + "</td>");
				out.print("<td>" + listUsers.get(i).getEmail() + "</td>");
				
				updateURL = request.getContextPath()+"/operation?page=updateUser" +
							"&usersId=" + listUsers.get(i).getUsers_id() +
							"&username=" +listUsers.get(i).getUsername() +
							"&email=" + listUsers.get(i).getEmail();
				
				deleteURL = request.getContextPath()+"/operation?page=deleteUser" +
						"&usersId=" + listUsers.get(i).getUsers_id();
				
				out.print("<td><a href=" +updateURL +"> Update</a> | <a href=" +deleteURL +"> Delete</a></td>");
				
				out.print("</tr>");
			}
			
			%>
			</table>
			
		</div>
	</div>
</div>
<%@include file="include/footer.jsp"%>