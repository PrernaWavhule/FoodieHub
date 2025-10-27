package com.prerna.servlets;

import java.io.IOException;
import java.util.Date;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.prerna.dao.OrderItemDAO;
import com.prerna.dao.OrdersDAO;
import com.prerna.daoImpl.OrderItemDAOImpl;
import com.prerna.daoImpl.OrdersDAOImpl;
import com.prerna.model.Cart;
import com.prerna.model.CartItem;
import com.prerna.model.OrderItem;
import com.prerna.model.OrderStatus;
import com.prerna.model.Orders;
import com.prerna.model.PaymentMode;
import com.prerna.model.Users;

@WebServlet("/Checkout")
public class CheckOutServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private OrdersDAO orderDao;
	private OrderItemDAO orderItemDao;

	@Override
	public void init() throws ServletException {
		try {
			orderDao = new OrdersDAOImpl();
			orderItemDao = new OrderItemDAOImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Users user = (Users) session.getAttribute("user");

		if (user == null) {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}

		if (cart == null || cart.getItem() == null || cart.getItem().isEmpty()) {
			req.getRequestDispatcher("cart.jsp");
			return;
		}

		String address = req.getParameter("address");
		String payment = req.getParameter("payment");

		PaymentMode paymentMode = PaymentMode.valueOf(payment);

		Orders order = new Orders();

		order.setRestaurantId(Integer.parseInt(session.getAttribute("RestaurantId").toString()));
		order.setUserId(user.getUserId());
		order.setOrderDate(new Timestamp(new Date().getTime()));

		float total = 0;
		for (CartItem item : cart.getItem().values()) {
			total += item.getPrice() * item.getQuantity();
		}

		order.setTotalAmount(total);
		order.setOrderStatus(OrderStatus.CONFIRMED);
		order.setPaymentMode(paymentMode);
		order.setAddress(address);

		int orderID = orderDao.insertOrder(order);

		for (CartItem item : cart.getItem().values()) {
			int menuId = item.getId();
			int quantity = item.getQuantity();
			float totalamount = item.getQuantity() * item.getPrice();
			OrderItem orderItem = new OrderItem(orderID, menuId, quantity, totalamount);
			orderItemDao.insertOrderItem(orderItem);
		}

		session.removeAttribute("cart");
		session.setAttribute("order", order);

		resp.sendRedirect("orderconfirm.jsp");

	}

}
