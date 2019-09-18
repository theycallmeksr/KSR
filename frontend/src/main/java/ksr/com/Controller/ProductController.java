package ksr.com.Controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ksr.com.Category.*;
import ksr.com.CategoryDAO.*;
import ksr.com.Product.*;
import ksr.com.ProductDAO.*;
import ksr.com.Supplier.*;
import ksr.com.SupplierDAO.*;

@Controller
public class ProductController {
	
 @Autowired
 CategoryDAO categoryDAO;
 
 @Autowired
 ProductDAO productDAO;
 
 @Autowired
 SupplierDAO supplierDAO;
 
 	@RequestMapping("/product")
 	public String showProduct(Model m)
 	{
 		product Product = new product();
 		m.addAttribute(Product);
 		List<product> listProducts=productDAO.listProducts();
 		m.addAttribute("productList",listProducts);
 		m.addAttribute("categoryList", this.GetCategories());
 		m.addAttribute("supplierList", this.GetSuppliers());
 		m.addAttribute("pageinfo","Manage Product");
 		return "Product";
 	}
 	
 	@RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
 	public String insertProduct(@ModelAttribute("product")product product,Model m,@RequestParam("pimage")MultipartFile filedet )
 	{
 		productDAO.addProduct(product);
 		product Product1 = new product();
 		m.addAttribute(Product1);
 		m.addAttribute("categoryList", this.GetCategories());
 		m.addAttribute("supplierList", this.GetSuppliers());
 		String imgpath= "C:\\Users\\J.Lokish\\eclipse-workspace\\GadgetKing\\Frontend\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
 		imgpath=imgpath+String.valueOf(product.getProductid())+".jpg";
 		File image=new File(imgpath);
 		if(!filedet.isEmpty())
 		{
 			try {
 				byte buff[]=filedet.getBytes();
 				FileOutputStream fos=new FileOutputStream(image);
 				BufferedOutputStream bs= new BufferedOutputStream(fos);
 				bs.write(buff);
 				bs.close();
 				}
 			catch(Exception e)
 				{
 				m.addAttribute("errorInfo","Error occured during Image uploading");
 				}
 		}
 		else 
 		{
 			m.addAttribute("errorInfo","Error occured trying to upload image");
 		}
	
    List<product> listProducts=productDAO.listProducts();
	m.addAttribute("productList",listProducts);
	m.addAttribute("pageinfo","Manage Product");
	  return "Product";
	}

	@RequestMapping(value="/productdisplay")
	public String displayallproducts(Model m)
	{
		List<product> listProducts=productDAO.listProducts();
		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Product Catalog");	
		return "productdisplay";
	}

	@RequestMapping(value="/totalproductdisplay/{productID}")
	public String totalproductdisplay(@PathVariable("productID")int productID,Model m)
	{
		m.addAttribute("pageinfo","Product Information");
		product Product=productDAO.getProduct(productID);
		m.addAttribute("product",Product);
		return "totalproductdisplay";
	}

	public LinkedHashMap<Integer,String> GetCategories()
	{
		List<category> listCategories=categoryDAO.listCategories();
		LinkedHashMap<Integer,String> categoryList=new LinkedHashMap<Integer,String>();
		for(category Category:listCategories)
		{
			categoryList.put(Category.getCategoryId(), Category.getCategoryName());
		}
		return categoryList;
	}

	public LinkedHashMap<Integer,String> GetSuppliers()
	{
		List<supplier> listSuppliers=supplierDAO.listSuppliers();
		LinkedHashMap<Integer,String> supplierList=new LinkedHashMap<Integer,String>();
		for(supplier Supplier:listSuppliers)
		{
			supplierList.put(Supplier.getSupplierId(), Supplier.getSupplierName());
		}
		return supplierList;
         
	}

	@RequestMapping(value="/UpdateProduct",method=RequestMethod.POST)
	public String updateProduct(@ModelAttribute("product")product product,Model m)
	{ 
		m.addAttribute("categoryList", this.GetCategories());
		m.addAttribute("supplierList", this.GetSuppliers());
		productDAO.updateProduct(product);
		product Product1=new product();
		m.addAttribute(Product1);
		List<product> listProducts=productDAO.listProducts();
		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}

	@RequestMapping(value="/deleteProduct/{productID}")
	public String deleteProduct(@PathVariable("productID")int productID,Model m)
	{
		product Product=productDAO.getProduct(productID);
		productDAO.deleteProduct(Product);
		m.addAttribute("categoryList", this.GetCategories());
		m.addAttribute("supplierList", this.GetSuppliers());
		List<product> listProducts=productDAO.listProducts();
		product product1=new product();
		m.addAttribute(product1);
		m.addAttribute("productList",listProducts);
		m.addAttribute("pageinfo","Manage Product");
		return "Product";
	}

	@RequestMapping(value="/editProduct/{productID}")
	public String editProduct(Model m,@PathVariable("productID")int productID)
	{
		product Product=productDAO.getProduct(productID);
		m.addAttribute(Product);
		m.addAttribute("pageinfo","Manage Product");
		return "UpdateProduct";	
	}	
}