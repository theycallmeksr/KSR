package Maven.backend;
import org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.ProductDAO.*;
import ksr.com.Category.*;
import ksr.com.Product.*;

public class ProductDAOtest 
{
	static ProductDAO productDAO;

	@BeforeClass
	public static  void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	//@Ignore
	@Test
	public void addProductUnitTest()
	{
		product Product = new product();
		Product.setProductName("Nexus 5");
		Product.setProductDesc(" mobile with 4G connectivity and 8MP Back camera, 1.3MP Front Camera");
		Product.setPrice(24049);
		Product.setStock(10);
		Product.setCategoryId(1);
		Product.setSupplierId(2);
		assertTrue("Problem in adding the Category ",productDAO.addProduct(Product));
	}
	
	@Ignore
	@Test
	public void deleteProductTest()
	{
		product product=productDAO.getProduct(38);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    
	@Ignore
	@Test
	public void updateProductTest()
	{
		product Product=productDAO.getProduct(36);
		Product.setProductName(" xiomi mobile Phone");
		assertTrue("Problem in Updation",productDAO.updateProduct(Product));
	}
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in getting 	Product",productDAO.getProduct(36));
	}
	
	@Ignore
	@Test
	public void listProductTest()
	{
		List<product> listProducts=productDAO.listProducts();
		assertNotNull("No Categories",listProducts);
		
		for(product Product:listProducts)
		{
			System.out.print(Product.getProductid()+":::");
			System.out.print(Product.getProductName()+":::");
			System.out.println(Product.getProductDesc());
		}
	}
    
	
}
