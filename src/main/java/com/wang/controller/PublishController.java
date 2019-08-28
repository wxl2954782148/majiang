package com.wang.controller;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.model.Article;
import com.wang.model.Tag;
import com.wang.model.UserInfo;
import com.wang.service.ArticleService;
import com.wang.service.TagService;
import com.wang.service.UserInfoService;
@Controller
@RequestMapping("/publish")
public class PublishController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private TagService tagService;
	
	@GetMapping
	public String publish() {
		return "publish";
	}
	
	@PostMapping("/add")
	public String saveArticle(
			@RequestParam(name="title",required=true)String articleTitle,
			@RequestParam(name="descption",required=true)String articleDescription,
			@RequestParam(name = "tag",required=true)String tags,
			HttpServletRequest request
			) {
		
		Article article = new Article();
		article.setArticleTitle(articleTitle);
		article.setArticleDescription(articleDescription);
		
		String[] tagsArray = tags.split(";");
		Set<Tag> tagsSet = new HashSet<Tag>();
		for(int i=0;i<tagsArray.length;i++) {
			String tagName = tagsArray[i];
			Tag tag = tagService.findByTagName(tagName);
			tagsSet.add(tag);
		}
		article.setTags(tagsSet);
		//获取用户信息
		String openId = null;
		try {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie:cookies) {
				if("user_token".equals(cookie.getName())) {
					openId = cookie.getValue();
					System.out.println(openId);
					break;
				}
			}
		} catch (Exception e) {
			return "index";
		}
		UserInfo userInfo = userInfoService.findByOpenId(openId);
		article.setUserInfo(userInfo);
		
		articleService.saveArticle(article);
		
		return "publish";
	}
}
