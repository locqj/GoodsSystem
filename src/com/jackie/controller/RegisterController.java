package com.jackie.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.service.RegisterService;

@Controller
public class RegisterController {
	@Resource
	RegisterService service;
	
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("register")
	public String toRegisterPage(){
		return "register";
	}
	
	@RequestMapping("toregister")
	public ModelAndView doRegister(){
		
		String registerUrl = "register";
		String successPageUrl = "success";
		
		String uname = request.getParameter("uname");
		String upasswd = request.getParameter("upasswd");
		String uspasswd = request.getParameter("uspasswd");
		return service.doRegister(registerUrl, successPageUrl, uname, upasswd, uspasswd);
		
	}
}
