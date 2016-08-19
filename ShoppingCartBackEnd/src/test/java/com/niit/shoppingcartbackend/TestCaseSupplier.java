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
	
	
	public void deleteSupplierTestCase()
	{
		supplier.setId("S002");
		//supplier.setName("SG002");
		//supplier.setAddress("Madras");
		
		boolean flag = supplierDAO.delete(supplier);
		
		assertEquals("deleteSupplierTestCase", flag, false);
	}
	
	
	public void addSupplierTestCase()
	{
		
		supplier.setId("S002");
		supplier.setName("SG002");
		supplier.setAddress("delhi");
		
		//productDAO.save(product);
		assertEquals("addSupplierTestCase", supplierDAO.save(supplier), true);
		
		
	}
	
	
	public void listSupplierTestCase()
	{
		assertEquals("listSupplierTestCase", supplierDAO.list().size(),3);
	}
	
	
	public void updateSupplierTestCase()
	{
		
		supplier.setId("S002");
		supplier.setName("SG002");
		supplier.setAddress("mumbai");
		
		assertEquals("updateSupplierTestCase",supplierDAO.update(supplier),true);
		
	}
	
	@Test
	public void getSupplierTestCase()
	{
		assertEquals("getSupplierTestCase",supplierDAO.get("S001"),null);
		
	}

	
	

}
