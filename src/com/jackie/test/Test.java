package com.jackie.test;

import java.util.List;

import com.jackie.dao.CategoryDao;
import com.jackie.dao.GoodLogsDao;
import com.jackie.dao.GoodsDao;
import com.jackie.dao.UsersDao;
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
//		List<Goods> goods = goodsdao.getList();
//		for(Goods good: goods){
//			Category co = good.getCategory();
//			System.out.print(good.getCode());
//		}
    	List<GoodLogs> gls = goodlogsdao.getList();
    	for(GoodLogs gl: gls){
    		System.out.print(gl.getGood().getName());
    	}
		
    }
}