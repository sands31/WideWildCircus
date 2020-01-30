package com.wildcodeschool.WideWildCircus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.CommentRepository;

@Controller
public class AdminController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;	
	public Article displayedArticle;
	public List <Article> articles = new ArrayList<Article>();
	

	@GetMapping("/admin")
	public String admin() {
		return "redirect:/admin/dashboard";
	}
	
	@GetMapping("/admin/dashboard")
	public String dashboard() {
		return "admin_home";
	}
	
	@GetMapping("/admin/createArticle")
	public String createArticle(Model model) {
		model.addAttribute("page", "adminCreateArticle");
		return "admin_article_create";
	}
	
	@GetMapping("/admin/articles")
	public String articles(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		model.addAttribute("page", "adminArticles");
		return "admin_articles";
	}
	

}
