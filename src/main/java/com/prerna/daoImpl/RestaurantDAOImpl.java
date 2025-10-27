package com.prerna.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prerna.dao.RestaurantDAO;
import com.prerna.database.DB_Connection;
import com.prerna.model.CuisineType;
import com.prerna.model.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	Connection con = DB_Connection.getConnection();
	
	String INSERT_RESTAURANT = "INSERT INTO Restaurant(Name, Address, PhoneNumber, CuisineType, DeliveryTime, AdminUserID, Rating, IsActive, ImagePath) VALUES(?,?,?,?,?,?,?,?,?)";
	String GET_RESTAURANT = "SELECT * FROM Restaurant WHERE RestaurantId=?";
	String GET_ALL_RESTAURANT = "SELECT * FROM Restaurant";
	String UPDATE_RESTAURANT = "UPDATE Restaurant SET Name=?, Address=?, PhoneNumber=?, CuisineType=?, DeliveryTime=?, IsActive=?, ImagePath=? WHERE RestaurantId=?";
	String DELETE_RESTAURANT = "UPDATE Restaurant SET IsActive=0 WHERE RestaurantId=?";
	String SEARCH_RESTAURANT = "SELECT * FROM Restaurant WHERE Name LIKE ?";
	
	@Override
	public void insertRestaurant(Restaurant r) {
		
		try(PreparedStatement pstmt = con.prepareStatement(INSERT_RESTAURANT);) {
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getPhoneNumber());
			pstmt.setString(4, r.getCuisine().name());
			pstmt.setInt(5, r.getDeliveryTime());
			pstmt.setInt(6, r.getAdminUserId());
			pstmt.setFloat(7, r.getRating());
			pstmt.setBoolean(8, r.isActive());
			pstmt.setString(9, r.getImagePath());
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		
		Restaurant resto = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_RESTAURANT);) {
			pstmt.setInt(1, restaurantId);
			try (ResultSet res = pstmt.executeQuery()) {
				if(res.next()) {
					resto = new Restaurant(res.getInt("RestaurantId"),
										   res.getString("Name"),
										   res.getString("Address"),
										   res.getString("PhoneNumber"),
										   CuisineType.valueOf(res.getString("CuisineType").toUpperCase()),
										   res.getInt("DeliveryTime"),
										   res.getInt("AdminUserID"),
										   res.getFloat("Rating"),
										   res.getBoolean("IsActive"),
										   res.getString("ImagePath")
										   );
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return resto;
	}

	@Override
	public List<Restaurant> getAllRestaurant() {
		List<Restaurant> restoList = new ArrayList<Restaurant>();
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_ALL_RESTAURANT);
			ResultSet res = pstmt.executeQuery();) {
			
			while(res.next()) {
				Restaurant resto = new Restaurant(res.getInt("RestaurantId"),
												  res.getString("Name"),
												  res.getString("Address"),
												  res.getString("PhoneNumber"),
												  CuisineType.valueOf(res.getString("CuisineType").toUpperCase()),
												  res.getInt("DeliveryTime"),	
												  res.getInt("AdminUserID"),
												  res.getFloat("Rating"),
												  res.getBoolean("IsActive"),
												  res.getString("ImagePath")
												  );
				restoList.add(resto);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return restoList;
	}
	

	@Override
	public void updateRestaurant(Restaurant r) {
		
		try(PreparedStatement pstmt = con.prepareStatement(UPDATE_RESTAURANT);) {
			pstmt.setString(1, r.getName());
			pstmt.setString(2, r.getAddress());
			pstmt.setString(3, r.getPhoneNumber());
			pstmt.setString(4, r.getCuisine().name());
			pstmt.setInt(5, r.getDeliveryTime());
			pstmt.setBoolean(6, r.isActive());
			pstmt.setString(7, r.getImagePath());
			pstmt.setInt(8, r.getRestaurantId());
			pstmt.executeUpdate();			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		
		try(PreparedStatement pstmt = con.prepareStatement(DELETE_RESTAURANT);) {
			pstmt.setInt(1, restaurantId);
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Restaurant> searchRestaurant(String restaurant) {
		List<Restaurant> restoList = new ArrayList<Restaurant>();
		
		try(PreparedStatement pstmt = con.prepareStatement(SEARCH_RESTAURANT);){
			pstmt.setString(1,"%" + restaurant + "%");
			
			try(ResultSet res = pstmt.executeQuery();){
				while(res.next()) {
					Restaurant resto = new Restaurant(res.getInt("RestaurantId"),
													  res.getString("Name"),
													  res.getString("Address"),
													  res.getString("PhoneNumber"),
													  CuisineType.valueOf(res.getString("CuisineType").toUpperCase()),
													  res.getInt("DeliveryTime"),	
													  res.getInt("AdminUserID"),
													  res.getFloat("Rating"),
													  res.getBoolean("IsActive"),
													  res.getString("ImagePath")
													  );
					restoList.add(resto);
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return restoList;
	}

}
