package com.wildcodeschool.WideWildCircus.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.WideWildCircus.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
	@Query(value="SELECT a.* FROM article a WHERE a.publish_state = true", nativeQuery = true)
	List<Article> findAllPublished();

}
