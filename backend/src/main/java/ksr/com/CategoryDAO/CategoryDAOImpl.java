package ksr.com.CategoryDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ksr.com.Category.category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	public boolean addCategory(category categ)
	{
		try
		{
			sessionFactory.getCurrentSession().saveOrUpdate(categ);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
	public boolean updateCategory(category categ) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(categ);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public boolean deleteCategory(category categ) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(categ);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public category getCategory(int categoryId) 
	{
		Session session = sessionFactory.openSession();
		category category = (category) session.get(category.class, categoryId);
		System.out.println("Gets the Category");
		session.close();
		return category;
	}
	
	public List<category> listCategories() 
	{
		Session session = sessionFactory.openSession();
		List <category> listCategories = session.createQuery("from Category").list(); 
		session.close();
		return listCategories;
	}
		
}
