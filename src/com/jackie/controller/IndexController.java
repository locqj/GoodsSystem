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
	public ModelAndView superUser(HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("indexc")
	public ModelAndView normalUser(HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		return new ModelAndView("indexc");
		
	}
}
