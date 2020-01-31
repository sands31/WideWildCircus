package com.wildcodeschool.WideWildCircus.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildcodeschool.WideWildCircus.entities.Article;
import com.wildcodeschool.WideWildCircus.entities.Comment;
import com.wildcodeschool.WideWildCircus.repositories.ArticleRepository;
import com.wildcodeschool.WideWildCircus.repositories.CommentRepository;
import com.wildcodeschool.WideWildCircus.services.FileService;

@Controller
public class AdminCommentsController {
	
	@Autowired
	public ArticleRepository articleRepository;
	@Autowired
	public CommentRepository commentRepository;
	@Autowired
	public FileService fileService;
	public Article displayedArticle;
	public List <Article> articles = new ArrayList<Article>();
	
	@PostMapping("/admin/displayArticleComments")
	public String selectArticle(Model model, @RequestParam Long articleId) {
		model.addAttribute("displayedArticle", articleRepository.getOne(articleId));
		model.addAttribute("articles", articleRepository.findAll());
		model.addAttribute("page", "adminComments");
		return "admin_articles_comments";
	}
	
	@PostMapping("/admin/deleteComment")
	public String deleteComment(Model model, @RequestParam Long commentId, @RequestParam Long articleId) {
		commentRepository.deleteById(commentId);
		model.addAttribute("displayedArticle", articleRepository.getOne(articleId));
		model.addAttribute("articles", articleRepository.findAll());
		model.addAttribute("page", "adminComments");
		return "admin_articles_comments";
	}
	
	@PostMapping("/admin/selectComment")
	public String selectComment(Model model, @RequestParam Long commentId) {
		model.addAttribute("selectedComment", commentRepository.getOne(commentId));
		return "admin_comment_update";
	}

	@PostMapping("/admin/updateComment")
	public String updateComment(Model model, @ModelAttribute Comment comment) {
		Comment originalComment = commentRepository.getOne(comment.getId());
		originalComment.setAuthor(comment.getAuthor());
		originalComment.setDate(comment.getDate());
		originalComment.setContent(comment.getContent());
		commentRepository.save(originalComment);
		model.addAttribute("displayedArticle", articleRepository.getOne(originalComment.getArticle().getId()));
		model.addAttribute("articles", articleRepository.findAll());
		model.addAttribute("page", "adminComments");
		return "admin_articles_comments";
	}

}
