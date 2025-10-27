<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.prerna.model.Restaurant"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/navfoot.css">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" />
</head>
<body>

	<%@ include file="navbar.jsp"%>

	<section id="restaurant">


		<div class="page-title">

			<h2 id="resto-title">Restaurant For You</h2>

		</div>
		
		<%@ include file="search.jsp"%>

		<div id="resto-container">

			<%
				List<Restaurant> allResto = (List<Restaurant>) request.getAttribute("allRestaurant");
				if (allResto != null && !allResto.isEmpty()) {
	
					for (Restaurant r : allResto) {
			%>
			<div class="resto-card">
				<a href="Menu?RestaurantId=<%=r.getRestaurantId()%>">
					<div class="image-box">
						<img src="<%=r.getImagePath()%>" alt="resto-img">
					</div>

					<div class="card-info">
						<h3 class="name"><%=r.getName()%></h3>
						<p class="ratings"><i class="fa-solid fa-star"></i> <%=r.getRating()%></p>
						<p class="time"><i class="fa-solid fa-stopwatch"></i> <%=r.getDeliveryTime()%></p>
						<p class="status">🟢 <%=r.getAvailabilityStatus()%></p>
						<p class="cuisine"><i class="fa-solid fa-utensils"></i> <%=r.getCuisine()%></p>
					</div>
				</a>
			</div>
			<%
					}

				}
			%>


		</div>
	</section>

	<%@ include file="footer.jsp"%>

</body>
</html>