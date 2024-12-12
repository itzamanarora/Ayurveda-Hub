package com.ayur.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class AdminController {

	@GetMapping("Admin")
	public String Admin(){
		return "Admin/Admin";
	}
}
