package com.prerna.dao;

import java.util.List;

import com.prerna.model.Users;

public interface UsersDAO {
	
	public void insertUser(Users u);
	
	public Users loginUser(String email, String password); 
	
	public Users getUser(int userId);
	
	public List<Users> getAllUsers();
	
	public void updateUser(Users u);
	
	public void deleteUser(int userId);

}
