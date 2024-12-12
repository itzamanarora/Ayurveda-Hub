package com.ayur.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;
import com.ayur.Model.Products;
import com.ayur.Service.CategoryService;
import com.ayur.Service.ProductsService;

import jakarta.servlet.http.HttpSession;

@Controller
public class User_ProductController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductsService productsService;
	
	
//	--------------------------All Products View for User-----------------
	
	@GetMapping("View_Product/{product_id}")
	public String View_Product(Model model,  @PathVariable Long product_id) {
		try {
	        // Fetch categories and set counts and lists in the model
	        List<Category> categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        List<Category> categoryList2 = categoryService.findByCategoryType(categorytype.SKIN);
	        List<Category> categoryList3 = categoryService.findByCategoryType(categorytype.HEALTH);

	        model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	        model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	        model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	        
	        model.addAttribute("Category", categoryList);
	        model.addAttribute("Category2", categoryList2);
	        model.addAttribute("Category3", categoryList3);

//	        Fetch product by ID (assuming getProductsById returns a single product object)
	        Products product = productsService.getProductsById(product_id);

//	        // Check if product exists
	        if (product != null) {
	            model.addAttribute("product", product);
	        } else {
//	            // Handle case where product is not found
	            model.addAttribute("error", "Product not found");
	            return "Error";  // You can return an error page or some error message
	        }

	        return "View_Product";

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error";  // Return an error page if an exception occurs
	    }
	}

	
	@GetMapping("/All_Product")
	public String All_Products(Model model, HttpSession session) {
		
		try {
			//Categories View
			List<Category> categoryList = null;
	        List<Category> categoryList2 = null;
	        List<Category> categoryList3 = null;
	        	model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	            categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        	model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	            categoryList2 = categoryService.findByCategoryType(categorytype.SKIN);
	        	model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	            categoryList3 = categoryService.findByCategoryType(categorytype.HEALTH);

	        model.addAttribute("Category", categoryList); // Pass the category list to the model
	        model.addAttribute("Category2", categoryList2); // Pass the category list to the model
	        model.addAttribute("Category3", categoryList3); // Pass the category list to the model
			
			//Products View
			List<Products> allproduct = productsService.getAllProducts();
			
		    if (allproduct == null || allproduct.isEmpty()) {
		    	session.setAttribute("message", "Something went Wrong! Try Again.");
		        System.out.println("No products found!");
		    } else {
		    	session.setAttribute("message", "This is Session Messagesss");
		        System.out.println("Products found: " + allproduct.size());
		    }
		    
		    model.addAttribute("Products", allproduct);
			return "All_Product";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "erroPage";
	}
	

	
	@GetMapping("/HairCare_Product")
	public String HairCare_Product(Model model, HttpSession session) {
		
		try {
			//Categories View
			List<Category> categoryList = null;
	        List<Category> categoryList2 = null;
	        List<Category> categoryList3 = null;
	        	model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	            categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        	model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	            categoryList2 = categoryService.findByCategoryType(categorytype.SKIN);
	        	model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	            categoryList3 = categoryService.findByCategoryType(categorytype.HEALTH);

	        model.addAttribute("Category", categoryList); // Pass the category list to the model
	        model.addAttribute("Category2", categoryList2); // Pass the category list to the model
	        model.addAttribute("Category3", categoryList3); // Pass the category list to the model
			
			//Products View
			List<Products> hairproduct = productsService.findByProductCategoryType("HAIR");
			
		    if (hairproduct == null || hairproduct.isEmpty()) {
		    	session.setAttribute("message", "Something went Wrong! Try Again.");
		        System.out.println("No products found!");
		    } else {
		    	session.setAttribute("message", "This is Session Messagesss");
		        System.out.println("Products found: " + hairproduct.size());
		    }
		    
		    model.addAttribute("Hair_Products", hairproduct);
			return "HairCare_Product";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "erroPage";
	}
	
	@GetMapping("/SkinCare_Product")
	public String SkinCare_Product(Model model, HttpSession session) {
		
		try {
			//Categories View
			List<Category> categoryList = null;
	        List<Category> categoryList2 = null;
	        List<Category> categoryList3 = null;
	        	model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	            categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        	model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	            categoryList2 = categoryService.findByCategoryType(categorytype.SKIN);
	        	model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	            categoryList3 = categoryService.findByCategoryType(categorytype.HEALTH);

	        model.addAttribute("Category", categoryList); // Pass the category list to the model
	        model.addAttribute("Category2", categoryList2); // Pass the category list to the model
	        model.addAttribute("Category3", categoryList3); // Pass the category list to the model
			
			//Products View
			List<Products> skinproduct = productsService.findByProductCategoryType("SKIN");
			
		    if (skinproduct == null || skinproduct.isEmpty()) {
		    	session.setAttribute("message", "Something went Wrong! Try Again.");
		        System.out.println("No products found!");
		    } else {
		    	session.setAttribute("message", "This is Session Messagesss");
		        System.out.println("Products found: " + skinproduct.size());
		    }
		    
		    model.addAttribute("Skin_Products", skinproduct);
			return "SkinCare_Product";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "erroPage";
	}
	
	@GetMapping("/HealthCare_Product")
	public String HealthCare_Product(Model model, HttpSession session) {
		
		try {
			//Categories View
			List<Category> categoryList = null;
	        List<Category> categoryList2 = null;
	        List<Category> categoryList3 = null;
	        	model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	            categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        	model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	            categoryList2 = categoryService.findByCategoryType(categorytype.SKIN);
	        	model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	            categoryList3 = categoryService.findByCategoryType(categorytype.HEALTH);

	        model.addAttribute("Category", categoryList); // Pass the category list to the model
	        model.addAttribute("Category2", categoryList2); // Pass the category list to the model
	        model.addAttribute("Category3", categoryList3); // Pass the category list to the model
			
			//Products View
			List<Products> healthproduct = productsService.findByProductCategoryType("HEALTH");
			
		    if (healthproduct == null || healthproduct.isEmpty()) {
		    	session.setAttribute("message", "Something went Wrong! Try Again.");
		        System.out.println("No products found!");
		    } else {
		    	session.setAttribute("message", "This is Session Messagesss");
		        System.out.println("Products found: " + healthproduct.size());
		    }
		    
		    model.addAttribute("Health_Products", healthproduct);
			return "HealthCare_Product";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "erroPage";
	
	}
	
	
	
	@GetMapping("/check-login-status")
	@ResponseBody
	public boolean checkLoginStatus(HttpSession session) {
	    return session.getAttribute("user") != null;
	}

}
