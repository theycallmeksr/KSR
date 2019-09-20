package projects.CategoryClass;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int supplierId;
	private String supplierName;
	private String supplierMobileNumber;	
	private String supplierAddress;
	
	//@OneToMany(mappedBy = "supplier")
	//private List<Product> produc;
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	public String getSupplierMobileNumber() {
		return supplierMobileNumber;
	}
	public void setSupplierMobileNumber(String supplierMobileNumber) {
		this.supplierMobileNumber = supplierMobileNumber;
	}
	public String getSupplierAddress() {
		return supplierAddress;
	}
	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}
	
	

}
