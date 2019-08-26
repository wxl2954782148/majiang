package com.wang.repository;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.model.UserInfo;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserInfoRepositoryTest {
	@Autowired
	private UserInfoRepository userInfoRepository;
	@Test
	public void test() {
		Optional<UserInfo> info = userInfoRepository.findById(1);
		System.out.println(info);
	}
}
