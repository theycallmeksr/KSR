package ksr.com.ProductDAO;
import java.util.List;

import ksr.com.Product.product;
public interface ProductDAO 
{
	public boolean addProduct(product Product);
	public boolean deleteProduct(product Product);
	public boolean updateProduct(product Product);
	public product getProduct(int productId);
	public List<product> listProducts();
}
