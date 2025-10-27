<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Checkout | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/style.css">
<link rel="stylesheet" href="CSS/checkout.css">
</head>
<body>

	<div class="checkout">
		<h2>Checkout Form</h2>
		<form action="Checkout" method="post">

			<label for="address">Delivery Address</label>
			<textarea id="address" name="address" placeholder="Enter full delivery address" required></textarea>

			<label for="payment">Payment Mode</label> <select id="payment" name="payment" required>
				<option value="">-- Select Payment Mode --</option>
				<option value="CASH">Cash on Delivery</option>
				<option value="CARD">Card Payment</option>
				<option value="UPI">UPI</option>
				<option value="WALLET">Wallet Banking</option>
			</select> <input type="submit" value="Place Order">
		</form>
	</div>

</body>
</html>
































