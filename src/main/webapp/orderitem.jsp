<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.prerna.model.OrderItem,com.prerna.model.Orders"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order Details | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/navfoot.css">
<link rel="stylesheet" href="CSS/orderitem.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
</head>
<body>

	<%@ include file="navbar.jsp" %>

	<div class="container">
		<h2>Order Details</h2>

		<%
			Orders o = (Orders)request.getAttribute("order");
		%>

		<div class="order-info">
			<p><strong>Order ID: <%= o.getOrderId() %></strong></p>
			<p><strong>Restaurant: <%= o.getRestaurantName() %></strong></p>
			<p><strong>Date: <%= new java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a").format(o.getOrderDate()) %></strong></p>
			<p><strong>Status: <%= o.getOrderStatus() %></strong></p>
		</div>

		<table>
			<thead>
				<tr>
					<th>Item</th>
					<th>Qty</th>
					<th>Price</th>
					<th>Subtotal</th>
				</tr>
			</thead>
			<tbody>
		<%
	      	List<OrderItem> orderItemList = (List<OrderItem>)request.getAttribute("orderItemList");
 
      		for(OrderItem ot : orderItemList){
      	%>
				<tr>
					<td><%= ot.getItemName() %></td>
					<td><%= ot.getQuantity() %></td>
					<td>₹<%= ot.getPrice() %></td>
					<td>₹<%= ot.getTotalAmount() %></td>
				</tr>

		<%
      			}
        %>
			</tbody>
		</table>

		<div class="total">Total: ₹<%= o.getTotalAmount() %></div>
		<a href="OrderHistory" class="back-btn">← Back to Orders</a>
	</div>

</body>
</html>
