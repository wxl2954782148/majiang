package com.wang.provider;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wang.config.GithubCilent;
import com.wang.dto.AccessTokenDto;
import com.wang.dto.GithubUser;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@Component
public class GithubProvider {
	
	public String getAccessToken(AccessTokenDto accessTokenDto) {
		MediaType mediaType = MediaType.get("application/json; charset=utf-8");
		OkHttpClient client = new OkHttpClient();
		RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDto));
		Request request = new Request.Builder().url("https://github.com/login/oauth/access_token")
				.post(body)
				.build();
		try (Response response = client.newCall(request).execute()) {
			String string = response.body().string();
			//string = "access_token=8c1c2d005fbc03124823e183f7c0a6025e7101a5&scope=&token_type=bearer"
			String access_token = string.split("&")[0].split("=")[1];
			System.out.println(access_token);
			return access_token;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public GithubUser getUser(String accessToken) {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder()
				.url("https://api.github.com/user?access_token="+accessToken)
				.build();
		Response response;
		try {
			response = client.newCall(request).execute();
			String string = response.body().string();
			GithubUser githubUser = JSON.parseObject(string,GithubUser.class);
			return githubUser;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
}
