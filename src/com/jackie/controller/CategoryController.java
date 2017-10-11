package com.jackie.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.service.AjaxService;
import com.jackie.service.CategoryService;
import com.jackie.vo.Category;

@Controller
@RequestMapping("categoryadmin")
public class CategoryController {
	@Resource
	CategoryService service;

	@Resource
	HttpServletRequest request;
	
	@Resource
	AjaxService ajaxservice;
	
	@RequestMapping("index")
	public ModelAndView doIndex() {
		CategoryDao dao = new CategoryDao();
		List<Category> categorys = dao.getList();
		return new ModelAndView("categoryadmin", "categorys", categorys);

	}

	@RequestMapping("toaddcategory")
	public ModelAndView doadd() throws UnsupportedEncodingException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		return service.addCategory(name);

	}
	
	@RequestMapping(value="del", method=RequestMethod.POST)
	@ResponseBody
	public String del(int id){
		int a = ajaxservice.delCategory(id);
		
		if (a == 1) {
			return "ok";
		} else {
			return "error";
		}
		
	}

}
