package ksr.com.OrderDetailsDAO;
import java.util.List;

import ksr.com.OrderDetails.orderDetails;
public interface OrderDetailsDAO
{
	public boolean saveOrder(orderDetails OrderDetail);
	public boolean updateCart(String username, int orderId);
}