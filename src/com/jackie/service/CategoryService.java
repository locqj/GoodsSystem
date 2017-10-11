package com.jackie.service;


import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.vo.Category;

@Service
public class CategoryService {

	public ModelAndView addCategory(String name) {
		CategoryDao dao = new CategoryDao();
		dao.addCategory(name);
		 
		return new ModelAndView("redirect:/categoryadmin/index");
	}

}
