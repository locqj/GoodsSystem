package com.jackie.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.jackie.dao.GoodLogsDao;
@Service
public class GetGoodsService {
	/**
	 * 添加消耗品
	 * @param name
	 * @param num
	 * @param category_code
	 * @return 
	 * @return
	 */
	public ModelAndView addGoodLogs(String goods_code, String num, String user_code) {
		GoodLogsDao dao = new GoodLogsDao();
		dao.addGoodLogs(goods_code, num, user_code);
		return new ModelAndView("redirect:/categoryadmin/index");

	}

}
