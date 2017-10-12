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

import com.jackie.dao.GoodsDao;
import com.jackie.service.GetGoodsService;

import com.jackie.vo.Goods;

@Controller
@RequestMapping("getgoods")
public class GetGoodsController {
	@Resource
	GetGoodsService service;
	@Resource
	HttpServletRequest request;

	@RequestMapping("index")
	public ModelAndView index(ModelMap model) throws NoSuchAlgorithmException, UnsupportedEncodingException {

		GoodsDao goodsdao = new GoodsDao();
		List<Goods> goods = goodsdao.getList();
		model.put("good", goods);
		return new ModelAndView("getgoods");
	}

	@RequestMapping("toaddgoodlog")
	public ModelAndView doAdd(ModelMap model, HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String goods_code = request.getParameter("good_code");
		String num = request.getParameter("good_num");
		String user_code = (String) session.getAttribute("usercode");
		service.addGoodLogs(goods_code, num, user_code);
		return new ModelAndView("redirect:/getgoods/index");
	}
}
