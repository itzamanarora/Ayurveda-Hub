package com.ayur.Service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;
import com.ayur.Repository.CategoryRepository;
import com.ayur.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllcategory() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public void deleteCategoryById(Long category_id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(category_id);
	}

	@Override
	public long countByCategoryType(categorytype categoryType) {
		// TODO Auto-generated method stub
		return categoryRepository.countBycategorytype(categoryType);
	}

	@Override
	public List<Category> findByCategoryType(categorytype categoryType) {
		// TODO Auto-generated method stub
		return categoryRepository.findBycategorytype(categoryType);
	}

	@Override
	public List<Category> findByCategoryType(String categoryType) {
		// TODO Auto-generated method stub
		return categoryRepository.findBycategorytype(categoryType);
	}
	
}
