package projects;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import projects.CategoryClass.Category;
import projects.CategoryClass.Product;

import projects.Categorydaoimp.CategoryDao;
import projects.Categorydaoimp.ProductDao;

@Controller
public class ProductController {

	@Autowired
	ProductDao productdao;

	@Autowired
	CategoryDao categorydao;
	
	@RequestMapping(value="/all/getproductview/{productId}")
	public String getProductview(@PathVariable int productId,Model model){
		
		Product product=productdao.getProduct(productId);
		model.addAttribute("productObj",product);
		return "viewproductform";
	}
	
	@RequestMapping(value="/admin/delete-gly/getallproducts/{productId}")
	public String getAllProductsglyp(@PathVariable int productId,Model model){
		
		Product product = productdao.getProduct(productId);
		productdao.deleteProduct(product);
		
		List<Product> products=productdao.ListProduct();
		
		model.addAttribute("productsList",products);
		
		return "listofproducts";
	}
	
	
	@RequestMapping(value="/all/getallproducts")
	public String getAllProducts(Model model){
		List<Product> products=productdao.ListProduct();
		
		model.addAttribute("productsList",products);
		
		return "listofproducts";
	}	
	
	@RequestMapping(value="/all/getproduct/{id}")
	public String getProduct(@PathVariable int id,Model model){
		Product product=productdao.getProduct(id);
		model.addAttribute("productObj",product);
		return "viewproduct";
	}
	

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public String addproduct(@Valid @ModelAttribute("pro") Product product, BindingResult result, Model model,HttpServletRequest request) {
		System.out.println("ADDPRODUCT");
		if (result.hasErrors()) {
			
			model.addAttribute("categories", productdao.ListCategory());
			//model.addAttribute("suppliers", productdao.ListSupplier());
			System.out.println("result error");
			return "product";
		}

		// model.addAttribute("Product", new Product());

		productdao.addProduct(product);

		// List<Product> listproduct = productdao.ListProduct();
		// model.addAttribute("ProductList", listproduct);

		// List<Category> categories = productdao.ListCategory();
		// model.addAttribute("categories", categories);

		//List<Supplier> supplierss = productDao.ListSupplier();		
		//m.addAttribute("suppliers", supplierss);
		
		MultipartFile img = product.getImage();
		System.out.println(request.getServletContext().getRealPath("/"));
		// define a path
		Path path = Paths.get(request.getServletContext().getRealPath("/") + "/WEB-INF/resources/images/"
				+ product.getProductId() + ".png");
		// transfer the image to the file
		if (!img.isEmpty() && img != null) {
			try {
				img.transferTo(new File(path.toString()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "redirect:/getallproducts";
	}

	@RequestMapping(value = "/admin/deleteProduct/{productId}")
	public String deleteproduct(@PathVariable int productId, Model m, HttpServletRequest request) {

		Product product = productdao.getProduct(productId);

		productdao.deleteProduct(product);

		// m.addAttribute("Product", new Product());

		// List<Category> categories = productdao.ListCategory();
		// m.addAttribute("categories", categories);

		// List<Product> products=productdao.ListProduct();
		// m.addAttribute("ProductList", products);

		Path path = Paths.get(request.getServletContext().getRealPath("/") + "/WEB-INF/resources/images/"+productId+".png");
		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// return "product";
		return "redirect:/getallproducts";

	}

	@RequestMapping(value = "/getallproducts")
	public String getproduct(Model model) {

		model.addAttribute("pro", new Product());

		List<Category> categories = productdao.ListCategory();

		model.addAttribute("categories", categories);

		/*
		 * List<Supplier> supplierss = productdao.ListSupplier();
		 * model.addAttribute("suppliers", supplierss);
		 */
		
		List<Product> products = productdao.ListProduct();

		model.addAttribute("ProductList", products);
		return "product";
	}

	@RequestMapping(value = "/admin/editProduct/{productId}")
	public String editproduct(@PathVariable("productId") int productId, Model m) {

		Product product = productdao.getProduct(productId);

		m.addAttribute("Product", new Product());
		
		/*
		 * List<Supplier> supplierss = productdao.ListSupplier();
		 * m.addAttribute("suppliers", supplierss);
		 */

		m.addAttribute("Product", product);

		m.addAttribute("categories", productdao.ListCategory());
		return "productupdate";

	}

	@RequestMapping(value = "/admin/updateproduct", method = RequestMethod.POST)
	public String Updateproduct(@Valid @ModelAttribute("Product") Product product, BindingResult result, Model m,HttpServletRequest request) {

		if (result.hasErrors()) {
			m.addAttribute("categories", productdao.ListCategory());
			return "product";
		}

		productdao.updateProduct(product);

		MultipartFile img = product.getImage();
		System.out.println(request.getServletContext().getRealPath("/"));
		Path path = Paths.get(request.getServletContext().getRealPath("/") + "/WEB-INF/resources/images/"
				+ product.getProductId() + ".png");

		if (!img.isEmpty() && img != null) {
			System.out.println("Image is empty");
			try {
				img.transferTo(new File(path.toString()));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return "redirect:/getallproducts";
	}
}
