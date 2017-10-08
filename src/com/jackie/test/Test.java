package com.jackie.test;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



import com.jackie.mybatis.inter.IUserOperation;
import com.jackie.vo.Users;

public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 

    static{
        try{
            reader    = Resources.getResourceAsReader("mybatis_config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSession(){
        return sqlSessionFactory;
    }
    
    public static void main(String[] args) {
    	SqlSession session = sqlSessionFactory.openSession();
        try {
        	 
            IUserOperation userOperation=session.getMapper(IUserOperation.class);
            Users user = userOperation.selectUserByID(1);
            System.out.println(user.getName());
            System.out.println(user.getPwd());
        } finally {
            session.close();
        }
    }
}