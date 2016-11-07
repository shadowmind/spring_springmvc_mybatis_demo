package org.shadow.service;

import java.util.List;

import org.shadow.entity.User;

public interface UserService {

	public User getUser(long id);

	public List<User> getUserList();

	public int insertUser(User user);

	public int deleteUser(long id);
	
	public int changePassword(long id, String newPassword);
}
