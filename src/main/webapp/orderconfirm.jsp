<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="com.prerna.model.Users" %>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Confirmed | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="CSS/orderconfirm.css">
</head>
<body>

	<%
		Users user = (Users)request.getSession().getAttribute("user");
	%>

	<img src="images/Online Delivery Service.gif" alt="Order Confirmed">
	<h2>🎉 Your Order is Confirmed!</h2>
	<p>
		Thank you <i><%= user.getName() %></i> for ordering with <strong>FoodieHub</strong>.<br>
		Our delivery partner will reach you soon!
	</p>
	<a href="Home" class="btn">Back to Home</a>

</body>
</html>
