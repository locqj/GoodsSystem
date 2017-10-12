package com.jackie.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodsDao;
import com.jackie.service.AjaxService;
import com.jackie.service.GoodsService;
import com.jackie.vo.Category;
import com.jackie.vo.Goods;

@Controller
@RequestMapping("goodsadmin")
public class GoodsController {
	@Resource
	GoodsService service;
	
	@Resource
	AjaxService ajaxservice;
	
	@Resource
	HttpServletRequest request;
	
	@RequestMapping("index")
	public ModelAndView doIndex(ModelMap model){
		CategoryDao categorydao = new CategoryDao();
		GoodsDao goodsdao = new GoodsDao();
		List<Category> categorys = categorydao.getList();
		List<Goods> goods = goodsdao.getList();
		model.put("categorys", categorys);
		model.put("goods", goods);
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
	
	@RequestMapping(value="del", method=RequestMethod.POST)
	@ResponseBody
	public String del(int id){
		int a = ajaxservice.delGood(id);
		
		if (a == 1) {
			return "ok";
		} else {
			return "error";
		}
		
	}
}
