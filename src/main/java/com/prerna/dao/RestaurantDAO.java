package com.prerna.dao;

import java.util.List;

import com.prerna.model.Restaurant;

public interface RestaurantDAO {
	
	public void insertRestaurant(Restaurant r);
	
	public Restaurant getRestaurantById(int restaurantId);
	
	public List<Restaurant> getAllRestaurant();
	
	public void updateRestaurant(Restaurant r);
	
	public void deleteRestaurant(int restaurantId);
	
	public List<Restaurant> searchRestaurant(String restaurant);

}
