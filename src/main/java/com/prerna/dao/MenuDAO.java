package com.prerna.dao;

import com.prerna.model.Menu;
import java.util.List;

public interface MenuDAO {
	
	public void insertMenu(Menu m);
	
	public Menu getMenu(int menuId);
	
	public List<Menu> getAllMenuByRestoId(int restoId);
	
	public void updateMenu(Menu m);
	
	public void deleteMenu(int menuId);

}
