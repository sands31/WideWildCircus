package com.wildcodeschool.WideWildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin")
	public String admin() {
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String champion() {
		return "admin_home";
	}
}
