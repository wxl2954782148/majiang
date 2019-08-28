package com.wang.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.model.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, String>{
}
