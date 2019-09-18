package ksr.com.CategoryDAO;

import java.util.List;
import ksr.com.Category.category;

public interface CategoryDAO 
{
	public boolean addCategory(category categ);
	public boolean updateCategory(category categ);
	public boolean deleteCategory(category categ);
	public category getCategory(int categoryId);
	public List <category> listCategories(); 
}

