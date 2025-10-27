package com.prerna.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prerna.dao.MenuDAO;
import com.prerna.daoImpl.MenuDAOImpl;
import com.prerna.model.Cart;
import com.prerna.model.CartItem;
import com.prerna.model.Menu;

@WebServlet("/Cart")
public class CartServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cart cart = (Cart)session.getAttribute("cart");
		
		Integer currentRestaurnatId = (Integer)session.getAttribute("RestaurantId");
		int newRestaurnatId = Integer.parseInt(req.getParameter("RestaurantId"));
		
		if(cart == null || currentRestaurnatId != newRestaurnatId) {
			cart = new Cart();
			session.setAttribute("cart", cart);
			session.setAttribute("RestaurantId", newRestaurnatId);
		}
		
		String action = req.getParameter("action");
		
		try {
			if(action.equals("add")) {
				addItemToCart(req, cart);
			}
			else if(action.equals("update")) {
				updateItemToCart(req, cart);
			}
			else if(action.equals("remove")) {
				removeItemToCart(req, cart);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		resp.sendRedirect("cart.jsp");
		
	}
	
	private void addItemToCart(HttpServletRequest request, Cart cart) throws ClassNotFoundException {
		int itemId = Integer.parseInt(request.getParameter("itemid")) ;
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		MenuDAO menuDao = new MenuDAOImpl();
		Menu menuItem = menuDao.getMenu(itemId);
		
		if(menuItem != null) {
			CartItem item = new CartItem(menuItem.getMenuId(),menuItem.getItemName(),menuItem.getPrice(), quantity);
			cart.addItem(item);
		}
		
	}

	private void updateItemToCart(HttpServletRequest request, Cart cart) throws ClassNotFoundException {
		int itemId = Integer.parseInt(request.getParameter("itemid")) ;
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		cart.updateItem(itemId, quantity);
	}
	
	private void removeItemToCart(HttpServletRequest request, Cart cart) throws ClassNotFoundException {
		int itemId = Integer.parseInt(request.getParameter("itemid")) ;
		cart.removeItem(itemId);
	}
	
}

