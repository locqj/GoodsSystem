package com.jackie.service;

import org.springframework.stereotype.Service;

import com.jackie.dao.UsersDao;

@Service
public class AjaxService {
	public int delUser(int id){
		UsersDao userOperation = new UsersDao();
		return userOperation.delUser(id);
	}
}
