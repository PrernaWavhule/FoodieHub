package com.prerna.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.prerna.dao.OrdersDAO;
import com.prerna.database.DB_Connection;
import com.prerna.model.OrderStatus;
import com.prerna.model.Orders;
import com.prerna.model.PaymentMode;

public class OrdersDAOImpl implements OrdersDAO{
	
	Connection con = DB_Connection.getConnection();
	
	String INSERT_ORDER = "INSERT INTO Orders(RestaurantId, UserId, TotalAmount, OrderStatus, PaymentMode, Address) VALUES(?,?,?,?,?,?)";
	String GET_ORDER = "SELECT O.OrderId, O.RestaurantId, O.UserId, O.OrderDate, O.TotalAmount, O.OrderStatus, O.PaymentMode, O.address, R.Name as RestaurantName FROM Orders AS O INNER JOIN Restaurant AS R ON O.RestaurantId = R.RestaurantId WHERE OrderId = ?;";
	String GET_ALL_ORDER = "SELECT O.OrderId, O.RestaurantId, O.UserId, O.OrderDate, O.TotalAmount, O.OrderStatus, O.PaymentMode, O.address, R.Name as RestaurantName FROM Orders AS O INNER JOIN Restaurant AS R ON O.RestaurantId = R.RestaurantId WHERE UserId = ?;";
	String UPDATE_ORDER = "UPDATE Orders SET TotalAmount=?, OrderStatus=?, PaymentMode=? WHERE OrderId=?";
	String DELETE_ORDER = "DELETE FROM Orders WHERE OrderId=?";

	 @Override
	    public int insertOrder(Orders o) {
		 int order_id = 0;
		 
	        try (PreparedStatement pstmt = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {
	            pstmt.setInt(1, o.getRestaurantId());
	            pstmt.setInt(2, o.getUserId());
	            pstmt.setFloat(3, o.getTotalAmount());
	            pstmt.setString(4, o.getOrderStatus().name());
	            pstmt.setString(5, o.getPaymentMode().name());
	            pstmt.setString(6, o.getAddress());
	            pstmt.executeUpdate();
	            ResultSet keys = pstmt.getGeneratedKeys();
	            	while(keys.next()) {
	            		order_id = keys.getInt(1);
	            	}
	            
	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return order_id;
	    }

	    @Override
	    public Orders getOrder(int orderId) {
	        Orders order = null;
	        
	        try (PreparedStatement pstmt = con.prepareStatement(GET_ORDER)) {
	            pstmt.setInt(1, orderId);
	            
	            try (ResultSet res = pstmt.executeQuery()) {
	                if (res.next()) {
	                    order = new Orders(res.getInt("OrderId"),
			      						   res.getInt("RestaurantId"), 
			      						   res.getInt("UserId"),
			      						   res.getTimestamp("OrderDate"), 
			      						   res.getFloat("TotalAmount"),
			      						   OrderStatus.valueOf(res.getString("OrderStatus")),
			      						   PaymentMode.valueOf(res.getString("PaymentMode")),
			      						   res.getString("Address"), 
			      						   res.getString("RestaurantName")
	                    				   );
	                }
	                
	            }
	            
	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return order;
	    }

	    @Override
	    public List<Orders> getAllOrders(int userId) {
	        List<Orders> orderList = new ArrayList<>();
	        
	        try (PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDER);) {
	        	pstmt.setInt(1, userId);
	        	
	        	try(ResultSet res = pstmt.executeQuery()) {
	        		
	        		while (res.next()) {
		                Orders order = new Orders(res.getInt("OrderId"),
		                						  res.getInt("RestaurantId"), 
		                						  res.getInt("UserId"),
		                						  res.getTimestamp("OrderDate"), 
		                						  res.getFloat("TotalAmount"),
		                						  OrderStatus.valueOf(res.getString("OrderStatus")),
		                						  PaymentMode.valueOf(res.getString("PaymentMode")),
		                						  res.getString("Address"), 
		                						  res.getString("RestaurantName")
		                						  );
		                orderList.add(order);
		    
		            }
	      
	        	}
	            
	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return orderList;	        
	    }

	    @Override
	    public void updateOrder(Orders o) {
	    	
	        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDER)) {
	            pstmt.setFloat(1, o.getTotalAmount());
	            pstmt.setString(2, o.getOrderStatus().name());
	            pstmt.setString(3, o.getPaymentMode().name());
	            pstmt.setInt(4, o.getOrderId());
	            pstmt.executeUpdate();

	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }
	 @Override
	    public void deleteOrder(int orderId) {
		 
	        try (PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER)) {
	            pstmt.setInt(1, orderId);
	            pstmt.executeUpdate();
	        } 
	        
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	    }
	 
}