package projects.Categorydaoimp;

import java.util.List;

import projects.CategoryClass.CartItem;
import projects.CategoryClass.Customer;
import projects.CategoryClass.CustomerOrder;
import projects.CategoryClass.User;

public interface CartItemDao {
	
	void addToCart(CartItem cartItem);
	User getUser(String email);
	List<CartItem>  getCart(String email);
	void removeCartItem(int cartItemId);
	CustomerOrder createCustomerOrder(CustomerOrder customerOrder);

}
