package com.jackie.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.service.LoginService;

@Controller
public class IndexController {
	@Resource
	LoginService service;
	
	@Resource
	HttpServletRequest request;	
	@RequestMapping("index")
	public ModelAndView doLogin(HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String loginPageUrl = "index";
		String successPageUrl = "success";
		
		String uname = request.getParameter("uname");
		String upasswd = request.getParameter("upasswd");
		return new ModelAndView("index");
		
	}
}
