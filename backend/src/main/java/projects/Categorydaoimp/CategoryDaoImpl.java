package projects.Categorydaoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import projects.CategoryClass.Category;

@Repository("/CategoryDao")
@Transactional
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addCategory(Category category) {

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<Category> ListCategory() {
		Session s = sessionFactory.openSession();
		List<Category> ListCategory = s.createQuery("from Category").list();
		s.close();
		return ListCategory;
	}

	public boolean deleteCategory(Category category) {
		try {
		sessionFactory.getCurrentSession().delete(category);
			
		
			return true;

		} catch (Exception e) {

			return false;
		}
	}

	public boolean editcategory(Category category) {
		return false;
	}

	public Category getCategory(int categoryId) {
		Session s = sessionFactory.openSession();
		Category category = (Category) s.get(Category.class, categoryId);
		s.close();
		return category;
	}

	public boolean updateCategory(Category category) {

		try {

			sessionFactory.getCurrentSession().saveOrUpdate(category);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
		
}