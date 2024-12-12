package com.ayur.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.ayur.Model.Category;
import com.ayur.Model.Category.categorytype;
import com.ayur.Model.UserDetails;
import com.ayur.Service.CategoryService;



import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {
	
	
	@Autowired
	private CategoryService categoryService;
	
	
	


	@GetMapping("/")
	public String index(Model model, HttpSession session) {
	    UserDetails user = (UserDetails) session.getAttribute("loggedInUser");

	    if (user == null) {
	        // If user is not logged in, redirect to login page
	        return "redirect:/login_signup";
	    }

	    // Add user details to the model to display on the home page
	    model.addAttribute("user", user);

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

	        // Display Home_Index page if user is logged in and data is retrieved successfully
	        return "Home_Index";

	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Error";  // Return an error page if an exception occurs
	    }
	}

	
	@GetMapping("/Choose_Quiz")
	public String Choose_Quiz(Model model) {
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

		        // Display Home_Index page if user is logged in and data is retrieved successfully
		        return "Choose_Quiz";

		    } catch (Exception e) {
		        e.printStackTrace();
		        return "Error";  // Return an error page if an exception occurs
		    }
	}
	
	@GetMapping("/E_Book")
	public String E_Book(Model model){
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

		        // Display Home_Index page if user is logged in and data is retrieved successfully
		        return "E_Book";

		    } catch (Exception e) {
		        e.printStackTrace();
		        return "Error";  // Return an error page if an exception occurs
		    }
	}
	
	@GetMapping("/ComingSoon")
	public String ComingSoon() {
		return "/ComingSoon";
	}
	
	@GetMapping("User_Account")
	public String User_Account() {
		return "/User_Account";
	}
	
	@GetMapping("add_to_cart")
	public String add_to_cart(Model model) {
		
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

		        // Display Home_Index page if user is logged in and data is retrieved successfully
		        return "add_to_cart";

		    } catch (Exception e) {
		        e.printStackTrace();
		        return "Error";  // Return an error page if an exception occurs
		    }
	}
	
}
