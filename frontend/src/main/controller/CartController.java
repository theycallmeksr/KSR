package ksr.com.Controller;
import java.util.List;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ksr.com.Cart.*;
import ksr.com.CartDAO.*;
import ksr.com.Product.*;
import ksr.com.ProductDAO.*;
import ksr.com.UserDetails.*;
import ksr.com.UserDetailsDAO.*;

@Controller
public class CartController 
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartDAO cartDAO;
	@Autowired
	UserDetailsDAO userDAO;
	
	@RequestMapping("/updateAddress")
	public String updateAddress(@RequestParam("address") String address,String usernane ,Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");	
		List<cart>listCart=cartDAO.listCart(username);
		userDetails user=userDAO.getUser(username);
		user.setAddr(address);
		userDAO.updateUser(user);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		m.addAttribute("addr",user.getAddr());
		return "OrderConfirm";
	}
	
	@RequestMapping("/addToCart/{productId}")
	public String addCart(@RequestParam("quantity")int quantity,@PathVariable("productId")int productId,Model m, HttpSession session)
	{
		product Product=productDAO.getProduct(productId);
		String username=(String)session.getAttribute("username");
		cart Cart=new cart();
		Cart.setProductId(Product.getProductid());
		Cart.setProductName(Product.getProductName());
		Cart.setPrice(Product.getPrice());
		Cart.setPaymentStatuse(username);
		Cart.setQuantity(quantity);
		Cart.setUsername(username);
		cartDAO.addCart(Cart);
		List<cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal",this.calGrandTotalPrice(listCart));
		return "Cart";
	}
	
	@RequestMapping("/deleteCart/{cartId}")
	public String deleteCart(@PathVariable("cartId")int cartId,Model m, HttpSession session)
	{
		cart Cart=cartDAO.getCart(cartId);
		cartDAO.deleteCart(Cart);
		String username=(String)session.getAttribute("username");
		List<cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		return "Cart";
	}

	@RequestMapping("/orderConfirm")
	public String orderConfirm(Model m, HttpSession session)
	{	
		String username=(String)session.getAttribute("username");
		System.out.println("from order confirm"+username);
		List<cart>listCart=cartDAO.listCart(username);
		userDetails user=userDAO.getUser(username);
		System.out.println("from cart contoller "+user);
		m.addAttribute("listCartItem",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		m.addAttribute("addr",user.getAddr());
		return "OrderConfirm";
	}

	@RequestMapping("/updateCart/{cartId}")
	public String updateCart(@PathVariable("cartId")int cartId,@RequestParam("quantity")int quantity,Model m, HttpSession session)
	{
		quantity++;
		cart Cart=cartDAO.getCart(cartId);
		Cart.setQuantity(quantity);
		cartDAO.updateCart(Cart);
		String username=(String)session.getAttribute("username");
		List<cart>listCart=cartDAO.listCart(username);		
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		return "Cart";
	}
	
	public int calGrandTotalPrice(List<cart> listCart)
	{
		int grandTotal=0;
		int count=0;
		while(count<listCart.size())
		{
			cart Cart=listCart.get(count);
			grandTotal=grandTotal+(Cart.getQuantity()*Cart.getPrice());
			count=count+1;
		}
		return grandTotal;
	}
}