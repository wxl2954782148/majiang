package com.wang.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.model.Article;
import com.wang.model.UserInfo;
import com.wang.repository.UserInfoRepository;
import com.wang.service.ArticleService;
import com.wang.service.UserInfoService;

@Controller
public class IndexController {
	@Autowired
	private StringRedisTemplate redis;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private ArticleService articleService;
	@GetMapping("/")
	public String index(HttpServletRequest httpServletRequest,
			@RequestParam(name="page",defaultValue="1")int page,
			@RequestParam(name="size",defaultValue="10")int size,
			@RequestParam(name="properties",defaultValue="createTime")String properties,
			Map<String, Object> map
			) {
		try {
			Cookie[] cookies = httpServletRequest.getCookies();
			if (cookies.length > 0) {
				for (Cookie cookie : cookies) {
					String cookieName = cookie.getName();
					if ("user_token".equals(cookieName)) {
						String openId = cookie.getValue();
						String restulSession = redis.opsForValue().get(openId);
						if (restulSession != null) {
							UserInfo user = userInfoService.findByOpenId(openId);
							httpServletRequest.getSession().setAttribute("user", user);
						}
						break;
					}
				}
			}
		} catch (Exception e) {
			return "index";
		}finally {
			Page<Article> articles = articleService.findAllOrderByCreateTime(page, size, properties);
			map.put("articlesPage", articles);
			for(Article article:articles) {
				System.out.println(article.getArticleDescription());
			}
		}
		
		return "index";
	}

}


