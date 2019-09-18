package Maven.backend;
import static org.junit.Assert.*;
import java.util.List;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ksr.com.Category.*;
import ksr.com.CategoryDAO.*;

public class CategoryDAOtest 
{
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("ksr.com");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}

	@Ignore
	@Test
	public void addCategoryTest()
	{
		category Category=new category();
		Category.setCategoryName("Samsung mobile");
		Category.setCategoryDesc("All Samsung  Smart Phone Mobile");
		assertTrue("Problem in adding the Category ",categoryDAO.addCategory(Category));	}
	
	@Ignore
	@Test
	public void getCategoryTest()
	{
		assertNotNull("Problem in get Category",categoryDAO.getCategory(1));
	}
	
	@Ignore 
	@Test
	public void deleteCategoryTest()
	{
		category Category=categoryDAO.getCategory(2);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(Category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		category Category=categoryDAO.getCategory(1);
		Category.setCategoryName(" xiomi mobile Phone");
		assertTrue("Problem in Updation",categoryDAO.updateCategory(Category));
	}
    @Test
	public void listCategoriesTest()
	{
		List<category> listCategories=categoryDAO.listCategories();
		assertNotNull("No Categories",listCategories);
		
		for(category Category:listCategories)
		{
			System.out.print(Category.getCategoryId()+":::");
			System.out.print(Category.getCategoryName()+":::");
			System.out.println(Category.getCategoryDesc());
		}
	}
}