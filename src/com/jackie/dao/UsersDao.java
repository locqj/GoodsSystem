package com.jackie.dao;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jackie.mybatis.inter.IUserOperation;
import com.jackie.vo.Users;

public class UsersDao {
	
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
    
    /**
     * 增加后要commit
     */
    public void addUser(String name, String pwd) {
        Users user = new Users();
        user.setName(name);
        user.setPwd(pwd);
        user.setCode("021");
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session
                    .getMapper(IUserOperation.class);
            userOperation.addUser(user);
            session.commit();
            System.out.println("新增用户ID：" + user.getId());
        } finally {
            session.close();
        }
    }
    
    
}
