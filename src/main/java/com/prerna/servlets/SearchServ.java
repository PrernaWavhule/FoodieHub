package com.prerna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.daoImpl.RestaurantDAOImpl;
import com.prerna.model.Restaurant;


@WebServlet("/Search")
public class SearchServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RestaurantDAOImpl resto = new RestaurantDAOImpl();
		
		String keyword = req.getParameter("Search");
		
		List<Restaurant> restoSearchList = resto.searchRestaurant(keyword); 
		
		req.setAttribute("restoSearchList", restoSearchList);
		req.setAttribute("searchValue", keyword);
		
		req.getRequestDispatcher("home.jsp").forward(req, resp);
		
	}

}
