package Maven.backend;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.Supplier.*;
import ksr.com.SupplierDAO.*;

public class SupplierDAOtest 
{
	static SupplierDAO supplierDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}

	
		@Test
		public void addSupplierTest()
		{
			supplier Supplier=new supplier();
			Supplier.setSupplierName("google");
			Supplier.setSupplierDesc("ceo of google is : sundar and is present since 1995");
			assertTrue("Problem in adding the Category ",supplierDAO.addSupplier(Supplier));
		}

}
