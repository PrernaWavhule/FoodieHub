<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.prerna.model.Restaurant, com.prerna.model.Cart, com.prerna.model.CartItem"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cart | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/navfoot.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="CSS/cart.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<!-- Cart start's here -->
	<section class="cart-container">
	<h2>Your Cart</h2>
	
	<div class="cart">
		

		<%
			Cart userCart = (Cart) session.getAttribute("cart");
			Integer currentRestaurnatId = (Integer) session.getAttribute("restaurantId");
	
			if (userCart != null && !userCart.getItem().isEmpty()) {
				for (CartItem item : userCart.getItem().values()) {
		%>
		<div class="cartCard">
			<p class="itemName">Name : <%=item.getName()%></p>
			<p class="itemPrice">Price : <%=item.getPrice()%></p>
			<p class="itemTotalQuentity">Total : <%=item.getTotalPrice()%>
			<div class="btn">
				<form action="Cart" method="post" style="display: inline;">
					<input type="hidden" name="itemid" value="<%=item.getId()%>">
					<input type="hidden" name="quantity" value="<%=item.getQuantity() + 1%>"> 
					<input type="hidden" name="action" value="update"> 
					<input type="hidden" name="RestaurantId" value="<%=session.getAttribute("RestaurantId")%>">
					<button type="submit">
						<i class="fa-solid fa-circle-plus"></i>
					</button>
				</form>

				<p><%=item.getQuantity()%></p>

				<form action="Cart" method="post" style="display: inline;">
					<input type="hidden" name="itemid" value="<%=item.getId()%>">
					<input type="hidden" name="quantity" value="<%=item.getQuantity() - 1%>"> 
					<input type="hidden" name="action" value="update"> 
					<input type="hidden" name="RestaurantId" value="<%=session.getAttribute("RestaurantId")%>">
					<button type="submit">
						<i class="fa-solid fa-circle-minus"></i>
					</button>
				</form>

			</div>

			<form action="Cart" method="post">
				<input type="hidden" name="itemid" value="<%=item.getId()%>">
				<input type="hidden" name="RestaurantId" value="<%=session.getAttribute("RestaurantId")%>"> 
				<input type="hidden" name="action" value="remove">
				<button class="remove"><i class="fa-solid fa-trash-can"></i></button>
			</form>

		</div>

		<%
			}
		%>

		<p class="total">TotalAmount : <%=userCart.getTotal()%>
		
	</div>
	
	<div class="links">
		<a href="Menu?RestaurantId=<%=session.getAttribute("RestaurantId")%>"><button>Add More Item</button></a> 
		<a href="checkout.jsp"><button>Proceed to Checkout</button></a>
		<form action="ClearCart" method="post">	
			<button type="submit">Clear All</button>	
		</form>
	</div>
	
	

	<%
		} else if (userCart == null || userCart.getItem().isEmpty()) {
	%>

	<img src="images/empty_cart.jpg" alt="cart" width="300px">

	<div class="links">
		<a href="Home"><button>Add Item</button></a>
	</div>

	<%
		}
	%>
	</section>
	<!-- Cart end's here -->
	
	<%@ include file="footer.jsp"%>

</body>
</html>
