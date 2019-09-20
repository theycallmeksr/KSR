package projects.Categorydaoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import projects.CategoryClass.CartItem;
import projects.CategoryClass.Customer;
import projects.CategoryClass.CustomerOrder;
import projects.CategoryClass.Product;
import projects.CategoryClass.User;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao{

	@Autowired
	SessionFactory sessionFactory;
	
	public void addToCart(CartItem cartItem) {
		System.out.println("Cart Details "+"====================="+cartItem.getCartItemId()+" "+cartItem.getQuantity()+" "+cartItem.getTotalPrice()+"  "+cartItem.getProduct()+"    "+cartItem.getUser());
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);		
		System.out.println("Cart Details "+"====================="+cartItem.getCartItemId()+" "+cartItem.getQuantity()+" "+cartItem.getTotalPrice()+"  "+cartItem.getProduct()+"    "+cartItem.getUser());
	}

	public User getUser(String email) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class,email);
		return user;
	}

	public List<CartItem> getCart(String email) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from CartItem where user.email=?");
		query.setString(0, email);
		List<CartItem> cartItems=query.list();
		return cartItems;
		
		/*
		 * Session s = sessionFactory.openSession(); List<Product> ListProduct =
		 * s.createQuery("from Product").list(); s.close(); return ListProduct;
		 */
	}

	public void removeCartItem(int cartItemId) {
		Session session=sessionFactory.getCurrentSession();
		CartItem cartItem=(CartItem)session.get(CartItem.class, cartItemId);
		session.delete(cartItem);
		
	}

	
	public CustomerOrder createCustomerOrder(CustomerOrder customerOrder) {
		Session session=sessionFactory.getCurrentSession();
		session.save(customerOrder);
		return customerOrder;
	}


	


}
