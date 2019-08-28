package com.wang.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

import com.wang.model.Article;

public interface ArticleService {
	void saveArticle(Article article);
	 
	/**
	 * 根据properties排序并且分页
	 * @param page 当前页码
	 * @param size 当前页内容数
	 * @param direction 排序方式：Sort.Direction.Desc
	 * @param properties 分页条件
	 * @return
	 */
	Page<Article> findAllOrderByCreateTime(int page,int size, String... properties);
}
