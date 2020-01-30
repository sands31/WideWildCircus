package com.wildcodeschool.WideWildCircus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticlesController {
	
	@GetMapping("/articles")
	public String home() {
		return "articles";
	}
	
	

}
