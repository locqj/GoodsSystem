package com.jackie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jackie.vo.Users;
import com.jackie.dao.UsersDao;

@Service
public class IndexService {
	
	public List<Users> getClientUsers(){
		UsersDao userOperation = new UsersDao();
		return userOperation.getClientUsers();
	}
}
