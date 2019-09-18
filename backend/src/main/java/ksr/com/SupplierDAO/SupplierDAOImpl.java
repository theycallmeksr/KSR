package ksr.com.SupplierDAO;
import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ksr.com.Supplier.supplier;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO
{
	@Autowired
	SessionFactory sessionFactory; 
	
	public boolean addsupplier(supplier Supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(Supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}


	public boolean deletesupplier(supplier Supplier ) 
	{
		try
		{
		sessionFactory.getCurrentSession().delete(Supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	
	public boolean updatesupplier(supplier Supplier) 
	{
		try
		{
		sessionFactory.getCurrentSession().update(Supplier);
		return true;	
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public supplier getsupplier(int supplierId) 
	{
		Session session=sessionFactory.openSession();
		supplier supplier=(supplier)session.get(supplier.class,supplierId);
		session.close();
		return supplier;
	}

	public List<supplier> listSuppliers() 
	{
		Session session=sessionFactory.openSession();
		List<supplier> listSuppliers=(List<supplier>)session.createQuery("from Supplier").list();
		session.close();
		return listSuppliers;
	}


	public boolean addSupplier(supplier Supplier) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean deleteSupplier(supplier Supplier) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean updateSupplier(supplier Supplier) {
		// TODO Auto-generated method stub
		return false;
	}


	public supplier getSupplier(int supplierId) {
		// TODO Auto-generated method stub
		return null;
	}	
}