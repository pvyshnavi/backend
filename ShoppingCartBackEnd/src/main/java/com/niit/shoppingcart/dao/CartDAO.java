package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Cart;

public interface CartDAO {
	
public List<Cart> list();

public List<Cart> userCartList(String user_id);
	
	public Cart get(String id);
	
	public Cart getByUserId(String user_id);
	
	public void saveOrUpdate(Cart cart);
	
	public boolean delete(Cart cart);
	
	public long getTotal(String id);
	
	public void checkOut(String user_id);

}
