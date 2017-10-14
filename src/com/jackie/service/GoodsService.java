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
	/**	
	 * 申请通过后获取剩余物品num
	 * @param num
	 * @param code
	 * @return 如果大于零就可以通过申请， 小于零说明该物品超过
	 */
	public int getGoodNum(int num, String code){
		GoodsDao dao = new GoodsDao();
		int r_num = dao.getGoodNum(code);
		int result = r_num - num;
		if (result >= 0) {
			dao.updateGoodNum(code, result);
			return result;
		} else {
			return -1;
		}
	}
	
	/**	
	 * 撤销后good num 修改
	 * @param num
	 * @param code
	 * @return 如果大于零就可以通过申请， 小于零说明该物品超过
	 */
	public int goodNumChange(int num, String code){
		GoodsDao dao = new GoodsDao();
		int old_num = dao.getGoodNum(code);
		int new_num = old_num + num ;
		return dao.updateGoodNum(code, new_num);
		
	}
}
