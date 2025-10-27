<%@page import="com.prerna.servlets.LoginServ"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login | FoodieHub</title>
<link rel="shortcut icon" href="images/icons8-restaurant-32.png" type="image/x-icon">
<link rel="stylesheet" href="CSS/auth.css">
</head>
<body>

	<div class="auth-container">
		<div class="auth-box">
			<h2>Login</h2>
			<form action="Login" method="post">
				<div class="input-group">
					<label>Email</label> 
					<input type="email" placeholder="Enter your email" name="email" required>
				</div>
				<div class="input-group">
					<label>Password</label> 
					<input type="password" placeholder="Enter your password" name="password" required>
				</div>
				<button type="submit" class="btn">Login</button>
			</form>
			<p class="switch">
				Don't have an account? <a href="signup.jsp">Sign Up</a>
			</p>
		</div>
	</div>

</body>
</html>
