package com.niit.shoppingcart.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.model.UserDetails;

@Repository
public interface UserDetailsDAO {

	public boolean saveOrUpdate(UserDetails userDetails);
	
	//public boolean update(UserDetails userDetails);
	
	public boolean delete(UserDetails userDetails);
	
	public  UserDetails get(String id);
	
	public  List<UserDetails> list();
	public boolean isValidUser(String id, String password);

	
	
}
