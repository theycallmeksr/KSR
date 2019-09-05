package ksr.com.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ksr.com.Category.category;
import ksr.com.CategoryDao.CategoryDao;

@Controller
	public class CategoryController
	{
	@Autowired
		CategoryDao categoryDao;
		@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
		public String saveCategoryDetail(@RequestParam("catname")String CategoryName,@RequestParam("catdesc")String CategoryDesc,Model m)
		{
			System.out.println("Controller-In");
			category Category=new category();
			Category.setCategoryName(CategoryName);
			Category.setCategoryDesc(CategoryDesc);
			categoryDao.addCategory(Category);
			List <category> listCategories = categoryDao.listCategories();
			m.addAttribute("Category List",listCategories);
			System.out.println("Controller-Out");
			return "category";
		}
	
		@RequestMapping(value="/editCategory/{categoryId}")
		public String editCategory(@PathVariable("categoryId")int categoryId,Model m)
		{
			category Category=categoryDao.getCategory(categoryId);
			m.addAttribute(Category);
			return "updateCategory";
		}
		
		@RequestMapping(value="/deleteCategory/{CategoryId}",method=RequestMethod.GET)
		public String deleteCategory(@PathVariable("categoryId")int categoryId,Model m)
		{
			category Category = categoryDao.getCategory(categoryId);
			System.out.println("Gets from Controller");
			categoryDao.deleteCategory(Category);
			System.out.println("Deletes from Controller");
			List <category> listallcategory = categoryDao.listCategories();
			m.addAttribute("categoryList",listallcategory);
			for(category cat: listallcategory)
			{
				System.out.println("Categories List : "+cat.toString());
			}
			return "category";
		}
		
		@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
		public String updateCategory(@RequestParam("catId")int categoryId,@RequestParam("catName") String categoryName,@RequestParam("catDesc")String categoryDesc,Model m)
		{
			category Category = categoryDao.getCategory(categoryId);
			Category.setCategoryName(categoryName);
			Category.setCategoryDesc(categoryDesc);
			categoryDao.updateCategory(Category);
			List <category> listCategories = categoryDao.listCategories();
			m.addAttribute("categorylist",listCategories);
			return "Category";
		}
}
