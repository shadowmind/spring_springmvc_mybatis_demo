package org.shadow.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.shadow.entity.User;

public interface UserMapper {

	public User getUserInfo(@Param("id") long id);
	
	public List<User> getUserInfoList();
}
