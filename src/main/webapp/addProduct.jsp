<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Insert Product</h2>
<form action="ProductServlet" method="post">
  Name: <input type="text" name="name" required> <br>
  Description: <input type="text" name="description"> <br>
  Price: <input type="number" step="0.01" name="price" required> <br>
  Quantity: <input type="number" name="quantity" min="0" required> <br>
  <input type="submit" value="Save">
</form>



</body>
</html>