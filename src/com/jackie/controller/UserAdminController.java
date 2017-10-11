package com.jackie.controller;



import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.service.AjaxService;
import com.jackie.service.IndexService;
import com.jackie.vo.Users;


@Controller
@RequestMapping("useradmin")
public class UserAdminController {
	@Resource
	IndexService service;
	@Resource
	AjaxService ajaxservice;
	@Resource
	HttpServletRequest request;	
	@RequestMapping("index")
	
	public ModelAndView userAdmin(HttpSession session){
		List<Users> users= service.getClientUsers();
		return new ModelAndView("useradmin", "users", users);
		
	}
	
	@RequestMapping(value="del", method=RequestMethod.POST)
	@ResponseBody
	public String del(int id){
		
		int a = ajaxservice.delUser(id);
		
		if (a == 1) {
			return "ok";
		} else {
			return "error";
		}
		
	}
}
