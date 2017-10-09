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
			String message = "�û�������Ϊ��";
			return new ModelAndView(loginPageUrl, "message", message);
		} else if (upasswd == null || "".equals(upasswd)) {
			String message = "���벻��Ϊ��";
			return new ModelAndView(loginPageUrl, "message", message);
		} else {
			
			UsersDao userOperation = new UsersDao();
			String sqlPwd = userOperation.getUserPwd(uname);
			if (sqlPwd == "null") {
				return new ModelAndView(loginPageUrl, "message", "�����ڸ��û�");
			}
			if(checkpassword(upasswd, sqlPwd)) {
				Users user= userOperation.getUserList(uname);//��ȡ�û�
                session.setAttribute("username", user.getName());
                System.out.println(user.getStatus());
                //�ж��û����� 1--��ͨ�û��� 2--�����û�
                if(user.getStatus() == 1) {
                	return new ModelAndView("redirect:/indexc");
                } else {
                	return new ModelAndView("redirect:/index");
                }
				
			} else {
				return new ModelAndView(loginPageUrl, "message", "�û��������������");
			}
			
		}
		
	}

	/**
	 * �ж��û������Ƿ���ȷ
	 * 
	 * @param newpasswd
	 *            �û����������
	 * @param oldpasswd
	 *            ���ݿ��д洢�����룭���û������ժҪ
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
        //ȷ�����㷽��
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //���ܺ���ַ���
        String newstr=base64en.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }
	

}
