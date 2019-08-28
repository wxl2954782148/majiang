package com.wang.repository;

import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.model.Article;
import com.wang.model.Role;
import com.wang.model.UserInfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoRepositoryTest {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Test
	@Rollback(false)
	@Transactional
	public void testOneToMany() {
		Optional<UserInfo> optional = userInfoRepository.findById("49518387");
		UserInfo userInfo = optional.get();
		Set<Article> articles =(Set<Article>) userInfo.getArticles();
		for(Article article:articles) {
			System.out.println(article.getArticleTitle());
		}
	}
	
	@Test
	@Transactional
	public void testFindRole() {
		Optional<UserInfo> optional = userInfoRepository.findById("49518387");
		UserInfo userInfo = optional.get();
		Set<Role> roles = userInfo.getRoles();
		for(Role role:roles) {
			System.out.println(role.getRoleName());
		}
	}
	@Test
	@Rollback(false)
	@Transactional
	public void testDelete() {
		 userInfoRepository.deleteById("49518387");
	}
}
