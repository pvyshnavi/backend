package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.model.Product;

public class TestCaseProduct {

	@Autowired
    ProductDAO productDAO;
	
	@Autowired
	Product product;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.shoppingcart");
		context.refresh();
		
		productDAO = (ProductDAO) context.getBean("productDAO");
		product = (Product) context.getBean("product");
		
	}
	
	
	public void deleteProductTestCase()
	{
		product.setId("MOB_002");
		
		boolean flag = productDAO.delete(product);
		
		assertEquals("deleteProductTestCase", flag, false);
	}
	
	
	public void addProductTestCase()
	{
		
		product.setId("MOB_002");
		product.setName("iphone2");
		product.setDesc("iphone desc");
		product.setPrice(7000);
		
		//productDAO.save(product);
		assertEquals("addProductTestCase", productDAO.save(product), true);
		
		
	}
	
	
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase", productDAO.list().size(),2);
	}
	
	
	public void updateProductTestCase()
	{
		
		product.setId("MOB_001");
		product.setName("iphone");
		product.setPrice(5000);
		product.setDesc("iphone desc");
		
		assertEquals("updateProductTestCase",productDAO.update(product),true);
		
	}
	
	@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase",productDAO.get("MOB_002"),null);
		
	}
}
