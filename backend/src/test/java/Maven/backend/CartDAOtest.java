package Maven.backend;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.CartDAO.*;
import ksr.com.Cart.*; 

public class CartDAOtest 
{
	static CartDAO cartDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		
		cartDAO=(CartDAO)context.getBean("cartDAO");
	}

	
	@Test
	
	public void addCartTest()
	{
		cart Cart=new cart();
		Cart.setProductName("Redmi");
		Cart.setCartId(185);
		Cart.setPrice(15650);
		Cart.setProductId(7003);
		Cart.setQuantity(6);
		Cart.setUsername("Ram");
		assertTrue("Problem in adding the Cart ",cartDAO.addCart(Cart));	
		}
	
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Cart",cartDAO.getCart(1));
	}
	
	@Ignore 
	@Test
	public void deleteCartTest()
	{
		cart Cart=cartDAO.getCart(2);
		assertTrue("Problem in Deletion:",cartDAO.deleteCart(Cart));
	}
	@Ignore
	@Test
	public void updateCartTest()
	{
		cart Cart=cartDAO.getCart(1);
		Cart.setCartId(8);
		assertTrue("Problem in Updation",cartDAO.updateCart(Cart));
	}

	@Ignore
	@Test
	public void listCartTest()
	{
		List<cart> listCart=cartDAO.listCart("Ram");
		assertNotNull("No Cart",listCart);
		
		for(cart Cart:listCart)
		{
			System.out.print(Cart.getCartId()+":::");
			System.out.print(Cart.getProductid()+":::");
			System.out.println(Cart.getPaymentStatuse()+":::");
			System.out.println(Cart.getPrice()+":::");
			System.out.println(Cart.getProductName()+":::");
			System.out.println(Cart.getQuantity()+":::");
			System.out.println(Cart.getUsername()+":::");
		}
	}
	
}