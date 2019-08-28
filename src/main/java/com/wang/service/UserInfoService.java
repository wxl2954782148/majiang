package com.wang.service;

import com.wang.model.UserInfo;

public interface UserInfoService {
	UserInfo findByOpenId(String openId);
	void saveUserInfo(UserInfo info);
}
