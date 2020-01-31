package com.wildcodeschool.WideWildCircus.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.entities.GalleryPicture;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.GalleryPictureRepository;

@Controller
public class HomeController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public GalleryPictureRepository galleryPictureRepository;

		
		@GetMapping("/")
		public String home(Model model) {
			List<Article> articles = articleRepository.findAllPublished();
			List<GalleryPicture> galleryPictures = galleryPictureRepository.findAll();			
			model.addAttribute("articles", articles);
			model.addAttribute("galleryPictures", galleryPictures);
			return "index";
		}
}
