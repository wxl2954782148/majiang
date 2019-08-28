package com.wang.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.wang.model.Article;
import com.wang.repository.ArticleRepository;
import com.wang.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{
	@Autowired
	private ArticleRepository articleRepository;
	@Transactional
	@Override
	public void saveArticle(Article article) {
		articleRepository.save(article);
	}
	@SuppressWarnings("deprecation")
	@Override
	public Page<Article> findAllOrderByCreateTime(int page,int size, String... properties) {
		
		Pageable pageable = new PageRequest(page-1,size,Sort.Direction.DESC,properties);
		return articleRepository.findAll(pageable);
	}
	
}
