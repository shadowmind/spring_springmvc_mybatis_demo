package org.shadow.service.impl;

import java.util.List;

import org.shadow.dao.UserMapper;
import org.shadow.entity.User;
import org.shadow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper mapper;
	
	@Override
	public User getUserInfo(long id) {
		return mapper.getUserInfo(id);
	}

	@Override
	public List<User> getUserInfoList() {
		return mapper.getUserInfoList();
	}

}
