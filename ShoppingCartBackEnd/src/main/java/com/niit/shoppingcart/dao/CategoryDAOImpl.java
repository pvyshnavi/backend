package com.niit.shoppingcart.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Category;



@Transactional
@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static final Logger log = LoggerFactory.getLogger(CategoryDAOImpl.class);
	
	//private static final Logger log = LoggerFactory.getLogger("com.niit.shoppingcart.dao")
	
    @Autowired
	private SessionFactory sessionFactory;

	public CategoryDAOImpl( SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    
	public boolean save(Category category) {
		try {
			log.debug("starting of the method save");
			sessionFactory.getCurrentSession().save(category);
			log.debug("ending of the method save");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in save method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        
	}
    
	public boolean update(Category category){
		try {
			log.debug("starting of the method update");
			sessionFactory.getCurrentSession().update(category);
			log.debug("ending of the method update");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in update method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
    
    
	public boolean delete(Category category) {
		try {
			log.debug("starting of the method delete");
			sessionFactory.getCurrentSession().delete(category);
			log.debug("ending of the method delete");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in delete method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public  Category get(String id){
	
		log.debug("starting of the method get");
		log.info("trying to get category based on id:"+id);
		String hql = "from Category where id = "+"'"+id+"'";
		
		log.info("the hsql query is:" +hql);
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Category> list = query.list();
		
		if(list==null || list.isEmpty())
		{
			log.info("no category are available with this id:" + id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Category> list(){
		
		log.debug("starting of the method list");
		String hql = "from Category";
		
		sessionFactory.getCurrentSession().createQuery(hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of the method list");
		//return query.list();
	    List<Category> list = query.list();
	    if(list==null || list.isEmpty())
	    {
	    	log.info("no category are available");
	    }
	    return list;
		
		
		
	}
	
	@Transactional
	public Category getByName(String name) {
		log.debug("start : calling getByName");
		String hql = "from Category where name=" + "'"+ name +"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Category> listCategory = (List<Category>) query.list();
		
		if (listCategory != null && !listCategory.isEmpty()) {
			return listCategory.get(0);
		}
		log.debug("end : calling getByName");
		return null;
	}
	
	

}
