package com.prerna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.dao.OrdersDAO;
import com.prerna.daoImpl.OrdersDAOImpl;
import com.prerna.model.Orders;
import com.prerna.model.Users;


@WebServlet("/OrderHistory")
public class OrderHistoryServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Users user = (Users)req.getSession().getAttribute("user");
		OrdersDAO orderDAO = new OrdersDAOImpl();
		List<Orders> orderList = orderDAO.getAllOrders(user.getUserId());
		
		req.setAttribute("orderList", orderList);
		
		req.getRequestDispatcher("orderhistory.jsp").forward(req, resp);
	}


}
