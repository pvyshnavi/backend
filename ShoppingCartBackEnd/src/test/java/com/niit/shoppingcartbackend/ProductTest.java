package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.model.Product;

public class ProductTest {
	
public static void main(String[] args) {
		
		@SuppressWarnings("resource")
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
				context.scan("com.niit");
		        context.refresh();
		         
		        ProductDAO productDAO = (ProductDAO) context.getBean("productDAO");
		        Product product = (Product) context.getBean("product");
		        product.setId("MOB_004");
		        product.setName("iphone4");
		        product.setPrice(7000);
		        product.setDesc("iphone desc");
		        
		       if(productDAO.save(product) == true)
		       {
		    	   System.out.println("product created successfully");
		       }
		       else
		       {
		    	   System.out.println("not able to create the product");
		       }
		        	
		    	
	}

	
	

}
