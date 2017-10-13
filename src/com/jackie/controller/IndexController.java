package com.jackie.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodLogsDao;
import com.jackie.dao.GoodsDao;
import com.jackie.service.IndexService;
import com.jackie.service.LoginService;
import com.jackie.vo.Category;
import com.jackie.vo.GoodLogs;
import com.jackie.vo.Goods;
import com.jackie.vo.Users;

@Controller
public class IndexController {
	@Resource
	LoginService service;
	@Resource
	IndexService loginservice;
	@Resource
	HttpServletRequest request;
	
	
	@RequestMapping("index")
	public ModelAndView superUser(ModelMap model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		CategoryDao categorydao = new CategoryDao();
		GoodsDao goodsdao = new GoodsDao();
		List<Users> users= loginservice.getClientUsers();
		List<Category> categorys = categorydao.getList();
		List<Goods> goods = goodsdao.getList();
		model.put("categorys", categorys);
		model.put("goods", goods);
		model.put("users", users);
		return new ModelAndView("index");
		
	}
	
	@RequestMapping("indexc")
	public ModelAndView normalUser(ModelMap model, HttpSession session) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String user_code = (String) session.getAttribute("usercode"); //当前用户code
		GoodsDao goodsdao = new GoodsDao();
		GoodLogsDao goodlogsdao = new GoodLogsDao();
		List<Goods> goods = goodsdao.getList();
		List<GoodLogs> goodlogs = goodlogsdao.getListByUserCode(user_code);
		model.put("good", goods);
	 
		model.put("goodlogs", goodlogs);
		return new ModelAndView("indexc");
		
	}
}
