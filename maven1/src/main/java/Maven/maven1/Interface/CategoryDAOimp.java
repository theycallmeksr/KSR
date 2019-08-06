package Maven.maven1.Interface;

import java.util.Locale.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDao")
public class CategoryDAOimp implements CategoryDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	public boolean addCategory(Category category)
	{
		sessionFactory.getCurrentSession().save(category);
		return true;
	}
}