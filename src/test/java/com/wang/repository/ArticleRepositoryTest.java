package com.wang.repository;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.model.Article;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ArticleRepositoryTest {
	@Autowired
	private ArticleRepository articleRepository;
	@Test
	public void testPage() {
		PageRequest request = new PageRequest(0, 10, Sort.Direction.DESC,"createTime");
		Page<Article> pageable = articleRepository.findAll(request);
		List<Article> list = pageable.getContent();
		for(Article article : list) {
			System.out.println(article.getArticleTitle());
		}
	}
}
