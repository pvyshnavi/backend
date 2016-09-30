package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Product;


@Transactional
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO{
	
	private static final Logger log = LoggerFactory.getLogger(ProductDAOImpl.class);
	
	//private static final Logger log = LoggerFactory.getLogger("com.niit.shoppingcart.dao")
	
	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl( SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    
	//public boolean save(Product product) {
		//try {
		//	log.debug("starting of the method save");
			//sessionFactory.getCurrentSession().save(product);
		//	log.debug("ending of the method save");
		//	return true;
	//	} catch (Exception e) {
		//	log.error("exception occurred in save method" + e.getMessage());
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//	return false;
	//	}
        
	//}
	
	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}
    
	public boolean update(Product product){
		try {
			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(product);
			log.debug("ending of the method update");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in update method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
    
	public boolean delete(Product product) {
		try {
			log.debug("starting of the method delete");
			sessionFactory.getCurrentSession().delete(product);
			log.debug("starting of the method delete");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in delete method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public  Product get(String id){
	
		log.debug("starting of the method get");
		log.info("trying to get product based on id:"+id);
		String hql = "from Product where id = "+"'"+id+"'";
		
		log.info("the hsql query is:" +hql);
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Product> list = query.list();
		
		if(list==null || list.isEmpty())
		{
			log.info("no products are available with this id:" + id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Product> list(){
		
		log.debug("starting of the method list");
		String hql = "from Product";
		
		sessionFactory.getCurrentSession().createQuery(hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of the method list");
		//return query.list();
		List<Product> list = query.list();
		if(list==null || list.isEmpty())
		{
			log.info("no products are available");
		}
		return list;
		
		
		
		
	}
	
	@Transactional
	public Product getByName(String name) {
		log.debug("start : calling getByName");
		String hql = "from Product where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();
		
		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}
		log.debug("end : calling getByName");
		return null;
	}

	
	



}
