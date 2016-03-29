package org.shadow.controller;

import org.shadow.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/verify")
	@ResponseBody
	public String verify(@RequestParam(value = "name", required = true) String name,
			@RequestParam(value = "password", required = true) String password) {
		
		if (loginService.verity(name, password)) {
			return "success";
		} 
		return "failed";
	}

}
