package com.ayur.Service.Impl;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.ayur.Model.Products;
import com.ayur.Repository.ProductsRepository;
import com.ayur.Service.ProductsService;

@Service
public class ProductsServiceImpl implements ProductsService{
	
	@Autowired
	private ProductsRepository productsRepository;

	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		return productsRepository.save(products);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productsRepository.findAll();
	}

	@Override
	public void deleteProductById(Long product_id) {
		// TODO Auto-generated method stub
		productsRepository.deleteById(product_id);
	}

	@Override
	public Products updateProduct(Products product, MultipartFile file) {
	    // Fetch the existing product by ID
	    Products existingProduct = getProductsById(product.getProduct_id());

	    if (existingProduct == null) {
	        throw new RuntimeException("Product not found with ID: " + product.getProduct_id());
	    }

	    // Update fields except for the image URL
	    existingProduct.setProductTitle(product.getProductTitle());
	    existingProduct.setProduct_desc(product.getProduct_desc());
	    existingProduct.setProduct_ingredient(product.getProduct_ingredient());
	    existingProduct.setProduct_stock(product.getProduct_stock());
	    existingProduct.setProduct_price(product.getProduct_price());
	    existingProduct.setProduct_orgprice(product.getProduct_orgprice());
	    existingProduct.setProduct_info(product.getProduct_info());
	    existingProduct.setProductCategorytype(product.getProductCategorytype());
	    existingProduct.setProductCategory(product.getProductCategory());
	    existingProduct.setProduct_status(product.getProduct_status());

	    // Handle image file upload if a new file is provided
	    if (!file.isEmpty()) {
	        String imageFileName = file.getOriginalFilename();
	        Path imagePath = Paths.get("uploads/Product-Images/", imageFileName);
	        
	        try {
	            // Save the new file to the filesystem
	            Files.copy(file.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
	            existingProduct.setProduct_image_url(imageFileName);  // Update with new image filename
	        } catch (IOException e) {
	            throw new RuntimeException("Failed to save the uploaded file: " + imageFileName, e);
	        }
	    }

	    // Save and return the updated product
	    return productsRepository.save(existingProduct);
	}

	@Override
	public Products getProductsById(Long product_id) {
		// TODO Auto-generated method stub
		return productsRepository.findById(product_id).orElse(null);
		
	}

	@Override
	public boolean existsByProductTitle(String productTitle) {
		// TODO Auto-generated method stub
		return productsRepository.existsByProductTitle(productTitle);
	}


	@Override
	public List<Products> findByProductCategoryType(String productCategorytype) {
		// TODO Auto-generated method stub
		return productsRepository.findByProductCategorytype(productCategorytype);
	}

	@Override
	public Long getProductsCountByProductCategoryType(String productCategorytype) {
		// TODO Auto-generated method stub
		return productsRepository.countByProductCategorytype(productCategorytype);
	}


}
