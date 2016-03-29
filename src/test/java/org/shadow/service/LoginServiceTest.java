package org.shadow.service;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class LoginServiceTest {
	private final static Logger logger = Logger.getLogger(LoginServiceTest.class);
	
	@Autowired
	private LoginService loginService;
	
	@Test
	public void testVerify()
	{
		String name = "admin";
		String password = "admin";
		
		boolean result = loginService.verity(name, password);
		System.err.println("verify result:" + result);
	}

}
