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
			String message = "�û�������Ϊ��";
			return new ModelAndView(loginPageUrl, "message", message);
		}

		if (upasswd == null || "".equals(upasswd)) {
			String message = "���벻��Ϊ��";
			return new ModelAndView(loginPageUrl, "message", message);
		}
		// uname = admin , passwd = 123
		if (uname.equals("admin") && upasswd.equals("123")) {
			return new ModelAndView(successPageUrl);
		}
		return new ModelAndView(loginPageUrl, "message", "�û��������������");
	}


}
