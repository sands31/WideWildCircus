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
import com.wildcodeschool.WideWildCircus.repositories.GalleryPictureRepository;

@Controller
public class AdminController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;
	@Autowired
	public GalleryPictureRepository galleryPictureRepository;
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
	
	@GetMapping("/admin/comments")
	public String comments(Model model) {
		model.addAttribute("articles", articleRepository.findAll());
		model.addAttribute("page", "adminComments");
		return "admin_articles_comments";
	}
	
	@GetMapping("/admin/gallery")
	public String gallery(Model model) {
		model.addAttribute("galleryPictures", galleryPictureRepository.findAll());
		model.addAttribute("page", "adminGallery");
		return "admin_gallery";
	}
	
	@GetMapping("/admin/addPictureSection")
	public String addPicture(Model model) {
		model.addAttribute("page", "adminGallery");
		return "admin_gallery_add";
	}
	

}
