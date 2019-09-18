package Maven.backend;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.Category.*;
import ksr.com.CategoryDAO.*;
import ksr.com.Product.*;
import ksr.com.ProductDAO.*;
import ksr.com.UserDetails.*;
import ksr.com.UserDetailsDAO.*;

public class ManualTest 
{
	public static void main(String arg[])
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("ksr.com");
		context.refresh();
		CategoryDAO categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
		category Category=new category();
		Category.setCategoryName("SamsungMobile");
		Category.setCategoryDesc("All Variety of Samsung Mobile");
		categoryDAO.addCategory(Category);
		ProductDAO productDAO = (ProductDAO)context.getBean("productDAO");
		product Product = new product();
		Product.setProductName("Samsung J7");
		Product.setProductDesc(" mobile with 4G and 13MP Back camera");
		Product.setPrice(12000);
		Product.setStock(50);
		Product.setCategoryId(2);
		Product.setSupplierId(1);
		productDAO.addProduct(Product);
	}
}