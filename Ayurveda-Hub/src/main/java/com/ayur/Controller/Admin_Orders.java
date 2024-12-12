package com.ayur.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Admin_Orders {

	@GetMapping("/Admin/Admin_ViewOrders")
	public String ViewOrder() {
		return "/Admin/Admin_ViewOrders";
	}
}
