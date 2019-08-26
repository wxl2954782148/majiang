package com.wang.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.config.GithubCilent;
import com.wang.dto.AccessTokenDto;
import com.wang.dto.GithubUser;
import com.wang.model.UserInfo;
import com.wang.provider.GithubProvider;
import com.wang.repository.UserInfoRepository;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;

	@Autowired
	private GithubCilent githubCilent;
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Autowired
	private StringRedisTemplate redis;

	@GetMapping("/callback")
	public String callback(@RequestParam(name="code")String code,
							@RequestParam(name="state")String state,
							HttpServletRequest httpServletRequest
							) {
		AccessTokenDto dto = new AccessTokenDto();
		dto.setClient_id(githubCilent.getId());
		dto.setClient_secret(githubCilent.getSecret());
		dto.setCode(code);
		dto.setRedirect_uri(githubCilent.getRedirect_uri());
		dto.setState(state);
		String accessToken = githubProvider.getAccessToken(dto);
		GithubUser user = githubProvider.getUser(accessToken);
		if(user != null) {
			UserInfo userInfo = userInfoRepository.findByOpenId(user.getId().toString());
			if(userInfo==null) {
				UserInfo entity = new UserInfo();
				entity.setOpenId(user.getId().toString());
				entity.setUserBio(user.getBio());
				entity.setUserName(user.getName());
				entity.setToken(UUID.randomUUID().toString());
				userInfoRepository.save(entity);
			}
			String sessionKey  = "sessionKey"+user.getId().toString();
			String session = user.getId().toString();
			redis.opsForValue().set(sessionKey,session,1,TimeUnit.MINUTES);
			String user_token = redis.opsForValue().get(sessionKey);
			httpServletRequest.getSession().setAttribute("user", user);
			return "redirect:/";
		}
		
		return "redirect:/";
	}
}