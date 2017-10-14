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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.GoodLogsDao;
import com.jackie.dao.GoodsDao;
import com.jackie.service.AjaxService;
import com.jackie.service.GetGoodsService;
import com.jackie.vo.GoodLogs;
import com.jackie.vo.Goods;

@Controller
@RequestMapping("getgoods")
public class GetGoodsController {
	@Resource
	GetGoodsService service;
	@Resource
	HttpServletRequest request;
	@Resource 
	AjaxService ajaxservice;
	@RequestMapping("toaddgoodlog")
	public ModelAndView doAdd(ModelMap model, HttpSession session) throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String user_code = (String) session.getAttribute("usercode"); //当前用户code
		String goods_code = request.getParameter("good_code");
		String num = request.getParameter("good_num");
		service.addGoodLogs(goods_code, num, user_code);
		return new ModelAndView("redirect:/indexc");
	}
	@RequestMapping(value="del", method=RequestMethod.POST)
	@ResponseBody
	public String del(int id){
		int a = ajaxservice.delGoodLog(id);
		
		if (a == 1) {
			return "ok";
		} else {
			return "error";
		}
		
	}
}
