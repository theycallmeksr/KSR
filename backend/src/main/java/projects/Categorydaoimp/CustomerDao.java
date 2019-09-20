package projects.Categorydaoimp;

import projects.CategoryClass.Customer;



public interface CustomerDao {

	void registerCustomer(Customer customer);
	boolean isEmailUnique(String email);
}
