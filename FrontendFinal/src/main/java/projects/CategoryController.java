package projects;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import projects.CategoryClass.Category;
import projects.Categorydaoimp.CategoryDao;




@Controller
public class CategoryController {
	
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/admin/addcategory", method=RequestMethod.POST)
	
	public String addCategory(@RequestParam("cname")String categoryName,@RequestParam("cdesc")String categoryDescription,Model m) {

		Category c = new Category();

		c.setCategoryName(categoryName);
		c.setCategoryDesc(categoryDescription);
		categoryDao.addCategory(c);
		
		  List<Category> ListCategory=categoryDao.ListCategory();
		 m.addAttribute("CategoryList",ListCategory);
		 
		return "category";
		
	}
	
	
	  @RequestMapping(value="/admin/deleteCategory/{categoryId}")
	  public String deleteCategory(@PathVariable("categoryId") int categoryId,Model m) {
	 
	 Category category=categoryDao.getCategory(categoryId);
	 System.out.println("gets from controller");
	 categoryDao.deleteCategory(category);
	 System.out.println("delete from catgory"); 
	 List<Category> ListallCategory=categoryDao.ListCategory();
	  m.addAttribute("CategoryList",ListallCategory);
	  
	  //m.addAttribute(ListallCategory);
	  
	  for(Category cat:ListallCategory) {
	 System.out.println("catgory list:"+cat.toString());
	  }
	 return "category";
	  }
	 
 @RequestMapping(value="/admin/editCategory/{categoryId}")
 public String editCategory(@PathVariable("categoryId") int categoryId,Model m)
 {
	 Category category=categoryDao.getCategory(categoryId);
   m.addAttribute(category);
   return "update";
 }
 
 @RequestMapping(value="/admin/updateCategory", method=RequestMethod.POST)
 public String updateCategory(Model m,@RequestParam("cid")int categoryId,@RequestParam("cname")String categoryName,@RequestParam("cdesc")String categoryDesc) {
	
	 Category category=categoryDao.getCategory(categoryId);

		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		categoryDao.updateCategory(category);
		List<Category> ListCategory=categoryDao.ListCategory();
		 m.addAttribute("CategoryList",ListCategory);
		 
		
		return "category";
	
	 
 }
 
}
   

