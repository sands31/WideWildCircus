package com.wildcodeschool.WideWildCircus.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.CommentRepository;

@Controller
public class AdminArticlesController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;	
	public Article displayedArticle;
	public List <Article> articles = new ArrayList<Article>();
	

	@PostMapping("/admin/deleteArticle")
	public String deleteArticle(@RequestParam Long articleId) {
		articleRepository.deleteById(articleId);
		return "redirect:/admin/articles";
	}

}
