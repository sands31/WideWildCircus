package com.wildcodeschool.WideWildCircus.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;

@Controller
public class ArticlesController {
	
	@Autowired
	public ArticleRepository articleRepository;
	
	
	@PostMapping("/articles")
	public String askForArticle(Model model, @RequestParam Long articleId) {
		List<Article> articles = articleRepository.findAll();
		Collections.sort(articles, Comparator.comparing(Article::getDate).reversed());
		Article displayedArticle = articleRepository.getOne(articleId);
		model.addAttribute("displayedArticle", displayedArticle);
		return "/articles";
	}
	
	

}
