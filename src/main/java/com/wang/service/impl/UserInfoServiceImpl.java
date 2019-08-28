package com.wang.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wang.model.UserInfo;
import com.wang.repository.UserInfoRepository;
import com.wang.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService{
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Override
	public UserInfo findByOpenId(String openId) {
		Optional<UserInfo> optional =userInfoRepository.findById(openId);
		return optional.get();
	}
	@Override
	public void saveUserInfo(UserInfo info) {
		userInfoRepository.save(info);
	}

}
