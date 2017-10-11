package com.jackie.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodsDao;
import com.jackie.vo.Goods;

@Service
public class GoodsService {
	
	/**
	 * 添加消耗品
	 * @param name
	 * @param num
	 * @param category_code
	 * @return
	 */
	public ModelAndView addGoods(String name, String num, String category_code) {
		GoodsDao dao = new GoodsDao();
		dao.addGoods(name, num, category_code);
		return new ModelAndView("redirect:/categoryadmin/index");
	}
}
