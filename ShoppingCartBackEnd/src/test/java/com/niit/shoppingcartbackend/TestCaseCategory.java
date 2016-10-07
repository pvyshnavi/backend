package com.niit.shoppingcartbackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.model.Category;

public class TestCaseCategory {
	
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	Category category;
	
	AnnotationConfigApplicationContext context;
	
	@Before
	public void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		category = (Category) context.getBean("category");
		
		
	}
	@Test
	public void categoryListTestCase()
	{
		List<Category> list = categoryDAO.list();
		int rowCount= list.size();
		
		assertEquals("Category List Test Case", rowCount, 10);
	}
	//@Test
	public void categoryAddTestCase()
	{
		category.setId("C008");
		category.setName("CG008");
		category.setDescription("CG008");
		
		boolean flag= categoryDAO.saveOrUpdate(category);
		assertEquals(flag, true);
	}
    //@Test
	public void categoryGetTestCase()
	{
		category = categoryDAO.get("C002");
		System.out.println(category.getName());
		System.out.println(category.getDescription());
		assertEquals(category.getName(), "CG002");
	}

	
	

	

}
