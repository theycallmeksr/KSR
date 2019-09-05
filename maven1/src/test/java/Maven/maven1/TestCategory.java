/*package Maven.maven1;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Maven.maven1.Interface.CategoryDAO;
import junit.framework.TestCase;

public class TestCategory extends TestCase
{
	CategoryDAO categorydao;
	@BeforeClass
	public static void init()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContex(Category.class,category.class);
		CategoryDAO categorydoa = (CategoryDAO) context.getBean("categoryDao");
	}
	@Test
	public void testAddCategory()
	{
		Maven.maven1.Model.category category = new Category();
		category.setCategoryName("HP Laptop");
		category.getCategoryDesc("Best Quality Products");
		assertTrue("Succesfully added a category inside the table", categorydao.addCategory(category));
	}
}
*/