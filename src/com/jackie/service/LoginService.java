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
		
		if (uname == null || "".equals(uname)) {
			String message = "用户名不得为空";
			return new ModelAndView(loginPageUrl, "message", message);
		} else if (upasswd == null || "".equals(upasswd)) {
			String message = "密码不得为空";
			return new ModelAndView(loginPageUrl, "message", message);
		} else {
			UsersDao userOperation = new UsersDao();
			String sqlPwd = userOperation.getUserPwd(uname);
			if (sqlPwd == "null") {
				return new ModelAndView(loginPageUrl, "message", "不存在该用户");
			}
			if(checkpassword(upasswd, sqlPwd)) {
                Users user = new Users();
                user.setName(uname);
                session.setAttribute("username", user.getName());
                System.out.println(user.getName());
				return new ModelAndView(successPageUrl);
			} else {
				return new ModelAndView(loginPageUrl, "message", "用户名或者密码错误");
			}
			
		}
		
	}

	/**
	 * 判断用户密码是否正确
	 * 
	 * @param newpasswd
	 *            用户输入的密码
	 * @param oldpasswd
	 *            数据库中存储的密码－－用户密码的摘要
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
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	

}
