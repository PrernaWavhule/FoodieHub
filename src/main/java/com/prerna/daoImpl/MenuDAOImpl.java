package com.prerna.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prerna.dao.MenuDAO;
import com.prerna.database.DB_Connection;
import com.prerna.model.Menu;

public class MenuDAOImpl implements MenuDAO{
	
	Connection con = DB_Connection.getConnection();
	
	String INSERT_MENU = "INSERT INTO Menu(RestaurantId, ItemName, Description, Price, IsAvailable, Rating, ImagePath) VALUES (?,?,?,?,?,?,?)";
	String GET_MENU = "SELECT * FROM Menu WHERE MenuId=?";
	String GET_MENU_BY_RESTOID = "SELECT * FROM Menu WHERE RestaurantId=?";
	String UPDATE_MENU = "UPDATE Menu SET ItemName = ?, Description = ?, Price = ?, IsAvailable = ?, ImagePath = ? WHERE MenuId = ?;";
	String DELETE_MENU = "UPDATE Menu SET IsAvailable=0 WHERE MenuId=? ";

	@Override
	public void insertMenu(Menu m) {
		
		try(PreparedStatement pstmt = con.prepareStatement(INSERT_MENU);){
			pstmt.setInt(1, m.getRestaurantId());
			pstmt.setString(2, m.getItemName());
			pstmt.setString(3, m.getDescription());
			pstmt.setFloat(4, m.getPrice());
			pstmt.setBoolean(5, m.isAvailable());
			pstmt.setFloat(6, m.getRating());
			pstmt.setString(7, m.getImagePath());
			pstmt.executeUpdate();			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Menu getMenu(int menuId) {
		
		Menu menu = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_MENU);){
			pstmt.setInt(1, menuId);
			
			try(ResultSet res = pstmt.executeQuery()) {
				
				if(res.next()) {
					menu = new Menu(res.getInt("MenuID"), 
									res.getInt("RestaurantId"), 
									res.getString("ItemName"), 
									res.getString("Description"),
									res.getFloat("Price"), 
									res.getBoolean("IsAvailable"), 
									res.getFloat("Rating"), 
									res.getString("ImagePath")
									);
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return menu;
	}

	@Override
	public List<Menu> getAllMenuByRestoId(int restoId) {
		
		List<Menu> menuList = new ArrayList<Menu>();
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_MENU_BY_RESTOID);){
			pstmt.setInt(1, restoId);
	
			try(ResultSet res = pstmt.executeQuery()){
				
				while(res.next()) {
					Menu menu = new Menu(res.getInt("MenuID"), 
										 res.getInt("RestaurantId"), 
										 res.getString("ItemName"), 
										 res.getString("Description"),
										 res.getFloat("Price"), 
										 res.getBoolean("IsAvailable"), 
										 res.getFloat("Rating"), 
										 res.getString("ImagePath")
										 );
					menuList.add(menu);
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return menuList;
	}

	@Override
	public void updateMenu(Menu m) {

		try(PreparedStatement pstmt = con.prepareStatement(UPDATE_MENU);){
			pstmt.setString(1, m.getItemName());
			pstmt.setString(2, m.getDescription());
			pstmt.setFloat(3, m.getPrice());
			pstmt.setBoolean(4, m.isAvailable());
			pstmt.setString(5, m.getImagePath());
			pstmt.setInt(6, m.getMenuId());
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteMenu(int menuId) {
		
		try(PreparedStatement pstmt = con.prepareStatement(DELETE_MENU);){
			pstmt.setInt(1, menuId);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	}

}