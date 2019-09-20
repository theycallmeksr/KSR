package projects.Categorydaoimp;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import projects.CategoryClass.Supplier;


@Repository("/SupplierDao")
@Transactional
public class SupplierDaoImpl implements SupplierDao {
	
	@Autowired
	SessionFactory sessionfactory;

	public boolean addSupplier(Supplier supplier) {
		sessionfactory.getCurrentSession().saveOrUpdate(supplier);
		return true;
	}

	
	public List<Supplier> getAllSupplier() {
		Session session=sessionfactory.openSession();
		List<Supplier> listsupplier=session.createQuery("from Supplier").list();
		session.close();
		return listsupplier;
	}

	
	public Supplier getSupplierById(int supplierId) {
        Session session=sessionfactory.openSession();
		Supplier supplier=(Supplier) session.get(Supplier.class,supplierId);
		session.close();
		return supplier;
	}

	
	public boolean deleteSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		
		catch(Exception e) {
			System.out.println("exception in delete suplier : "+e);
			return false;
		}
	}

	
	public boolean updateSupplier(Supplier supplier) {
		try {
			sessionfactory.getCurrentSession().saveOrUpdate(supplier);
		return true;	
		}
		catch(Exception e) {
			
			System.out.println("exceeption in update supplier : "+e);
			
			return false;
		}
	}

	
	
	

}
