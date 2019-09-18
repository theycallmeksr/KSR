package ksr.com.Controller;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ksr.com.Cart.*;
import ksr.com.CartDAO.*;
import ksr.com.OrderDetails.*;
import ksr.com.OrderDetailsDAO.*;

@Controller
public class OrderController {
	
	@Autowired
	CartDAO cartDAO;
	
	@Autowired
	OrderDetailsDAO orderDAO;
	
	@RequestMapping(value="/cart")
	public String ShowCart(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<cart>listCart=cartDAO.listCart(username);
		m.addAttribute("listCart",listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));
		return "Cart";
	}
	
	@RequestMapping("/Payment")
	public String showPaymentPage(Model m, HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		List<cart>listCart=cartDAO.listCart(username);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));	
		return "Payment";
	}

	@RequestMapping(value="/receipt",method=RequestMethod.POST)
	public String showReceipt(@RequestParam("pmode")String pmode,Model m, HttpSession session )
	{
		String username=(String)session.getAttribute("username");
		List<cart>listCart=cartDAO.listCart(username);
		orderDetails Order=new orderDetails();
		Order.setUsername(username);
		Order.setOrderDate(new java.util.Date());
		Order.getOrderId();
		Order.setPmode(pmode);
		Order.setTotalAmount(this.calGrandTotalPrice(listCart));
		orderDAO.saveOrder(Order);
		int orderId = Order.getOrderId();
		System.out.println(orderId);
		orderDAO.updateCart(username, Order.getOrderId());
		m.addAttribute("orderData",orderId);
	   // m.session.setAttribute("order", orderId);
		m.addAttribute("listCart", listCart);
		m.addAttribute("grandTotal", this.calGrandTotalPrice(listCart));		
		return "Receipt";
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