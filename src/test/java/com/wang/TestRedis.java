package com.wang;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TestRedis {
	@Autowired
	private StringRedisTemplate stringRedisTemple;
//	@Autowired
//	private RedisTemplate<String, Object> RedisTemplate;
	@Test
	public void test1() {
		//stringRedisTemple.opsForValue().set("cicada","smile");
		String va = stringRedisTemple.opsForValue().get("cicada");
		System.out.println(va);
	}
}
