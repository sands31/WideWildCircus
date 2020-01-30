package com.wildcodeschool.WideWildCircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.WideWildCircus.entities.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

}
