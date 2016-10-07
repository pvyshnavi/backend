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
	
	@Test
	public void deleteProductTestCase()
	{
		product.setId("P001");
		
		boolean flag = productDAO.delete(product);
		
		assertEquals("deleteProductTestCase", flag, true);
	}
	
	//@Test
	public void addProductTestCase()
	{
		
		product.setId("P002");
		product.setName("Gown");
		product.setDesc("Bridal Gown");
		product.setPrice(10000);
		
		//productDAO.save(product);
		assertEquals("addProductTestCase", productDAO.saveOrUpdate(product), true);
		
		
	}
	
	//@Test
	public void listProductTestCase()
	{
		assertEquals("listProductTestCase", productDAO.list().size(),10);
	}
	
	//@Test
	public void updateProductTestCase()
	{
		
		product.setId("P001");
		product.setName("Saree");
		product.setPrice(6000);
		product.setDesc("Cotton Saree");
		
		assertEquals("updateProductTestCase",productDAO.saveOrUpdate(product),true);
		
	}
	
	//@Test
	public void getProductTestCase()
	{
		assertEquals("getProductTestCase",productDAO.get("P001"),null);
		
	}
}
