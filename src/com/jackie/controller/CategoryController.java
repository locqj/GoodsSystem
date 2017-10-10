package com.jackie.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.service.CategoryService;

@Controller
@RequestMapping("categoryadmin")
public class CategoryController {
	@Resource
	CategoryService service;
	
	@RequestMapping("index")
	public ModelAndView doIndex(HttpSession session){
		return new ModelAndView("categoryadmin");
//		return service.doLogin(session, loginPageUrl, successPageUrl, uname, upasswd);
		
	}
	
}
