package org.shadow.controller;

import java.util.List;

import org.shadow.entity.User;
import org.shadow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public User getUserInfo(@PathVariable long id)
	{
		return userService.getUser(id);
	}
	
	@RequestMapping("/users")
	@ResponseBody
	public List<User> getUserInfoList()
	{
		return userService.getUserList();
	}
	
}
