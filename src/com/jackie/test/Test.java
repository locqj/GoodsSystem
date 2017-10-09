package com.jackie.test;

import com.jackie.dao.UsersDao;

public class Test {

    
    public static void main(String[] args) {
    	
    	UsersDao userOperation = new UsersDao();
		int a = userOperation.delUser(10);
		System.out.println(a);
    }
}