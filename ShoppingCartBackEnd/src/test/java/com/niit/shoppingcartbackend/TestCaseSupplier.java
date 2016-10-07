package com.niit.shoppingcartbackend;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;




public class TestCaseSupplier {
	
	@Autowired
    SupplierDAO supplierDAO;
	
	@Autowired
	Supplier supplier;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		supplierDAO = (SupplierDAO) context.getBean("supplierDAO");
		supplier = (Supplier) context.getBean("supplier");
		
	}
	
	@Test
	public void deleteSupplierTestCase()
	{
		supplier.setId("S004");
		//supplier.setName("SG002");
		//supplier.setAddress("Madras");
		
		boolean flag = supplierDAO.delete(supplier);
		
		assertEquals("deleteSupplierTestCase", flag, true);
	}
	
	@Test
	public void addSupplierTestCase()
	{
		
		supplier.setId("S005");
		supplier.setName("kalayani");
		supplier.setAddress("kolkata");
		
		//productDAO.save(product);
		assertEquals("addSupplierTestCase", supplierDAO.saveOrUpdate(supplier), true);
		
		
	}
	
	@Test
	public void listSupplierTestCase()
	{
		assertEquals("listSupplierTestCase", supplierDAO.list().size(),5);
	}
	
	@Test
	public void updateSupplierTestCase()
	{
		
		supplier.setId("S001");
		supplier.setName("zara");
		supplier.setAddress("kochi");
		
		assertEquals("updateSupplierTestCase",supplierDAO.saveOrUpdate(supplier),true);
		
	}
	
	@Test
	public void getSupplierTestCase()
	{
		assertEquals("getSupplierTestCase",supplierDAO.get("S001"),null);
		
	}

	
	

}
