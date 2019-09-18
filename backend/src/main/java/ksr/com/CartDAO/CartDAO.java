package ksr.com.CartDAO;
import java.util.List;
import ksr.com.Cart.cart;
public interface CartDAO 
{
	public boolean addCart(cart Cart);
	public boolean deleteCart(cart Cart);
	public boolean updateCart(cart Cart);
	public cart getCart(int cardId);
	public List <cart> listCart(String username);	
}