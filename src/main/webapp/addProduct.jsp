<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Insert / Update Product</h2>
<h2>Insert Product</h2>
<form action="ProductServlet" method="post">
  <input type="hidden" name="product_id" />

  Name: <input type="text" name="name" /> <br/>

  Description: <input type="text" name="description" /> <br/>

  Price: <input type="text" name="price" /> <br/>

  Quantity: <input type="text" name="quantity" /> <br/>

  <input type="submit" value="Save" /> <br/>

  <a href="ProductServlet">Back to Product List</a>
</form>



</body>
</html>