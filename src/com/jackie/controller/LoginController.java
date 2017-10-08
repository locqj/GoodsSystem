package com.jackie.controller;
 

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.service.LoginService;

@Controller
public class LoginController {

	@Resource
	LoginService service;
	
	@Resource
	HttpServletRequest request;	
	@RequestMapping("login")
	public ModelAndView doLogin(){
		
		String loginPageUrl = "login";
		String successPageUrl = "success";
		
		String uname = request.getParameter("uname");
		String upasswd = request.getParameter("upasswd");
		
		return service.doLogin(loginPageUrl, successPageUrl, uname, upasswd);
		
	}
	
}