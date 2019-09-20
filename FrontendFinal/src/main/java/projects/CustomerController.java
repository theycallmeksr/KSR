package projects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.CategoryClass.Customer;
import projects.Categorydaoimp.CustomerDao;



@Controller
public class CustomerController {
	
	@Autowired
	CustomerDao customerDao;
	
	
	@RequestMapping(value="/all/registercustomer")
	public String registerCustomer(@ModelAttribute(value="customer") Customer customer,Model model){

		//CHECK if Email is unique
		if(!customerDao.isEmailUnique(customer.getUser().getEmail())){
			model.addAttribute("error","Email id already exists.. please choose different email id");
			return "registrationform";
		}
		
		//Call DAO to persist customer details
		customerDao.registerCustomer(customer);
		return "login";
	}

}
