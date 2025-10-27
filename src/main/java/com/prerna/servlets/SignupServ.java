package com.prerna.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.daoImpl.UsersDAOImpl;
import com.prerna.model.Role;
import com.prerna.model.Users;

@WebServlet("/Signup")
public class SignupServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phonenumber");
		String address = req.getParameter("address");
		String role = req.getParameter("role");
		
		Role userRole = null;
		if (role != null && !role.isEmpty()) {
		    userRole = Role.valueOf(role.toUpperCase());
		}

		Users u = new Users();
		u.setName(name);
		u.setPassword(password);
		u.setEmail(email);
		u.setPhoneNumber(phoneNumber);
		u.setAddress(address);
		u.setRole(userRole);
		
		UsersDAOImpl user = new UsersDAOImpl();
		user.insertUser(u);
		
		resp.sendRedirect("login.jsp");
	}

}
