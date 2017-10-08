package com.jackie.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.vo.Users;
import com.jackie.dao.UsersDao;
@Service
public class RegisterService {
	
	
	Users user;
	public ModelAndView doRegister(String registerUrl, String successPageUrl, String uname, String upasswd, String uspasswd) {
		if (uname == null || "".equals(uname)) {
			String message = "用户名不得为空";
			return new ModelAndView(registerUrl, "message", message);
		} else if (upasswd == null || "".equals(upasswd)) {
			String message = "密码不得为空";
			return new ModelAndView(registerUrl, "message", message);
		} else {
			//写数据库逻辑
			UsersDao newusers = new UsersDao();
			newusers.addUser(uname, upasswd);
			return new ModelAndView(successPageUrl);
		}	
	}
}
