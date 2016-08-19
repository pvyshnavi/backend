package com.niit.shoppingcart.dao;

import java.util.List;



import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.UserDetails;

@Transactional
@Repository("userDetailsDAO")
public class UserDetailsDAOImpl implements UserDetailsDAO{
	
    @Autowired
	private SessionFactory sessionFactory;

	public UserDetailsDAOImpl( SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}
    
	public boolean save(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().save(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
        
	}
    
	public boolean update(UserDetails userDetails){
		try {
			sessionFactory.getCurrentSession().update(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	} 
    
	public boolean delete(UserDetails userDetails) {
		try {
			sessionFactory.getCurrentSession().delete(userDetails);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	
	public  UserDetails get(String id){
	
		
		String hql = "from UserDetails where id = "+"'"+id+"'";
		
		
		Query query= sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<UserDetails> list = query.list();
		
		if(list==null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<UserDetails> list(){
		
		
		String hql = "from UserDetails";
		
		sessionFactory.getCurrentSession().createQuery(hql);
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
		
		
		
		
	}

}
