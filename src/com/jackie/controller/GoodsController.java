package com.jackie.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.service.GoodsService;
import com.jackie.vo.Category;

@Controller
@RequestMapping("goodsadmin")
public class GoodsController {
	@Resource
	GoodsService service;
	
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("index")
	public ModelAndView doIndex(ModelMap model){
		CategoryDao dao = new CategoryDao();
		List<Category> categorys = dao.getList();
		model.put("categorys", categorys);
		return new ModelAndView("goodsadmin");
		
	}
	
	@RequestMapping("toaddgoods")
	public ModelAndView doAdd() throws UnsupportedEncodingException{
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("good_name");
		String number= request.getParameter("good_num");
		String category_code = request.getParameter("category_code");
		service.addGoods(name, number, category_code);
		return new ModelAndView("redirect:/goodsadmin/index");
	}
}
