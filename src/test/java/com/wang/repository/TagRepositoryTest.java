package com.wang.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wang.model.Tag;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TagRepositoryTest {
@Autowired
private TagRepository tagRepository;
@Test
public void testFindByTagName() {
	
}
}
