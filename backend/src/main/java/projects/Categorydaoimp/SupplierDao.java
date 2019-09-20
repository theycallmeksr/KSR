package projects.Categorydaoimp;

import java.util.List;

import projects.CategoryClass.Supplier;

public interface SupplierDao {
    public boolean addSupplier(Supplier supplier);
	public List<Supplier> getAllSupplier();
	public Supplier getSupplierById(int supplierId);
	public boolean deleteSupplier(Supplier supplier);
    public boolean updateSupplier(Supplier supplier);

}
