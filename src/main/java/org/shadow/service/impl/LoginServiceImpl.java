package org.shadow.service.impl;

import org.apache.log4j.Logger;
import org.shadow.dao.LoginMapper;
import org.shadow.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
	
	private final static Logger logger = Logger.getLogger(LoginServiceImpl.class);

	@Autowired
	private LoginMapper loginMapper;

	@Override
	public boolean verity(String name, String password) {

		if (loginMapper.verify(name, password) == 1) {
			
			return true;
		}
		
		return false;
	}

}
