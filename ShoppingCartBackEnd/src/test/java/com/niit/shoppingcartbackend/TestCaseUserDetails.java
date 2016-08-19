package com.niit.shoppingcartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.UserDetailsDAO;

import com.niit.shoppingcart.model.UserDetails;

public class TestCaseUserDetails {
	
	@Autowired
    UserDetailsDAO userDetailsDAO;
	
	@Autowired
	UserDetails userDetails;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		userDetails = (UserDetails) context.getBean("userDetails");
		
	}
	
	
	public void deleteUserDetailsTestCase()
	{
		userDetails.setId("p1");
		
		boolean flag = userDetailsDAO.delete(userDetails);
		
		assertEquals("deleteUserDetailsTestCase", flag, true);
	}
	
	
	public void addProductTestCase()
	{
		
		userDetails.setId("p3");
		userDetails.setName("abd");
		userDetails.setPassword("ac");
        userDetails.setMail("ad@gmail.com");
        userDetails.setContact("9985276818");
        userDetails.setAddress("tvm");
		
		
		//productDAO.save(product);
		assertEquals("addUserDetailsTestCase", userDetailsDAO.save(userDetails), true);
		
		
	}
	
	
	public void listUserDetailsTestCase()
	{
		assertEquals("listUserDetailsTestCase", userDetailsDAO.list().size(),3);
	}
	
	@Test
	public void updateUserDetailsTestCase()
	{
		
		userDetails.setId("p3");
		userDetails.setName("abd");
		userDetails.setPassword("abcd");
		userDetails.setMail("ad@gmail.com");
        userDetails.setContact("9985276818");
        userDetails.setAddress("tvm");

		
		assertEquals("updateUserDetailsTestCase",userDetailsDAO.update(userDetails),true);
		
	}
	
	
	public void getUserDetailsTestCase()
	{
		assertEquals("getUserDetailsTestCase",userDetailsDAO.get("p1"),null);
		
	}

	

}
