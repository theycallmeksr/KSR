package Maven.backend;
import junit.framework.TestCase;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.UserDetailsDAO.*;
import ksr.com.UserDetails.*;

public class UserDetailsDAOtest {
	static UserDetailsDAO userDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("ksr.com");
		context.refresh();
		
		userDAO=(UserDetailsDAO)context.getBean("userDAO");
	}
	

	@Test
	public  void registerUser() 
	{
		userDetails user=new userDetails();
		
		user.setMobileNo("9087558324");
		user.setPassword("123");
		user.setCustomerName("jlokish");
		user.setAddr("poonamallee");
		user.setRole("Admim");
		user.setEnabled(true);
		user.setCustomerName("sumathi ramamoorthy ");
		
		assertTrue("Problem in User Insertion",userDAO.registerUser(user));
	
	}
	
	@Ignore
	@Test
	public  void deleteUser() 
	{
		//UserDetail user=userDAO.getUser("1256");
		//assertTrue("Problem in Deletion:",userDAO.deleteUser(user));
	}
	
	@Ignore
	@Test
	public  void updateUser() 
	{

		//UserDetail user=userDAO.getUser("ravi");
	  //  user.setAddr("Anna Nagar");
		//assertTrue("Problem in Updation",userDAO.updateUser(user));
	}
	
	


}