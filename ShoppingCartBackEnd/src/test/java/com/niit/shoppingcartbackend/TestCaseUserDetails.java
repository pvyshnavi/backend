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
	
	@Test
	public void deleteUserDetailsTestCase()
	{
		userDetails.setId("p3");
		
		boolean flag = userDetailsDAO.delete(userDetails);
		
		assertEquals("deleteUserDetailsTestCase", flag, true);
	}
	
	//@Test
	public void addProductTestCase()
	{
		
		userDetails.setId("p5");
		userDetails.setName("pr");
		userDetails.setPassword("ps2");
        userDetails.setMail("pr@gmail.com");
        userDetails.setContact("9985276838");
        userDetails.setAddress("gvr");
        userDetails.setRole("");
		
		
		//productDAO.save(product);
		assertEquals("addUserDetailsTestCase", userDetailsDAO.save(userDetails), true);
		
		
	}
	
	//@Test
	public void listUserDetailsTestCase()
	{
		assertEquals("listUserDetailsTestCase", userDetailsDAO.list().size(),4);
	}
	
	//@Test
	public void updateUserDetailsTestCase()
	{
		
		userDetails.setId("p3");
		userDetails.setName("abd");
		userDetails.setPassword("abcd");
		userDetails.setMail("ad@gmail.com");
        userDetails.setContact("9985276818");
        userDetails.setAddress("gvr");
        userDetails.setRole("");

		
		assertEquals("updateUserDetailsTestCase",userDetailsDAO.update(userDetails),true);
		
	}
	
	//@Test
	public void getUserDetailsTestCase()
	{
		assertEquals("getUserDetailsTestCase",userDetailsDAO.get("p1"),null);
		
	}

	

}
