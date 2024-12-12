package com.ayur.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;
import com.ayur.Model.Products;
import com.ayur.Service.CategoryService;
import com.ayur.Service.ProductsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class Admin_ProductController {
	
	@Autowired
	private ProductsService productsService;
	
	@Autowired
	private CategoryService categoryService;
	
	String types = "";
	
	//Products Count on Choose Product Page
	@GetMapping("Admin/Admin_ChooseProduct")
	public String ChooseCategory(Model model) {
	    model.addAttribute("hairCount", productsService.getProductsCountByProductCategoryType("hair"));
	    model.addAttribute("skinCount", productsService.getProductsCountByProductCategoryType("skin"));
	    model.addAttribute("healthCount", productsService.getProductsCountByProductCategoryType("health"));
	    return "Admin/Admin_ChooseProduct";
	}

	
//--------------------------------------------- CATEGORIES SAVE,VIEW,EDIT AND DELETE ----------------------------------

	@PostMapping("/saveProducts")
	public String saveProducts(@ModelAttribute Products products, BindingResult result, 
	                           @RequestParam("file") MultipartFile image, @RequestParam("file2") MultipartFile image2, 
	                           @RequestParam("file3") MultipartFile image3,
	                           @RequestParam("file4") MultipartFile image4,
	                           HttpSession session, Model model, String ProductType) throws IOException {
	    
	    if (result.hasErrors()) {
	        session.setAttribute("ErrorMSG", "Validation Error! Check product details.");
	        return "redirect:/Admin/Edit_Products";
	    }

	    try {
	        // Check if product with the same name already exists
	        if (productsService.existsByProductTitle(products.getProductTitle())) {
	            session.setAttribute("ErrorMSG", "Product with this name already exists!");
	            return "redirect:/Admin/Edit_Product";
	        }

	        // Image 1
	        String imageName = image.isEmpty() ? "3012924.jpg" : image.getOriginalFilename();
	        products.setProduct_image_url(imageName);

	        // Image 2
	        String imageName2 = image2.isEmpty() ? "3012924.jpg" : image2.getOriginalFilename();
	        products.setProduct_image_url2(imageName2);

	        // Image 3
	        String imageName3 = image3.isEmpty() ? "3012924.jpg" : image3.getOriginalFilename();
	        products.setProduct_image_url3(imageName3);

	        // Image 4
	        String imageName4 = image4.isEmpty() ? "3012924.jpg" : image4.getOriginalFilename();
	        products.setProduct_image_url4(imageName4);

	        // Save the product first without the image URLs
	        Products savedProduct = productsService.saveProducts(products);

	        if (savedProduct != null) {
	            // Set the path to save the images
	            File uploadDir = new File("uploads/Product-Images/");
	            if (!uploadDir.exists()) uploadDir.mkdirs(); // Create directories if they do not exist

	            // Save Image 1
	            Path path = Paths.get(uploadDir.getAbsolutePath() + File.separator + imageName);
	            if (!image.isEmpty()) {
	                Files.copy(image.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
	            }

	            // Save Image 2
	            Path path2 = Paths.get(uploadDir.getAbsolutePath() + File.separator + imageName2);
	            if (!image2.isEmpty()) {
	                Files.copy(image2.getInputStream(), path2, StandardCopyOption.REPLACE_EXISTING);
	            }

	            // Save Image 3
	            Path path3 = Paths.get(uploadDir.getAbsolutePath() + File.separator + imageName3);
	            if (!image3.isEmpty()) {
	                Files.copy(image3.getInputStream(), path3, StandardCopyOption.REPLACE_EXISTING);
	            }

	            // Save Image 4
	            Path path4 = Paths.get(uploadDir.getAbsolutePath() + File.separator + imageName4);
	            if (!image4.isEmpty()) {
	                Files.copy(image4.getInputStream(), path4, StandardCopyOption.REPLACE_EXISTING);
	            }

	            // Update the product's image URLs in the database after the files are saved
	            savedProduct.setProduct_image_url(imageName);
	            savedProduct.setProduct_image_url2(imageName2);
	            savedProduct.setProduct_image_url3(imageName3);
	            savedProduct.setProduct_image_url4(imageName4);
	            productsService.saveProducts(savedProduct); // Save the product again with all the image URLs

	            // Set success message in session
	            session.setAttribute("SuccMSG", "Product saved successfully!");
	            
	            // Redirect to the product's page
	            return "redirect:/Admin/Admin_ChooseProduct";
	        } else {
	            session.setAttribute("ErrorMSG", "Internal Error while saving the product!");
	        }
	        
	    } catch (Exception e) {
	        session.setAttribute("ErrorMSG", "Something went wrong! Please try again.");
	        e.printStackTrace();
	        return "errorPage";
	    }
	    
	    return "redirect:/Admin/Admin_ChooseProduct"; // Fallback redirect in case of an error
	}


	
	// To view categories in Add product
	@GetMapping("Admin/Admin_AddProduct")
	public String Admin_AddProduct(Model model) {
	    try {
	    	
	    	if("HAIR".equals(types)) {
	    		
	    		 // Load all categories initially (optional)
		        List<Category> allCategories = categoryService.findByCategoryType(categorytype.HAIR); // Adjust this method if needed
		        model.addAttribute("allCategories", allCategories);

	    	} else if ("SKIN".equals(types)) {
	    		
	    		 // Load all categories initially (optional)
		        List<Category> allCategories = categoryService.findByCategoryType(categorytype.SKIN); // Adjust this method if needed
		        model.addAttribute("allCategories", allCategories);
				
			} else if ("HEALTH".equals(types)) {
				
				 // Load all categories initially (optional)
		        List<Category> allCategories = categoryService.findByCategoryType(categorytype.HEALTH); // Adjust this method if needed
		        model.addAttribute("allCategories", allCategories);
				
			}
	       
	        return "Admin/Admin_AddProduct";
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "errorPage";
	    }
	}

	


	//Products View 
	@GetMapping("Admin/Admin_ViewProduct")
	public String Admin_ViewProduct(Model model, HttpSession session, String type) {
		
		types = type;
		try {
			
			if("HAIR".equals(types)) {
				
				List<Products> productList = productsService.findByProductCategoryType(types);
				//check if ProductList is empty
			    if (productList == null || productList.isEmpty()) {
			    	session.setAttribute("no_product", "No Product Found!");
			        System.out.println("No products found!");
			    } else {
			    	session.setAttribute("no_product", "");
			        System.out.println("Products found: " + productList.size());
			    }
			    
			    model.addAttribute("Products", productList); //Pass the Product list to the model
			    model.addAttribute("type", types);
			    
			    return "Admin/Admin_ViewProduct";
				
			} else if ("SKIN".equals(types)) {
				
				List<Products> productList = productsService.findByProductCategoryType(types);
				//check if ProductList is empty
			    if (productList == null || productList.isEmpty()) {
			    	session.setAttribute("no_product", "No Product Found!");
			        System.out.println("No products found!");
			    } else {
			    	session.setAttribute("no_product", "");
			        System.out.println("Products found: " + productList.size());
			    }
			    
			    model.addAttribute("Products", productList); //Pass the Product list to the model
			    model.addAttribute("type", types);
			    
			    return "Admin/Admin_ViewProduct";
				
			} else if ("HEALTH".equals(types)) {
				
				List<Products> productList = productsService.findByProductCategoryType(types);
				//check if ProductList is empty
			    if (productList == null || productList.isEmpty()) {
			    	session.setAttribute("no_product", "No Product Found!");
			        System.out.println("No products found!");
			    } else {
			    	session.setAttribute("no_product", "");
			        System.out.println("Products found: " + productList.size());
			    }
			    
			    model.addAttribute("Products", productList); //Pass the Product list to the model
			    model.addAttribute("type", types);
			    
			    return "Admin/Admin_ViewProduct";
				
			}
			
			return "Admin/Admin_ViewProduct";
		} catch (Exception e) {
			e.printStackTrace();
			return "errorPage";
		}
	}
	
//	------------------Delete Product in Admin---------------------
	@GetMapping("/deleteProduct/{product_id}")
	public String deleteProduct(@PathVariable Long product_id, RedirectAttributes redirectAttributes) {
		try {
	        productsService.deleteProductById(product_id);
	        redirectAttributes.addFlashAttribute("message", "Product deleted successfully!");
	        return "redirect:/Admin/Admin_ViewProduct";  // Redirect to the product list page after deletion
	    } catch (Exception e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("error", "Something went wrong! Please try again.");
	        return "redirect:/Admin/Admin_ViewProduct";  // Redirect back to the products list with an error message
	    }
	}
	
//--------------------- Edit product in ADMIN---------------
	
	@GetMapping("/Admin_EditProduct")
	public String editproduct() {
		return "Admin/Admin_EditProduct";
	}
}
