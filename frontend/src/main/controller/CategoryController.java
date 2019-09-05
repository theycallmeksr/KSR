package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
	public class CategoryController
	{
	
		CategoryDao categoryDao;
		
		@RequestMapping(value="/InsertCategory",method=RequestMethod.POST)
		public String saveCategoryDetail(@RequestParam("catname")String CategoryName,@RequestParam("catdesc")String CategoryDesc,Model m)
		{
			category Category=new category();
			Category.setCategoryName(CategoryName);
			Category.setCategoryDesc(CategoryDesc);
			CategoryDao.addCategory(Category);
			return "category";
		}
}
