package com.jackie.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.vo.Users;

@Service
public class LoginService {

	public ModelAndView doLogin(String loginPageUrl, String successPageUrl, String uname, String upasswd) {
		if (uname == null || "".equals(uname)) {
			String message = "用户名不得为空";
			return new ModelAndView(loginPageUrl, "message", message);
		}

		if (upasswd == null || "".equals(upasswd)) {
			String message = "密码不得为空";
			return new ModelAndView(loginPageUrl, "message", message);
		}
		// uname = admin , passwd = 123
		if (uname.equals("admin") && upasswd.equals("123")) {
			return new ModelAndView(successPageUrl);
		}
		return new ModelAndView(loginPageUrl, "message", "用户名或者密码错误");
	}


}
