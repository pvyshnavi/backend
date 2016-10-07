package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcart.model.UserDetails;

@Transactional
@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{
	
	private static final Logger log = LoggerFactory.getLogger(UserDetailsDAOImpl.class);
	
	//private static final Logger log = LoggerFactory.getLogger("com.niit.shoppingcart.dao")
	
    @Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl( SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    
	//public boolean save(UserDetails userDetails) {
		//try {
		//	log.debug("starting of the method save");
		//	sessionFactory.getCurrentSession().save(userDetails);
		//	log.debug("ending of the method save");
		//	return true;
		//} catch (Exception e) {
			//log.error("exception occurred in save method" + e.getMessage());
			// TODO Auto-generated catch block
			//e.printStackTrace();
		//	return false;
		//}
        
//	}
	
	@Transactional
	public boolean saveOrUpdate(UserDetails userDetails) {
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
		
		return true;

	}
    
	//public boolean update(UserDetails userDetails){
		//try {
		//	log.debug("starting of the method update");
		//	sessionFactory.getCurrentSession().update(userDetails);
		//	log.debug("ending of the method update");
		//	return true;
		//} catch (Exception e) {
		//	log.error("exception occurred in update method" + e.getMessage());
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		//return false;
	//} 
    
	public boolean delete(UserDetails userDetails) {
		try {
			log.debug("starting of the method delete");
			sessionFactory.getCurrentSession().delete(userDetails);
			log.debug("endinging of the method delete");
			return true;
		} catch (Exception e) {
			log.error("exception occurred in delete method" + e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public  UserDetails get(String id){
	    
		log.debug("starting of the method get");
		log.info("trying to get userdetails based on id:"+id);
		String hql = "from UserDetails where id = '"+id+"'";
		
		log.info("the hsql query is:" +hql);
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{}}"+query);
		
		for(Object k : query.list())
		{
			System.out.println(k);
		}
		
		@SuppressWarnings("unchecked")
		
		
		
		List<UserDetails> list = query.list();
		
	
			
			
	
		if(list==null || list.isEmpty())
		{
			log.info("no userdetail are available with this id:" + id);
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<UserDetails> list(){
		
		log.debug("starting of the method list");
		String hql = "from UserDetails";
		
		sessionFactory.getCurrentSession().createQuery(hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		log.debug("ending of the method list");
		//return query.list();
		List<UserDetails> list = query.list();
		if(list==null || list.isEmpty())
		{
			log.info("no userdetail are available");
		}
		return list;
	
		
		
		
	}
	@Transactional
	public boolean isValidUser(String id, String password) {
	
		//System.out.println("d1");
		String hql = "FROM UserDetails where id ='" + id + "' and " + " password= '" + password+"'";
		
		//System.out.println("d1");
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		//System.out.println("d1342");
		@SuppressWarnings("unchecked")
		List<UserDetails> list = (List<UserDetails>) query.list();
		
		if (list != null && !list.isEmpty()) {
			return true;
		}
		else
			return false;
	
	}
	
}
