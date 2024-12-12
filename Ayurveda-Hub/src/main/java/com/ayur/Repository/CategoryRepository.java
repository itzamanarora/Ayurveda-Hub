package com.ayur.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;

public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findBycategorytype(categorytype categorytype);
	List<Category> findBycategorytype(String categorytype);

	long countBycategorytype(categorytype categoryType);
	
}
