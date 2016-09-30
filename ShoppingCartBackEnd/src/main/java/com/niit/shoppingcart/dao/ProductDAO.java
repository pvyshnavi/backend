package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.Product;

public interface ProductDAO {
	
	public void saveOrUpdate(Product product);
	
	//public boolean update(Product product);
	
	public boolean delete(Product product);
	
	public  Product get(String id);
	
	public  List<Product> list();
	
	public Product getByName(String name);
	
	

}
