package com.jackie.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.vo.Users;

import sun.misc.BASE64Encoder;

import com.jackie.dao.UsersDao;
@Service
public class RegisterService {
	
	
	Users user;
	public ModelAndView doRegister(String registerUrl, String successPageUrl, String uname, String upasswd, String uspasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException {
 
			upasswd = EncoderByMd5(upasswd);
			UsersDao newusers = new UsersDao();
			
			int distName = newusers.disUsersName(uname);
			int count = newusers.getUsersCount();
			String code = "U"+count;
			if (distName == 0) {
				newusers.addUser(uname, upasswd, code);
				return new ModelAndView(successPageUrl);
			} else {
				String message = "用户已存在";
				return new ModelAndView(registerUrl, "message", message);
			}
			
		 	
	}
	
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
 
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder(); 
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	
	/** 
	   * @param newpasswd 
	   * @param oldpasswd 
	   * @return
	   * @throws NoSuchAlgorithmException
	   * @throws UnsupportedEncodingException
	   */
	  public boolean checkpassword(String newpasswd,String oldpasswd) throws NoSuchAlgorithmException, UnsupportedEncodingException{
	    if(EncoderByMd5(newpasswd).equals(oldpasswd))
	      return true;
	    else
	      return false;
	  }
}
