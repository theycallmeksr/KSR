package ksr.com.UserDetailsDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ksr.com.Product.product;
import ksr.com.UserDetails.userDetails;

@Repository("userDAO")
@Transactional

public class UserDetailsDAOImpl  implements  UserDetailsDAO
{
  @Autowired
  SessionFactory sessionFactory;
	public boolean registeruserDetails(userDetails UserDetails) 
	{
		try 
		{
			sessionFactory.getCurrentSession().save(UserDetails);
		
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteuserDetails(userDetails UserDetails) 
	{
		try 
		{
			sessionFactory.getCurrentSession().delete(UserDetails); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}	
	}

	public boolean updateuserDetails(userDetails UserDetails)
	{
		try 
		{
			sessionFactory.getCurrentSession().update(UserDetails); 
				
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public List<userDetails> listUserDetails() {
		
		Session session=sessionFactory.openSession();
		List<userDetails> listUserDetails=(List<userDetails>)session.createQuery("from UserDetail").list();
		session.close();
		return  listUserDetails;
	}

	
	public userDetails getuserDetails(String username) 
	
	{
		Session session=sessionFactory.openSession();
		userDetails user=(userDetails)session.get(userDetails.class,username);
		session.close();
		return user;
	}

	public boolean registerUser(userDetails UserDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteUser(userDetails UserDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateUser(userDetails UserDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	public userDetails getUser(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
