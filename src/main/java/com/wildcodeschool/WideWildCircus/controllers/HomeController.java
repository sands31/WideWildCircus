package com.wildcodeschool.WideWildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

		
		@GetMapping("/")
		@ResponseBody
		public String home() {
			return "Welcome to the SHIELD";
		}
		
		@GetMapping("/admin")
		public String admin() {
			return "redirect:/admin/dashboard";
		}
		
		@GetMapping("/admin/dashboard")
		public String champion() {
			return "admin_home";
		}


}
