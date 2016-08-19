package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.UserDetails;

public class UserDetailsTest {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		         
		        UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		        UserDetails userDetails = (UserDetails) context.getBean("userDetails");
		        userDetails.setId("P2");
		        userDetails.setName("ab");
		        userDetails.setPassword("bc");
		        userDetails.setMail("ab@gmail.com");
		        userDetails.setContact("9895276818");
		        userDetails.setAddress("tcr");
		   
		        
		       if(userDetailsDAO.save(userDetails) == true)
		       {
		    	   System.out.println("UserDetails created successfully");
		       }
		       else
		       {
		    	   System.out.println("not able to create the UserDetails");
		       }
		        	
		    	
	}

	

}
