package org.shadow.service;

import java.util.List;

import org.shadow.entity.User;

public interface UserService {

	public User getUserInfo(long id);
	
	public List<User> getUserInfoList();
}
