package com.prerna.model;

public class Users {
	
	private int userId;
	private String name;
	private String password;
	private String email;
	private String phoneNumber;
	private String address;
	private Role role;
	
	public Users() {
		
	}

	public Users(int userId, String name, String password, String email, String phoneNumber,
			String address, Role role) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", name=" + name + ", password=" + password + ", email=" + email 
				+ ", phoneNumber=" + phoneNumber + ", address=" + address + ", role=" + role + "]";
	}
	
}
