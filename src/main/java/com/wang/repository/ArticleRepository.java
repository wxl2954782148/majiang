package com.wang.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.model.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
