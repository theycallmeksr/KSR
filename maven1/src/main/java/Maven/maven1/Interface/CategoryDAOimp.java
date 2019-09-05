package Maven.maven1.Interface;

import java.util.Locale.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDAOimp implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addCategory(Category category)
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(category);
		return true;
		}
		catch (Exception e)
		{
		return false;
		}
	}

	/*public boolean deleteCategory(Category category)
	{
		sessionFactory.getCurrentSession().delete(category);
		return true;
	}

	public boolean updateCategory(Category category) 
	{
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		return null;
	}

	public Category getCategory(int CategoryId) {
		// TODO Auto-generated method stub
		return null;
	}*/
	
}