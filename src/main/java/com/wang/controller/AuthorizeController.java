package com.wang.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.config.GithubCilent;
import com.wang.dto.AccessTokenDto;
import com.wang.dto.GithubUser;
import com.wang.provider.GithubProvider;

@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;
	
	@Autowired
	private GithubCilent githubCilent;
	
	@GetMapping("/callback")
	public String callback(@RequestParam(name="code")String code,
							@RequestParam(name="state")String state) {
		AccessTokenDto dto = new AccessTokenDto();
		dto.setClient_id(githubCilent.getId());
		dto.setClient_secret(githubCilent.getSecret());
		dto.setCode(code);
		dto.setRedirect_uri(githubCilent.getRedirect_uri());
		dto.setState(state);
		String accessToken = githubProvider.getAccessToken(dto);
		GithubUser githubUser = githubProvider.getUser(accessToken);
		System.out.println(githubUser.getName()+"bid"+githubUser.getBio());
		return "/index";
	}
}
