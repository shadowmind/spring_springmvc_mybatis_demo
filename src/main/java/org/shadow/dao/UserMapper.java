package org.shadow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shadow.entity.User;

public interface UserMapper {

	public User getUser(@Param("id") long id);

	public List<User> getUserList();

	public int insertUser(User user);

	public int deleteUser(@Param("id") long id);

	public int changePassword(@Param("id") long id, @Param("newPassword") String newPassword);
}
