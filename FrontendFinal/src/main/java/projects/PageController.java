package projects;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import projects.CategoryClass.Category;
import projects.CategoryClass.Customer;
import projects.CategoryClass.Product;
import projects.CategoryClass.Supplier;
import projects.Categorydaoimp.CategoryDao;
import projects.Categorydaoimp.ProductDao;
import projects.Categorydaoimp.SupplierDao;

@Controller
public class PageController {

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	SupplierDao supplierDao;

	@Autowired
	ProductDao productDao;
	
	@RequestMapping(value = "/cart")
	public String showcart() {
		System.out.println("cart controller");
		return "cart";
	}

	@RequestMapping(value = "/loginerror")
	public String loginFailed(Model model) {
		model.addAttribute("error", "Invalid credentials..");
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(Model model) {
		model.addAttribute("error", "logout successfully");
		return "login";
	}

	@RequestMapping(value = "/login")
	public String showlogin() {
		System.out.println("login controller");
		return "login";
	}
	
	@RequestMapping(value = "/aboutus")
	public String showaboutus() {
		System.out.println("aboutus controller");
		return "aboutus";
	}

	@RequestMapping(value = "/registration")
	public String showregistration(Model model) {
		System.out.println("registration controller");
		model.addAttribute("customer", new Customer());

		return "registration";
	}

	@RequestMapping(value = "/admin/views")
	public String showCategory() {
		System.out.println("page controller");
		return "category";
	}

	@RequestMapping(value = "/viewcategorylist")
	public String showCategoryList(Model model) {

		List<Category> list = categoryDao.ListCategory();
		model.addAttribute("getListOfCategories", list);
		return "category";

	}

	@RequestMapping(value = "/admin/product")
	public String showProduct(Model m) {
		List<Category> categories = productDao.ListCategory();
		
//		List<Supplier> supplierss = productDao.ListSupplier();		
	//	m.addAttribute("suppliers", supplierss);
		m.addAttribute("pro", new Product());
		m.addAttribute("categories", categories);
		
		return "product";
	}

	@RequestMapping(value = "/admin/supplier")
	public String showSupplieer() {
		return "supplier";
	}
	
	@RequestMapping(value = "/home")
	public String showhome(HttpSession session,@AuthenticationPrincipal Principal principal) {
		session.setAttribute("categoriess", productDao.ListCategory());
		if(principal!=null) {
			String email=principal.getName();
		}
		return "home";
	}

	@RequestMapping(value = "/viewSupplierlist")
	public String showSupplierList(Model model) {

		List<Supplier> list = supplierDao.getAllSupplier();
		model.addAttribute("getListOfSupplier", list);
		return "viewsupplier";

	}

}
