<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.prerna.model.Orders"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Order History | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/navfoot.css">
<link rel="stylesheet" href="CSS/orderhistory.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet"href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<!-- Order History Section -->
	<section class="order-history">
    	
		<%
	    	List<Orders> orderList = (List<Orders>)request.getAttribute("orderList");
		
	    	if(orderList == null || orderList.isEmpty()){
    	%>

		<h2>No Orders Found</h2>
		<img src="images/noorder.jpeg" alt="no-order">

		<% 
    		}else{
    	%>
    		<h2>My Order History</h2>
    	<% 
    			for(Orders o :orderList){	
    	%>

		<div class="order-card">
			<div class="order-header">
				<h3>Order #<%=o.getOrderId() %></h3>
				<span class="status delivered"><%=o.getOrderStatus() %></span>
			</div>
			<p><strong>Restaurant: </strong><%=o.getRestaurantName() %></p>
			<p><strong>Date: </strong><%= new java.text.SimpleDateFormat("dd MMM yyyy, hh:mm a").format(o.getOrderDate()) %></p>
			<p><strong>Total: </strong> ₹<%= o.getTotalAmount() %></p>
			<a href="OrderItem?OrderId=<%= o.getOrderId()%>"><button>View Details</button></a>
		</div>

		<%
	    		}
	    	}
	    %>

	</section>
	<%@ include file="footer.jsp"%>
</body>
</html>
