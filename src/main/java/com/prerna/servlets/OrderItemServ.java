package com.prerna.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.prerna.dao.OrderItemDAO;
import com.prerna.dao.OrdersDAO;
import com.prerna.daoImpl.OrderItemDAOImpl;
import com.prerna.daoImpl.OrdersDAOImpl;
import com.prerna.model.OrderItem;
import com.prerna.model.Orders;


@WebServlet("/OrderItem")
public class OrderItemServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int orderId =Integer.parseInt(req.getParameter("OrderId"));
		
		OrdersDAO ordersDAO = new OrdersDAOImpl();
		Orders order = ordersDAO.getOrder(orderId);
		
		req.setAttribute("order", order);
		
		OrderItemDAO orderItemDAO = new OrderItemDAOImpl();
		List<OrderItem> orderItemList = orderItemDAO.getAllOrderItems(orderId);
		
		req.setAttribute("orderItemList", orderItemList);
		
		req.getRequestDispatcher("orderitem.jsp").forward(req, resp);
	}

}
