package projects.Categorydaoimp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import projects.CategoryClass.Category;
import projects.CategoryClass.Product;
import projects.CategoryClass.Supplier;


@Repository("/ProductDao")
@Transactional
public class ProductDaoImpl implements ProductDao {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean addProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	

	public boolean editProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Product getProduct(int productId) {
		Session s = sessionFactory.openSession();
		Product  product = ( Product) s.get( Product.class,  productId);
		s.close();
		return product;
	}

	public List<Product> ListProduct() {
		Session s = sessionFactory.openSession();
		List<Product> ListProduct = s.createQuery("from Product").list();
		s.close();
		return ListProduct;
	}

	public boolean updateProduct(Product product) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(product);
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


	
	public boolean deleteProduct(Product productId) {
		try {
			sessionFactory.getCurrentSession().delete(productId);
			return true;
			}
		catch (Exception e) {
				return false;
		}
		
	}
	
	
	public List<Supplier> ListSupplier() {
		Session s = sessionFactory.openSession();
		List<Supplier> ListSupplier = s.createQuery("from Supplier").list();
		s.close();
		return ListSupplier;
	}

}


