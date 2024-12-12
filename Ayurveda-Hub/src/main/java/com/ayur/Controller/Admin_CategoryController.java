package com.ayur.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;
import com.ayur.Service.CategoryService;
import jakarta.servlet.http.HttpSession;

@Controller
public class Admin_CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	String Type;
	
	//Add Category Page
	@GetMapping("Admin/Admin_AddCategory")
	public String Admin_AddCategory(Model model) {
		try {
			return "Admin/Admin_AddCategory";
		} catch (Exception e) {
			e.printStackTrace();
			return "errorPage";
		}

	}
	
	
	//Categories Count on Choose Category Page
	@GetMapping("Admin/Admin_ChooseCategory")
	public String ChooseCategory(Model model, String type) {	
			model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
		    model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
		    model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
		    
		return "Admin/Admin_ChooseCategory";
	}
	
		
//--------------------------------------------- CATEGORIES SAVE,VIEW,EDIT AND DELETE ----------------------------------
	@PostMapping("/saveCategory")
	public String saveCategory(Category category, RedirectAttributes redirectAttributes) {
	    try {
	        // Save the category once and store the result
	        Category savedCategory = categoryService.saveCategory(category);

	        // Check if the save was successful
	        if (!ObjectUtils.isEmpty(savedCategory)) {
	            redirectAttributes.addFlashAttribute("successMessage", "Successfully saved the Category.");
	        } else {
	            redirectAttributes.addFlashAttribute("errorMessage", "Internal Error: Could not save category.");
	            System.out.print("Error");
	        }
	    } catch (Exception e) {
	        redirectAttributes.addFlashAttribute("exceptionMessage", "Something went wrong! Please try again.");
	        e.printStackTrace();
	        return "redirect:/errorPage"; // Redirect to a designated error page if available
	    }
	    return "redirect:/Admin/Admin_ChooseCategory";
	}

	
	@GetMapping("Admin/Admin_ViewCategory")
	public String Admin_ViewCategory(Model model, HttpSession session, String type) {
	    try {
	    	Type = type;
	        List<Category> categoryList = null;

	        // Determine the category type based on 'Type'
	        if ("HAIR".equals(Type)) {
	        	model.addAttribute("hairCount", categoryService.countByCategoryType(categorytype.HAIR));
	            categoryList = categoryService.findByCategoryType(categorytype.HAIR);
	        } else if ("SKIN".equals(Type)) {
	        	model.addAttribute("skinCount", categoryService.countByCategoryType(categorytype.SKIN));
	            categoryList = categoryService.findByCategoryType(categorytype.SKIN);
	        } else if ("HEALTH".equals(Type)) {
	        	model.addAttribute("healthCount", categoryService.countByCategoryType(categorytype.HEALTH));
	            categoryList = categoryService.findByCategoryType(categorytype.HEALTH);
	        }

	        // Check if category list is empty
	        if (categoryList == null || categoryList.isEmpty()) {
	        	session.setAttribute("no_category", "No Category Found!");
	            System.out.println("No Category found!");
	        } else {
	        	session.setAttribute("no_category", "");
	            System.out.println("Category found: " + categoryList.size());
	        }

	        model.addAttribute("Category", categoryList); // Pass the category list to the model

	        return "Admin/Admin_ViewCategory";

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error";
	    }
	}


	
	//Delete Category
	@GetMapping("/deleteCategory/{category_id}")
	public String deleteCategory(@PathVariable Long category_id, RedirectAttributes redirectAttributes) {
		try {
	        categoryService.deleteCategoryById(category_id);
	        redirectAttributes.addFlashAttribute("message", "Category deleted successfully!");
	        return "redirect:/Admin/Admin_ViewCategory";  // Redirect to the product list page after deletion
	    } catch (Exception e) {
	        e.printStackTrace();
	        redirectAttributes.addFlashAttribute("error", "Something went wrong! Please try again.");
	        return "Error";
	    }
	}
//	
//	@GetMapping()
//	public String distinctCategory(HttpSession session, Model model) {
//		try {
//			List<Category> categoryList = categoryService.findDistinctByCategory_name();
//			
//			 if (categoryList == null || categoryList.isEmpty()) {
//			    	session.setAttribute("message", "No Category Found!");
//			        System.out.println("No products found!");
//			    } else {
//			    	session.setAttribute("message", "Category Details");
//			        System.out.println("Products found: " + categoryList.size());
//			    }
//			    
//			    model.addAttribute("Category", categoryList);
//				return "Admin/Admin_ViewCategory";
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "Something went Wrong! Please Try again.";
//	}
}
