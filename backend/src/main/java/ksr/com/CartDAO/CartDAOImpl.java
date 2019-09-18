package ksr.com.CartDAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksr.com.Cart.cart;
import ksr.com.UserDetails.userDetails;

@Repository("cartDAO")
@Transactional

public class CartDAOImpl implements CartDAO
{

	@Autowired
	SessionFactory sessionFactory;
	 
	public boolean addCart(cart Cart) 
	{
		
		try
		{
			sessionFactory.getCurrentSession().save(Cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
			
		}
	}

	 
	public boolean deleteCart(cart Cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(Cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}	
		
	}

	 
	public boolean updateCart(cart Cart) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(Cart);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
			
	}


	
	public cart getcart(int cardID) {
		
		Session session=sessionFactory.openSession();
		cart cart=session.get(cart.class,cardID);
		session.close();
		return cart;
		
	}


	public List<cart> listCart(String username)
	
	
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<cart> listCart=query.list();
		session.close();
		return  listCart;
	}


	public ksr.com.CartDAO.CartDAO getCartDAO(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}


	public ksr.com.UserDetailsDAO.UserDetailsDAO getUserDetailsDAO(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}


	public cart getCart(int cardId) {
		// TODO Auto-generated method stub
		return null;
	}

}