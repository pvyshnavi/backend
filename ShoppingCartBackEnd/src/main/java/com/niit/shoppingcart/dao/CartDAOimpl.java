package com.niit.shoppingcart.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcart.model.Cart;

@Transactional
@Repository("cartDAO")
public class CartDAOimpl implements CartDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	Cart cart;
	
	public CartDAOimpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Cart> list() {
		
		@SuppressWarnings("unchecked")
		List<Cart> list = sessionFactory.getCurrentSession().createCriteria(Cart.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
		return list;
	}


	
	
	public Cart get(int id) {
		String hql = "from Cart where id = '" + id + "' and status = 'N'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		
		@SuppressWarnings("unchecked")
		List<Cart> list = query.list();
		
		if(list!=null && !list.isEmpty()) {
			
			return list.get(0);
		}
		return null;
	}

	
	public void saveOrUpdate(Cart cart) {
		sessionFactory.getCurrentSession().saveOrUpdate(cart);
		
	}
	
	public String delete(int id) {
		Cart cartToDelete = new Cart();
		cartToDelete.setId(id);
		
		
			try {
				sessionFactory.getCurrentSession().delete(cartToDelete);
			} catch (HibernateException e) {
				
				e.printStackTrace();
				return e.getMessage();
			}
		
		return null;
	}

	public long getTotal(String id) {
String hql = "select sum(price) from Cart where user_ID = '" + id + "' and status = 'N'";
		
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
         
          @SuppressWarnings("rawtypes")
		List list = query.list();
          long total = (Long) list.get(0);
          if(list!=null && !list.isEmpty()) {
		return total;
          }
          return 0;
	}
	
}
