package com.jackie.service;

import org.springframework.stereotype.Service;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodLogsDao;
import com.jackie.dao.GoodsDao;
import com.jackie.dao.UsersDao;

@Service
public class AjaxService {
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	public int delUser(int id){
		UsersDao uo = new UsersDao();
		return uo.delUser(id);
	}
	
	/**
	 * 删除类目
	 * @param id
	 * @return
	 */
	public int delCategory(int id){
		CategoryDao co = new CategoryDao();
		return co.delCategory(id);
	}
	
	/**
	 * 删除good
	 * @param id
	 * @return
	 */
	public int delGood(int id){
		GoodsDao co = new GoodsDao();
		return co.delGood(id);
	}

 
	public int updategoodlogs(int id, int status) {
		GoodLogsDao glo = new GoodLogsDao();
		return glo.updateLog(id, status);
		 
	}
}
