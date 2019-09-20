package projects.Categorydaoimp;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import projects.CategoryClass.Authorities;
import projects.CategoryClass.Customer;
import projects.CategoryClass.User;



@Repository
@Transactional
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	SessionFactory sessionFactory;
	
	public void registerCustomer(Customer customer) {
		Session session=sessionFactory.getCurrentSession();
		   
		   customer.getUser().setEnabled(true);
		   
		   System.out.println(customer.getUser().getAuthorities());
		   
		
		   Authorities authorities=new Authorities();
		   authorities.setRole("ROLE_USER");
		  
		   customer.getUser().setAuthorities(authorities);
		   
		   authorities.setUser(customer.getUser());
		   
		   
		   session.save(customer);
		
		
	}

	
	public boolean isEmailUnique(String email) {
		
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, email);
		if(user==null)
			return true;
			else
				return false;
	}

}
