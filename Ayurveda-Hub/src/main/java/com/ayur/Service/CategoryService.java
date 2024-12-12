package com.ayur.Service;

import java.util.List;

import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;

public interface CategoryService {
	
	public Category saveCategory(Category category);
	
	public List<Category> getAllcategory();
	
	public void deleteCategoryById(Long category_id);
	
	public  long countByCategoryType(categorytype categoryType);

	public List<Category> findByCategoryType(categorytype categoryType);
	
	public List<Category> findByCategoryType(String categoryType);

}
