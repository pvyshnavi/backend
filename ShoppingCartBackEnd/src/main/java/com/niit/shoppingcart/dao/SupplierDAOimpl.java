package com.niit.shoppingcart.dao;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcart.model.Supplier;



@Transactional
@Repository("supplierDAO")
public class SupplierDAOimpl implements SupplierDAO{
	
	private static final Logger log = LoggerFactory.getLogger(SupplierDAOimpl.class);
	
	//private static final Logger log = LoggerFactory.getLogger("com.niit.shoppingcart.dao")
	
	
	@Autowired
	private SessionFactory sessionFactory;

	public SupplierDAOimpl( SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    
	public boolean save(Supplier supplier) {
		try {
			log.debug("starting of the method save");
			sessionFactory.getCurrentSession().save(supplier);
			log.debug("ending of the method save");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in save method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        
	}
    
	public boolean update(Supplier supplier){
		try {
			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(supplier);
			log.debug("ending of the method update");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in update method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
    
	public boolean delete(Supplier supplier) {
		try {
			log.debug("starting of the method delete");
			sessionFactory.getCurrentSession().delete(supplier);
			log.debug("ending of the method delete");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in delete method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public  Supplier get(String id){
		
		log.debug("starting of the method save");
		log.info("trying to get supplier based on id:"+id);
		String hql = "from Supplier where id = "+"'"+id+"'";
		
		log.info("the hsql query is:" +hql);
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Supplier> list = query.list();
		
		if(list==null || list.isEmpty())
		{
			log.info("no supplier are available with this id:" + id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Supplier> list(){
		
		log.debug("starting of the method save");
		String hql = "from Supplier";
		
		sessionFactory.getCurrentSession().createQuery(hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("starting of the method save");
		//return query.list();
		List<Supplier> list = query.list();
		if(list==null || list.isEmpty())
		{
			log.info("no supplier are available");
		}
		return list;
	
		
		
		
	}
	
	@Transactional
	public Supplier getByName(String name) {
		log.debug("start : calling getByName");
		String hql = "from Supplier where name=" + "'"+ name+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Supplier> list = (List<Supplier>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		log.debug("End : calling getByName");
		return null;
	}
	
	


}
