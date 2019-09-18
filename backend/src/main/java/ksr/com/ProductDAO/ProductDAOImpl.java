package ksr.com.ProductDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ksr.com.Category.category;
import ksr.com.Product.product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	public boolean addproduct(product Product) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(Product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean deleteproduct(product Product) {
		try 
		{
			sessionFactory.getCurrentSession().delete(Product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateproduct(product Product) {
		try 
		{
			sessionFactory.getCurrentSession().saveOrUpdate(Product); 
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public product getproduct(int productId) {
		Session session=sessionFactory.openSession();
		product product=(product)session.get(product.class,productId);
		session.close();
		return product;
	}
	public List<product> listProducts() 
	{
		Session session=sessionFactory.openSession();
		List<product> listProducts=(List<product>)session.createQuery("from Product").list();
		session.close();
		return listProducts;
	}

	public boolean addProduct(product Product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteProduct(product Product) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateProduct(product Product) {
		// TODO Auto-generated method stub
		return false;
	}

	public product getProduct(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
}