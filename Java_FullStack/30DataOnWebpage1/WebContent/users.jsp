<%@include file= "include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="org.divya.entity.User" %>
 
  <section id="hero">
    <div class="hero-container">
      <strong>Users available: </strong>
      <hr/>
      <table border="1">
      <thead>
      <th>User ID</th>
      <th>Username </th>
      <th>email</th>
      </thead>
      
      <%
      List<User> listUser = (List)request.getAttribute("listUser");
      for(int i=0;i<listUser.size();i++) {
    	  out.print("<tr>");
    	  out.print("<td>" + listUser.get(i).getUsers_id()+"</td>");
    	  out.print("<td>" + listUser.get(i).getUsername()+"</td>");
    	  out.print("<td>" + listUser.get(i).getEmail()+"</td>");
    	  out.print("</tr>");
      }
      
      %>
      
      
      </table>
    </div>
  </section>