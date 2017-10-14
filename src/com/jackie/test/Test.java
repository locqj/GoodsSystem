package com.jackie.test;

import java.util.List;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodLogsDao;
import com.jackie.dao.GoodsDao;
import com.jackie.dao.UsersDao;
import com.jackie.service.GoodsService;
import com.jackie.vo.Category;
import com.jackie.vo.GoodLogs;
import com.jackie.vo.Goods;

public class Test {

    
    /**
     * @param args
     */
    public static void main(String[] args) {
    	
    	UsersDao userOperation = new UsersDao();
    	CategoryDao categorydao = new CategoryDao();
    	GoodsDao goodsdao = new GoodsDao();
    	GoodLogsDao goodlogsdao = new GoodLogsDao();
    	GoodsService s = new GoodsService();
    	int a = goodsdao.updateGoodNum("G0", 12);
    	
    	System.out.println(a);
    	
		
    }
}