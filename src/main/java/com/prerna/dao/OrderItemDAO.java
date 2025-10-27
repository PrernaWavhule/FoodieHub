package com.prerna.dao;

import java.util.List;

import com.prerna.model.OrderItem;

public interface OrderItemDAO {

	public void insertOrderItem(OrderItem ot);
	
	public OrderItem getOrderItem(int orderItem);
	
	public List<OrderItem> getAllOrderItems(int orderId);
	
	public void updateOrderItem(OrderItem ot);
	
	public void deleteOrderItem(int orderItem);
	
}
