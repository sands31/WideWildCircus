package com.wildcodeschool.WideWildCircus.controllers;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.CommentRepository;
import com.wildcodeschool.WideWildCircus.services.FileService;

@Controller
public class AdminArticlesController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;
	@Autowired
	public FileService fileService;
	public Article displayedArticle;
	public List <Article> articles = new ArrayList<Article>();
	

	@PostMapping("/admin/deleteArticle")
	public String deleteArticle(@RequestParam Long articleId) {
		articleRepository.deleteById(articleId);
		return "redirect:/admin/articles";
	}
	
	@PostMapping("/admin/selectArticle")
	public String selectArticle(Model model, @RequestParam Long articleId) {
		model.addAttribute("selectedArticle", articleRepository.findById(articleId));
		return "redirect:/admin/articles";
	}
	
	@PostMapping("/admin/createArticle")
	public String createArticle(Model model, @ModelAttribute Article article, @RequestParam(required = false) MultipartFile pictureFile) {
		if (pictureFile != null && !pictureFile.isEmpty()) {
			article.setPicturePath("img/" + fileService.uploadFile(pictureFile));
		}
		article.setDate(new Date());
		articleRepository.save(article);
		return "redirect:/admin/articles";
	}

}
