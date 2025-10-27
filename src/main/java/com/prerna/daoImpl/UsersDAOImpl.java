package com.prerna.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.prerna.dao.UsersDAO;
import com.prerna.database.DB_Connection;
import com.prerna.model.Role;
import com.prerna.model.Users;

public class UsersDAOImpl implements UsersDAO{
	
	Connection con = DB_Connection.getConnection();
	
	String INSERT_USER = "INSERT INTO Users(Name, Password, Email, PhoneNumber, Address, Role) VALUES(?,?,?,?,?,?)";
	String LOGIN_QUERY = "SELECT * FROM Users WHERE email=? AND password=?";
	String GET_USER = "SELECT * FROM Users WHERE UserId=?";
	String GET_ALL_USERS = "SELECT * FROM Users";
	String UPDATE_USER = "UPDATE Users SET Name=?, Password=?, Email=?, PhoneNumber=?, Address=?, Role=? WHERE UserId=?";
	String DELETE_USERS = "DELETE FROM Users WHERE UserId=?";
	
	@Override
	public void insertUser(Users u) {
		
		try(PreparedStatement pstmt = con.prepareStatement(INSERT_USER);) {
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPhoneNumber());
			pstmt.setString(5, u.getAddress());
			pstmt.setString(6, u.getRole().name());
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public Users loginUser(String email, String password) {
		
		Users user = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(LOGIN_QUERY);) {
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			try(ResultSet res = pstmt.executeQuery();){
				if(res.next() == true) {
					user = new Users(res.getInt("UserId"), 
									 res.getString("Name"), 
									 res.getString("Password"),
									 res.getString("Email"), 
									 res.getString("PhoneNumber"), 
									 res.getString("Address"), 
									 Role.valueOf(res.getString("Role").toUpperCase())
									 );
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public Users getUser(int userId) {
		
		Users user = null;
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_USER);) {
			pstmt.setInt(1, userId);
			try(ResultSet res = pstmt.executeQuery();){
				if(res.next()) {
					user = new Users(res.getInt("UserId"), 
									 res.getString("Name"), 
									 res.getString("Password"),
									 res.getString("Email"), 
									 res.getString("PhoneNumber"), 
									 res.getString("Address"), 
									 Role.valueOf(res.getString("Role").toUpperCase())
									 );
				}
				
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<Users> getAllUsers() {
		
		List<Users> userList = new ArrayList<Users>();
		
		try(PreparedStatement pstmt = con.prepareStatement(GET_ALL_USERS); ResultSet res = pstmt.executeQuery();) {
			while(res.next()) {
				Users user = new Users(res.getInt("UserId"), 
									   res.getString("Name"), 
									   res.getString("Password"),
									   res.getString("Email"), 
									   res.getString("PhoneNumber"), 
									   res.getString("Address"), 
									   Role.valueOf(res.getString("Role").toUpperCase())
									   );
				userList.add(user);
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	@Override
	public void updateUser(Users u) {
		
		try(PreparedStatement pstmt = con.prepareStatement(UPDATE_USER);){
			pstmt.setString(1, u.getName());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getEmail());
			pstmt.setString(4, u.getPhoneNumber());
			pstmt.setString(5, u.getAddress());
			pstmt.setString(6, u.getRole().name());
			pstmt.setInt(7, u.getUserId());
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteUser(int userId) {
		
		try(PreparedStatement pstmt = con.prepareStatement(DELETE_USERS);) {
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}