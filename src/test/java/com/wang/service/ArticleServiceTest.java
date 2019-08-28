package com.wang.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SortOrder;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.sun.javafx.scene.traversal.Direction;
import com.wang.model.Article;
import com.wang.model.Tag;
import com.wang.model.UserInfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleServiceTest {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private TagService tagService;
	@Autowired
	private UserInfoService userInfoService;
	@Transactional
	@Rollback(false)
	@Test
	public void save() {
		Article article = new Article();
		article.setArticleTitle("3小时入门c++");
		article.setArticleDescription("fasdf");
		
		Set<Tag> tags = new HashSet<Tag>();
		Tag tag= tagService.findByTagName("java");
		tags.add(tag);
		article.setTags(tags);
		
		UserInfo userInfo =userInfoService.findByOpenId("49518387");
		article.setUserInfo(userInfo);
		
		articleService.saveArticle(article);
	}
	@Test
	public void testPage() {
		Page<Article> page = articleService.findAllOrderByCreateTime(1, 10, "updateTime");
		List<Article> articles = page.getContent();
		for(Article article: articles) {
			System.out.println(article.getArticleTitle());
		}
	}
}
