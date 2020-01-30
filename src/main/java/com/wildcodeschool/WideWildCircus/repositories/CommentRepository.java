package com.wildcodeschool.WideWildCircus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wildcodeschool.WideWildCircus.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
