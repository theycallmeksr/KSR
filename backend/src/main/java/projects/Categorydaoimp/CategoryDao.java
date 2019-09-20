package projects.Categorydaoimp;

import java.util.List;

import projects.CategoryClass.Category;

public interface CategoryDao {

		public boolean addCategory(Category category);
	
	 public boolean deleteCategory(Category category);
	 public boolean editcategory(Category category); 
	 public Category getCategory(int categoryId);
	 public List<Category> ListCategory();
	 public boolean updateCategory(Category category);
	 
}
