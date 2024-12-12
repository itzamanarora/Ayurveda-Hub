package com.ayur.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.ayur.Model.Products;


public interface ProductsService {
	
	public Products saveProducts(Products products);
	
	public List<Products> getAllProducts();
	
	public void deleteProductById(Long product_id);
	
	public Products getProductsById(Long product_id);
	
	public Products updateProduct(Products product, MultipartFile file);
	
	public Long getProductsCountByProductCategoryType(String productcategorytype);

	public boolean existsByProductTitle(String productTitle);
	
	public List<Products> findByProductCategoryType(String productCategorytype);

}
