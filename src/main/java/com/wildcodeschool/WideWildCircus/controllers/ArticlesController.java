package com.wildcodeschool.WideWildCircus.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.entities.Comment;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.CommentRepository;

@Controller
public class ArticlesController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;
	
	public Article displayedArticle;
	public List <Article> articles = new ArrayList<Article>();
	
	@GetMapping("/articles")
	public String articles(Model model) {
		model.addAttribute("displayedArticle", displayedArticle);
		model.addAttribute("articles", articles);
		return "articles";
	}
	
	
	@PostMapping("/articles")
	public String askForArticle(Model model, @RequestParam Long articleId) {
		this.articles = articleRepository.findAllPublished();
		Collections.sort(articles, Comparator.comparing(Article::getDate).reversed());
		this.displayedArticle = articleRepository.getOne(articleId);
		model.addAttribute("displayedArticle", displayedArticle);
		model.addAttribute("articles", articles);
		return "articles";
	}
	
	@PostMapping("/pubishComment")
	public ModelAndView pubishComment(Model model, @ModelAttribute Comment comment, @RequestParam Long articleId) {		
		ModelAndView mav = new ModelAndView();
		
		Article originalArticle = articleRepository.getOne(articleId);
		List <Comment> comments = originalArticle.getComments();
		
		comment.setDate(new Date());
		comment.setArticle(originalArticle);
		comments.add(comment);
		originalArticle.setComments(comments);		
		
		commentRepository.save(comment);
		articleRepository.save(originalArticle);
		
		this.displayedArticle = originalArticle;
		
		mav.addObject("articles", articles);
		mav.addObject("displayedArticle", displayedArticle);
		mav.setViewName("articles");
		
		return mav ;
	}
	

}
