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
    
    /**
     * 增加后要commit
     */
    public void addUser() {
        Users user = new Users();
        user.setName("place");
        user.setPwd("test_add");
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
    
    public static void main(String[] args) {
    	
//        try {
//            Test test = new Test();
//            // test.getUserByID(1);
//            // test.getUserList("test1");
//             test.addUser();
//            // test.updateUser();
//            // test.deleteUser(6);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
    }
}