package com.prerna.dao;

import java.util.List;

import com.prerna.model.Orders;

public interface OrdersDAO {

	public int insertOrder(Orders o);
	
	public Orders getOrder(int orderId);
	
	public List<Orders> getAllOrders(int userId);
	
	public void updateOrder(Orders o);
	
	public void deleteOrder(int orderId);
	
}
