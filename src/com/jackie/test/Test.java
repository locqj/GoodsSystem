package com.jackie.test;

import java.util.List;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodsDao;
import com.jackie.dao.UsersDao;
import com.jackie.vo.Category;

public class Test {

    
    public static void main(String[] args) {
    	
    	UsersDao userOperation = new UsersDao();
    	CategoryDao categorydao = new CategoryDao();
    	GoodsDao goodsdao = new GoodsDao();
//		List<Category> a = categorydao.getList();
		int a = goodsdao.getCount();
		System.out.println(a);
    }
}