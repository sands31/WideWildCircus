package com.wildcodeschool.WideWildCircus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;

@Controller
public class HomeController {
	
	@Autowired
	public ArticleRepository articleRepository;

		
		@GetMapping("/")
		public String home(Model model) {
			List<Article> articles = articleRepository.findAllPublished();
			model.addAttribute("articles", articles);
			return "index";
		}
}
