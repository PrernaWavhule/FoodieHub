package com.prerna.model;

import java.sql.Timestamp;

public class Orders {
	
	private int orderId;                                                  
	private int restaurantId;
	private int userId;
	private Timestamp OrderDate;
	private float totalAmount;
	private OrderStatus  orderStatus;
	private PaymentMode paymentMode;
	private String address;
	private String restaurantName;
	
	public Orders() {
		
	}
	
	public Orders(int orderId, int restaurantId, int userId, Timestamp orderDate, float totalAmount, OrderStatus orderStatus,
			PaymentMode paymentMode, String address, String restaurantName) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.OrderDate = orderDate;
		this.totalAmount = totalAmount;
		this.orderStatus = orderStatus;
		this.paymentMode = paymentMode;
		this.address = address;
		this.restaurantName = restaurantName;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Timestamp getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		OrderDate = orderDate;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRestaurantName() {
	    return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
	    this.restaurantName = restaurantName;
	}


	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", restaurantId=" + restaurantId + ", userId=" + userId + ", OrderDate="
				+ OrderDate + ", totalAmount=" + totalAmount + ", orderStatus=" + orderStatus + ", paymentMode="
				+ paymentMode +  ", address" + address +"]";
	}
	
}
