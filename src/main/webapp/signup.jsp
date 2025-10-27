<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Signup | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/auth.css">
</head>
<body>

	<div class="auth-container">
		<div class="auth-box">
			<h2>Sign Up</h2>
			<form action="Signup" method="post">
				<div class="input-group">
					<label>Full Name</label> 
					<input type="text" placeholder="Enter your name" name="name" required>
				</div>
				
				<div class="input-group">
					<label>Email</label> 
					<input type="email" placeholder="Enter your email" name="email" required>
				</div>

				<div class="input-group">
					<label>Password</label> 
					<input type="password" placeholder="Create password" name="password" required>
				</div>

				<div class="input-group">
					<label>Phone Number</label> 
					<input type="tel" placeholder="Enter your phone number" name="phonenumber" required>
				</div>

				<div class="input-group">
					<label>Address</label> 
					<input type="text" placeholder="Enter your address" name="address" required>
				</div>

				<div class="input-group">
					<label>Role</label> <select name="role" required>
						<option value="">--Select Role--</option>
						<option value="ADMIN">Admin</option>
						<option value="CUSTOMER">Customer</option>
						<option value="DELIVERY_PARTNER">Delivery Partner</option>
						<option value="MANAGER">Manager</option>
					</select>
				</div>


				<button type="submit" class="btn">Sign Up</button>
			</form>
			<p class="switch">
				Already have an account? <a href="login.jsp">Login</a>
			</p>
		</div>
	</div>

</body>
</html>
