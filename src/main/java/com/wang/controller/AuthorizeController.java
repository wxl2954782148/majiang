package com.wang.controller;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wang.config.GithubCilent;
import com.wang.dto.AccessTokenDto;
import com.wang.dto.GithubUser;
import com.wang.model.UserInfo;
import com.wang.provider.GithubProvider;
import com.wang.repository.UserInfoRepository;
import com.wang.service.UserInfoService;
/**
 * 用户授权
 * @author Administrator
 *reids:
 *		key:openid value:uuid
 *cookie 
 *		key:user_token value:openid
 */
@Controller
public class AuthorizeController {
	@Autowired
	private GithubProvider githubProvider;

	@Autowired
	private GithubCilent githubCilent;
	@Autowired
	private UserInfoService userInfoService;
	@Autowired
	private StringRedisTemplate redis;

	@GetMapping("/callback")
	public String callback(@RequestParam(name="code")String code,
							@RequestParam(name="state")String state,
							HttpServletRequest httpServletRequest,
							HttpServletResponse httpServletResponse
							) {
		AccessTokenDto dto = new AccessTokenDto();
		dto.setClient_id(githubCilent.getId());
		dto.setClient_secret(githubCilent.getSecret());
		dto.setCode(code);
		dto.setRedirect_uri(githubCilent.getRedirect_uri());
		dto.setState(state);
		//获取token
		String accessToken = githubProvider.getAccessToken(dto);
		//获取user信息
		GithubUser user = githubProvider.getUser(accessToken);
		
		if(user != null) {
			//查询数据库user是否存在
			UserInfo userInfo = userInfoService.findByOpenId(user.getId().toString());
			if(userInfo==null) {
				//user不存在，保存到数据库
				UserInfo info = new UserInfo();
				info.setOpenId(user.getId().toString());
				info.setUserBio(user.getBio());
				info.setUserName(user.getName());
				info.setUserImg(user.getAvatar_url());
				userInfoService.saveUserInfo(info);
			}
			//保存session到redis
			redis.opsForValue().set(userInfo.getOpenId(),UUID.randomUUID().toString(),1,TimeUnit.DAYS);
			
			//把token返回
			httpServletResponse.addCookie(new Cookie("user_token",userInfo.getOpenId()));
			
			return "redirect:/";
		}
		
		return "redirect:/";
	}
}