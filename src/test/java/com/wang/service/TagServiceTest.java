package com.wang.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.model.Tag;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TagServiceTest {
	@Autowired
	private TagService tagService ;
	@Test
	public void findByName() {
		Tag tag = tagService.findByTagName("java");
		System.out.println(tag.getTagId());
	}
}
