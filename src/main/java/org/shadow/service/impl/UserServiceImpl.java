package org.shadow.service.impl;

import java.util.List;

import org.shadow.dao.UserMapper;
import org.shadow.entity.User;
import org.shadow.service.UserService;
import org.shadow.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	public User getUser(long id) {
		return mapper.getUser(id);
	}

	@Override
	public List<User> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public int insertUser(User user) {
		user.setPassword(EncryptUtils.toMD5String(user.getPassword(), null));
		long timestamp = System.currentTimeMillis();
		user.setCreateTime(timestamp);
		user.setLastTime(timestamp);

		int effectRecord = 0;
		try {
			effectRecord = mapper.insertUser(user);
		} catch (DuplicateKeyException e) {
			System.err.println("插入多条记录");
		}

		return effectRecord;
	}

	@Override
	public int deleteUser(long id) {
		return mapper.deleteUser(id);
	}

	@Override
	public int changePassword(long id, String newPassword) {
		return mapper.changePassword(id, EncryptUtils.toMD5String(newPassword, null));
	}

}
