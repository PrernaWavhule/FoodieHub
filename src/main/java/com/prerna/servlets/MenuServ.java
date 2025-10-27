package com.prerna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.daoImpl.MenuDAOImpl;
import com.prerna.model.Menu;

@WebServlet("/Menu")
public class MenuServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("RestaurantId"));
		
		MenuDAOImpl menu = new MenuDAOImpl();
		List<Menu> menuList = menu.getAllMenuByRestoId(restaurantId);
		
		req.setAttribute("menuList", menuList);
		
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}

}
