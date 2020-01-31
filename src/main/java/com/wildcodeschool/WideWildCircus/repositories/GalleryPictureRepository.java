package com.wildcodeschool.WideWildCircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.WideWildCircus.entities.GalleryPicture;

public interface GalleryPictureRepository extends JpaRepository<GalleryPicture, Long> {

}
