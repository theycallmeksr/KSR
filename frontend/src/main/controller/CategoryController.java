package ksr.com.Controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ksr.com.Category.*;
import ksr.com.CategoryDAO.*;

@Controller
public class CategoryController 
{
	@Autowired
	CategoryDAO categoryDAO;

	@RequestMapping("/category")
	public String showCategory(Model m)
	{
		List<category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
	public String saveCategoryDetail(@RequestParam("catName")String categoryName,@RequestParam("catDesc") String categoryDesc,Model m)
	{
		category Category=new category();
		Category.setCategoryName(categoryName);
		Category.setCategoryDesc(categoryDesc);
		categoryDAO.addCategory(Category);
		List<category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		category Category=categoryDAO.getCategory(categoryId);
		categoryDAO.deleteCategory(Category);
		List<category> listCategories=categoryDAO.listCategories();
		m.addAttribute("categoryList", listCategories);
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryId}")
	public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
	{
		category Category=categoryDAO.getCategory(categoryId);
		m.addAttribute(Category);
		return "updatecategory";
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	 public String updateCategory(Model m,@RequestParam("catId")int categoryID,@RequestParam("catName")String categoryName,@RequestParam("catDesc")String categoryDesc)
	 {
		 category Category=categoryDAO.getCategory(categoryID);
		 Category.setCategoryName(categoryName);
		 Category.setCategoryDesc(categoryDesc);
		 categoryDAO.updateCategory(Category);
		 List<category> listCategories=categoryDAO.listCategories();
		 m.addAttribute("categoryList",listCategories);
		 return "Category";
	 }	
}