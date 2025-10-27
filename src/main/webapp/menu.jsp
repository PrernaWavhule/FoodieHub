<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.prerna.model.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Menu | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/navfoot.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<section id="menu">
		<div class="page-title">
			<h2 id="menu-title">
				<i class="fa-solid fa-utensils"></i> Our Special Menu
			</h2>
		</div>

		<div id="menu-container">

		<%
			List<Menu> menuList = (List<Menu>) request.getAttribute("menuList");
			if (menuList != null && !menuList.isEmpty()) {
				for (Menu m : menuList) {
		%>

			<div class="menu-card">
				<div class="image-box">
					<img src="<%= m.getImagePath() %>" alt="Menu Img">
				</div>
				<div class="menu-info">
					<h3 class="dish-name"><%= m.getItemName() %></h3>
					<p class="dish-rating"><i class="fa-solid fa-star"></i> <%= m.getRating() %></p>
					<p class="dish-price"><i class="fa-solid fa-indian-rupee-sign"></i> <%= m.getPrice() %></p>
					<p class="dish-status">🟢 <%= m.getAvailabilityStatus() %></p>

					<form action="Cart" method="post">
						<input type="hidden" name="itemid" value="<%= m.getMenuId() %>">
						<input type="hidden" name="quantity" value="1" min="1"> 
						<input type="hidden" name="RestaurantId" value="<%= m.getRestaurantId() %>"> 
						<input type="hidden" name="action" value="add">
						<button class="add-to-cart"><i class="fa-solid fa-cart-shopping"></i> Add to Cart</button>
					</form>
				</div>
			</div>

			<%
		  			}	
		  		}else{
		  	%>
				<p>Menu items are unavailable, please go back</p>
			<%
			  	}
			%>

		</div>
	</section>

	<%@ include file="footer.jsp"%>

</body>
</html>