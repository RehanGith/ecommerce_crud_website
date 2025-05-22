<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product listing</title>
</head>
<body>
<h2>Listing Product</h2>
<%
    ResultSet rs = (ResultSet) request.getAttribute("product");
%>
<table border="2">
<tr>
    <th>Product ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Price</th>
    <th>Quantity</th>
    <th>Actions</th>
</tr>
<% while(rs.next()) { %>
<tr>
    <td><%= rs.getInt("product_id") %></td>
    <td><%= rs.getString("name") %></td>
    <td><%= rs.getString("description") %></td>
    <td><%= rs.getDouble("price") %></td>
    <td><%= rs.getInt("quantity") %></td>
    <td>
        <a href="ProductServlet?action=edit&id=<%= rs.getInt("product_id") %>">Edit</a> |
        <a href="ProductServlet?action=delete&id=<%= rs.getInt("product_id") %>">Delete</a>
    </td>
</tr>
<% } 
rs.close(); %>
</table>

</body>
</html>