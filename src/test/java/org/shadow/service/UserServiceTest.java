package org.shadow.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shadow.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test
	public void testGetUserInfo() {
		User user = userService.getUserInfo(1);
		System.err.println(user.toString());
	}

}
