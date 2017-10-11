package com.jackie.service;

import org.springframework.stereotype.Service;

import com.jackie.dao.CategoryDao;
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
}
