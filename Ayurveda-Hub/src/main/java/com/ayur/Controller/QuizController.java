package com.ayur.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuizController {
	
	@GetMapping("/Quiz/Hair_Quiz")
	public String Hair_Quiz() {
		try {
			return "Quiz/Hair_Quiz";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Error";
	}

	@GetMapping("/Quiz/Skin_Quiz")
	public String Skin_Quiz() {
		try {
			return "Quiz/Skin_Quiz";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "Error";
	}
}