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
public class LoginController {

	@Resource
	LoginService service;
	
	@Resource
	HttpServletRequest request;	
	@RequestMapping("login")
	public ModelAndView doLogin(HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		
		String loginPageUrl = "login";
		String successPageUrl = "index";
		
		String uname = request.getParameter("uname");
		String upasswd = request.getParameter("upasswd");
		return service.doLogin(session, loginPageUrl, successPageUrl, uname, upasswd);
		
	}
	
    
  /** 
   * 退出系统 
   * @param session 
   *          Session 
   * @return 
   * @throws Exception 
   */  
  @RequestMapping("logout")  
  public String logout(HttpSession session) throws Exception{  
      //清除Session  
      session.invalidate();
      return "login";
  }
	
}