package com.jackie.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.UsersDao;
import com.jackie.vo.Users;


import sun.misc.BASE64Encoder;

@Service
public class LoginService {

	public ModelAndView doLogin(HttpSession session, String loginPageUrl, String successPageUrl, String uname, String upasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
	 
			
			UsersDao userOperation = new UsersDao();
			String sqlPwd = userOperation.getUserPwd(uname);
			if (sqlPwd == "null") {
				return new ModelAndView(loginPageUrl, "message", "密码错误");
			}
			if(checkpassword(upasswd, sqlPwd)) {
				Users user= userOperation.getUserList(uname);
				//将用户code name 存入session
                session.setAttribute("username", user.getName());
                session.setAttribute("usercode", user.getCode());
                //1--普通用户, 2--超级用户
                if(user.getStatus() == 1) {
                	return new ModelAndView("redirect:/indexc");
                } else {
                	return new ModelAndView("redirect:/index");
                }
				
			} else {
				return new ModelAndView(loginPageUrl, "message", "密码错误");
			}
			
		 
		
	}

	/**
	 * 
	 * @param newpasswd
	 * @param oldpasswd
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException
	 */
	public boolean checkpassword(String newpasswd, String oldpasswd)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		if (EncoderByMd5(newpasswd).equals(oldpasswd))
			return true;
		else
			return false;
	}
	
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{

        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	

}
