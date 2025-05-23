<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Edit Product</h2>
<form action="ProductServlet" method="post">
  <input type="hidden" name="product_id" value="<%= request.getAttribute("product_id") != null ? request.getAttribute("product_id") : "" %>"/>

  Name: <input type="text" name="name" value="<%= request.getAttribute("name") != null ? request.getAttribute("name") : "" %>" /> <br/>

  Description: <input type="text" name="description" value="<%= request.getAttribute("description") != null ? request.getAttribute("description") : "" %>" /> <br/>

  Price: <input type="number" step="0.01" name="price" value="<%= request.getAttribute("price") != null ? request.getAttribute("price") : "" %>" required /> <br/>

  Quantity: <input type="number" name="quantity" value="<%= request.getAttribute("quantity") != null ? request.getAttribute("quantity") : "" %>" required/> <br/>

  <input type="submit" value="Save" /> <br/>

  <a href="ProductServlet">Back to Product List</a>
</form>


</body>
</html>