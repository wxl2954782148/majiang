package com.wang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.config.GithubCilent;

@SpringBootTest
@RunWith(SpringRunner.class)
public class Testconfig {
	@Autowired
	private GithubCilent githubCilent;
	@Test
	public void test() {
		System.out.println(githubCilent.getId());
	}
	@Test
	public void test2() {
		String tag = "aaa";
		String[] tags = tag.split(";");
		for(int i=0;i<tags.length;i++) {
			System.out.println(tags[i]);
		}
	}
}
