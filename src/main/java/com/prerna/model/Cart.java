package com.prerna.model;

import java.util.Map;
import java.util.HashMap;

public class Cart {

	Map<Integer, CartItem> items;
	
	public Cart() {
		items = new HashMap<Integer, CartItem>();
	}
	
	public void addItem(CartItem item) {
		int itemId = item.getId();
		
		if(items.containsKey(itemId)) {
			CartItem existingCart = items.get(itemId);
			existingCart.setQuantity(existingCart.getQuantity() + item.getQuantity());
		}
		else {
			items.put(itemId, item);
		}
	}
	
	
	public void updateItem(int itemId, int quantity) {
		if(items.containsKey(itemId)) {
			if(quantity <= 0) items.remove(itemId);
			else items.get(itemId).setQuantity(quantity);
		}
	}
	
	public void removeItem(int itemId) {
		items.remove(itemId);
	}
	
	
	public Map<Integer, CartItem> getItem() {
		return items;
	}
	
	
	public void clearCart() {
		items.clear();
	}
	
	public float getTotal() {
		float total = 0.0f;
	
		for(CartItem item : items.values()) {
			total += item.getQuantity() * item.getPrice();
		}
		
		return total;
	}
}
