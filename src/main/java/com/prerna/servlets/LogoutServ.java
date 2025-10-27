package com.prerna.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class LogoutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		if(req.getSession().getAttribute("user") != null) {
			req.getSession().removeAttribute("user");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("/Home").forward(req, resp);;
		}
	}

}
