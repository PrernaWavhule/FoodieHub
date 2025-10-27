<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.prerna.model.Users"%>

<section>

	<%
	    HttpSession ses = request.getSession(false);
	    Users user = null;
	    if (ses != null) {
	        user = (Users) ses.getAttribute("user");
	    }
	%>

	<nav>
		<div class="logo">
			<img src="images/logo.png" alt="Logo">
		</div>

		<ul id="menuList" class="nav-links">
			<li><a href="Home"><i class="fa fa-home"></i> Home</a></li>
			<li><a href="#"><i class="fa fa-search"></i> Search</a></li>
			<li><a href="#"><i class="fa-solid fa-percent"></i> Offers</a></li>
			<li><a href="cart.jsp"><i class="fa-solid fa-cart-shopping"></i> Cart</a></li>
			<%
            	if(user != null){
            %>
            <li><a href="OrderHistory"><i class="fa-solid fa-user"></i> Orders</a></li>
			<li><a href="#"><i class="fa-solid fa-user"></i> <%= user.getName() %></a></li>
			<li><a href="Logout"><i class="fa-solid fa-right-from-bracket"></i> Logout</a></li>
			<%
                }else{
            %>
			<li><a href="login.jsp"><i class="fa-solid fa-right-to-bracket"></i> Login</a></li>
			<%
                }
            %>
		</ul>

		<div class="menu-icon">
			<i class="fa-solid fa-bars" onclick="toggleMenu()"></i>
		</div>

	</nav>

</section>

<script>
	function toggleMenu() {
		const menuList = document.getElementById("menuList");
		menuList.classList.toggle("show");
	}
</script>
