package com.ayur.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ayur.Model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long>{

	boolean existsByProductTitle(String productTitle);

	List<Products> findByProductCategorytype(String product_category_type);
	
	Long countByProductCategorytype(String product_category_type);

}
