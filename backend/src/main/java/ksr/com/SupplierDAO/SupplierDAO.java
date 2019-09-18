package ksr.com.SupplierDAO;
import java.util.List;
import ksr.com.Supplier.supplier;
public interface SupplierDAO 
{
	public boolean addSupplier(supplier Supplier);
	public boolean deleteSupplier(supplier Supplier);
	public boolean updateSupplier(supplier Supplier);
	public supplier getSupplier(int supplierId);
	public List<supplier> listSuppliers();
}
