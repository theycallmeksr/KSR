package projects.Categorydaoimp;

import java.util.List;

import projects.CategoryClass.Category;
import projects.CategoryClass.Product;
import projects.CategoryClass.Supplier;

public interface ProductDao {
	
	public boolean addProduct(Product product);
	
	public boolean deleteProduct(Product productId);
	 public boolean editProduct(Product product); 
	 public Product getProduct(int productId);
	 public List<Product> ListProduct();
	 public boolean updateProduct(Product product);
	 public List<Category> ListCategory();
	 public List<Supplier> ListSupplier();

}
