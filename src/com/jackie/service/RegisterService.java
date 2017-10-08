package com.jackie.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.vo.Users;

@Service
public class RegisterService {

	public ModelAndView doRegister(String registerUrl, String successPageUrl, String uname, String upasswd, String uspasswd) {
		if (uname == null || "".equals(uname)) {
			String message = "�û�������Ϊ��";
			return new ModelAndView(registerUrl, "message", message);
		} else if (upasswd == null || "".equals(upasswd)) {
			String message = "���벻��Ϊ��";
			return new ModelAndView(registerUrl, "message", message);
		} else if (upasswd != uspasswd) {
			String message = "�������벻һ��";
			return new ModelAndView(registerUrl, "message", message);
		} else {
			
			return new ModelAndView(successPageUrl);
		}
		
	}


}
