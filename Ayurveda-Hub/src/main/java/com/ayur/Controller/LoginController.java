package com.ayur.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.ayur.Model.UserDetails;
import com.ayur.Service.UserDetailsService;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
//		Show login and signup form
		@GetMapping("/login_signup")
		public String login_signup() {
			return "login_signup";
		}
		
//		Handle Signup
		@PostMapping("/saveUserDetails")
		public String saveUserDetails(@ModelAttribute UserDetails userDetails, HttpSession session, Model model) {
			 try {
		            userDetailsService.saveUserDetails(userDetails);
		            model.addAttribute("message", "SignUp Successful! Please Login.");
		            return "redirect:/login_signup?success_save=true";
		        } catch (Exception e) {
		            model.addAttribute("error", "Email already exists.");	
		            return "redirect:/login_signup?error_save=true";
		        }
		}
		
		// Handle Login
		@PostMapping("/login")
		public String loginUser(@RequestParam String userEmail, @RequestParam String userPassword, HttpSession session, Model model) {
			
		    UserDetails loggedInUser = userDetailsService.loginUserDetails(userEmail, userPassword);
		    
		    if (loggedInUser != null) {
		        // Store user details in session on successful login
		        session.setAttribute("loggedInUser", loggedInUser); // Save the logged-in user object in session
		        session.setAttribute("message", "Successfully LogIn!");
		        // Store the user ID in the session
		        session.setAttribute("userID", loggedInUser.getUserId());
		        
		        return "redirect:/";  // Redirect to home or dashboard page after login
		    } else {
		        model.addAttribute("error", "Invalid email or password.");
		        return "redirect:/login_signup?error=true";
		    }
		}

		@GetMapping("Login_and_Signup/Login")
		public String login() {
			return "Login_and_Signup/Login";
		}
}
