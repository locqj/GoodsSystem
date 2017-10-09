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
		if (uname == null || "".equals(uname)) {
			String message = "用户名不得为空";
			return new ModelAndView(registerUrl, "message", message);
		} else if (upasswd == null || "".equals(upasswd)) {
			String message = "密码不得为空";
			return new ModelAndView(registerUrl, "message", message);
		} else {
			//写数据库逻辑
			upasswd = EncoderByMd5(upasswd);
			UsersDao newusers = new UsersDao();
			
			int distName = newusers.disUsersName(uname);
			int count = newusers.getUsersCount();
			String code = "T"+count;
			if (distName == 1) {
				newusers.addUser(uname, upasswd, code);
				return new ModelAndView(successPageUrl);
			} else {
				String message = "该用户已存在！";
				return new ModelAndView(registerUrl, "message", message);
			}
			
		}	
	}
	
	public String EncoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	
	/**判断用户密码是否正确
	   * @param newpasswd 用户输入的密码
	   * @param oldpasswd 数据库中存储的密码－－用户密码的摘要
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
