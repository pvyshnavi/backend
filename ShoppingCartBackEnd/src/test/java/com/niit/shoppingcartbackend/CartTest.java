package com.niit.shoppingcartbackend;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.UserDetailsDAO;
import com.niit.shoppingcart.model.Cart;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.UserDetails;


public class CartTest {
	
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

		context.scan("com.niit");
		context.refresh();
		
		Cart cart = (Cart) context.getBean("cart");		

		CartDAO cartDAO =(CartDAO) context.getBean("cartDAO");
		ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		SupplierDAO supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		UserDetailsDAO userDetailsDAO = (UserDetailsDAO) context.getBean("userDetailsDAO");
		
		//UserDetails us = (UserDetails) context.getBean("userDetails");
		//Product p = (Product) context.getBean("product");
		
		
		cart.setId("0453");
		cart.setTotal(9050);
		cart.setProductName("mob3");
		cart.setPrice(9050);
		cart.setQuantity(1);
		cart.setStatus("available");
		cart.setUserDetails(userDetailsDAO.get("p5"));
		cart.setProduct(productDAO.get("MOB_004"));
		
		
		cartDAO.saveOrUpdate(cart);
      // System.out.println("Total : " + cartDAO.getTotal("p5"));

		//System.out.println("created successfully");
	}
	
}
