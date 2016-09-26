package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
public List<Cart> list();
	
	public Cart get(int id);
	
	public void saveOrUpdate(Cart cart);
	
	//public boolean update(Cart cart);
	
	public String delete(int id);
	
	public long getTotal(String id);
	

}
