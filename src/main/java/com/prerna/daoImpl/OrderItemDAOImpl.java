package com.prerna.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prerna.dao.OrderItemDAO;
import com.prerna.database.DB_Connection;
import com.prerna.model.OrderItem;

public class OrderItemDAOImpl implements OrderItemDAO{
	
	Connection con = DB_Connection.getConnection();
	
	String INSERT_ORDERITEM = "INSERT INTO OrderItem(OrderId, MenuId, Quantity, TotalAmount) VALUES(?,?,?,?)";
    String GET_ORDERITEM = "SELECT * FROM OrderItem WHERE OrderItemId=?";
    String GET_ALL_ORDERITEM = "SELECT OI.OrderItemId, OI.OrderId, OI.MenuId, OI.Quantity,  OI.TotalAmount, M.ItemName AS ItemName, M.Price AS Price FROM OrderItem AS OI LEFT JOIN MENU AS M ON OI.Menuid = M.Menuid WHERE OI.OrderId=?"; 
    String UPDATE_ORDERITEM = "UPDATE OrderItem SET Quantity=?, TotalAmount=? WHERE OrderItemId=?";
    String DELETE_ORDERITEM = "DELETE FROM OrderItem WHERE OrderItemId=?";

    @Override
    public void insertOrderItem(OrderItem item) {
    	
        try (PreparedStatement pstmt = con.prepareStatement(INSERT_ORDERITEM)) {
            pstmt.setInt(1, item.getOrderId());
            pstmt.setInt(2, item.getMenuId());
            pstmt.setInt(3, item.getQuantity());
            pstmt.setFloat(4, item.getTotalAmount());
            pstmt.executeUpdate();
            
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public OrderItem getOrderItem(int orderItemId) {
        OrderItem item = null;
        
        try (PreparedStatement pstmt = con.prepareStatement(GET_ORDERITEM)) {
            pstmt.setInt(1, orderItemId);
            
            try (ResultSet res = pstmt.executeQuery()) {
                if (res.next()) {
                    item = new OrderItem(res.getInt("OrderId"), 
                    					 res.getInt("MenuId"),
                    					 res.getInt("Quantity"), 
                    					 res.getFloat("TotalAmount")
                    					 );
                }
                
            }
            
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return item;
    }

    @Override
    public List<OrderItem> getAllOrderItems(int orderId) {
        List<OrderItem> items = new ArrayList<>();
        
        try (PreparedStatement pstmt = con.prepareStatement(GET_ALL_ORDERITEM); ) {
        	pstmt.setInt(1, orderId);
        	try(ResultSet res = pstmt.executeQuery()){
        		while (res.next()) {
                    OrderItem item = new OrderItem(res.getInt("OrderItemId"),
                    							   res.getInt("OrderId"),
                    							   res.getInt("MenuId"),
                    							   res.getInt("Quantity"), 
                    							   res.getFloat("TotalAmount"),
                    							   res.getString("ItemName"),
                    							   res.getFloat("Price")
                    							   );
                    items.add(item);
                }
        	}
                
  
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return items;
    }

    @Override
    public void updateOrderItem(OrderItem item) {
    	
        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_ORDERITEM)) {
            pstmt.setInt(1, item.getQuantity());
            pstmt.setFloat(2, item.getTotalAmount());
            pstmt.setInt(3, item.getOrderItemId());
            pstmt.executeUpdate();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void deleteOrderItem(int orderItemId) {
    	
        try (PreparedStatement pstmt = con.prepareStatement(DELETE_ORDERITEM)) {
            pstmt.setInt(1, orderItemId);
            pstmt.executeUpdate();
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

}