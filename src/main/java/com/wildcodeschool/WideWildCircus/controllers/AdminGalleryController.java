package com.wildcodeschool.WideWildCircus.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.wildcodeschool.WideWildCircus.entities.GalleryPicture;
import com.wildcodeschool.WideWildCircus.repositories.GalleryPictureRepository;
import com.wildcodeschool.WideWildCircus.services.FileService;

@Controller
public class AdminGalleryController {
	
	@Autowired
	public GalleryPictureRepository galleryPictureRepository;
	@Autowired
	public FileService fileService;
	
	@PostMapping("/admin/deletePicture")
	public String deletePicture(Model model, @RequestParam Long pictureId) {
		galleryPictureRepository.deleteById(pictureId);
		return "redirect:/admin/gallery";
	}
	
	@PostMapping("/admin/addGalleryPicture")
	public String addPicture(Model model, @ModelAttribute GalleryPicture galleryPicture, @RequestParam(required = false) MultipartFile pictureFile) {
		if (pictureFile != null && !pictureFile.isEmpty()) {
			galleryPicture.setPicturePath("img/" + fileService.uploadFile(pictureFile));
		}
		galleryPicture.setDate(new Date());
		galleryPictureRepository.save(galleryPicture);
		return "redirect:/admin/gallery";
	}

}
