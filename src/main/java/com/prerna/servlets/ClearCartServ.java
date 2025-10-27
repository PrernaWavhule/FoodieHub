package com.prerna.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.model.Cart;


@WebServlet("/ClearCart")
public class ClearCartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart =  (Cart)req.getSession().getAttribute("cart");
	
		if(cart != null) {
			cart.clearCart();
		}
		
		req.getRequestDispatcher("cart.jsp").forward(req, resp);
	}

}
