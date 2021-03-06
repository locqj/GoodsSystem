package com.jackie.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jackie.mybatis.inter.IUserOperation;
import com.jackie.vo.Users;

public class UsersDao {

	private static SqlSessionFactory sqlSessionFactory;
	private static Reader reader;

	static {
		try {
			reader = Resources.getResourceAsReader("mybatis_config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static SqlSessionFactory getSession() {
		return sqlSessionFactory;
	}


	public void addUser(String name, String pwd, String code) {
		Users user = new Users();
		user.setName(name);
		user.setPwd(pwd);
		user.setCode(code);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			userOperation.addUser(user);
			session.commit();
			System.out.println("新增用户ID" + user.getId());
		} finally {
			session.close();
		}
	}

	public int disUsersName(String userName) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			Users users = userOperation.selectUsersByName(userName);
			if (users != null) {
				return 1;
			} else {
				return 0;
			}

		} finally {
			session.close();
		}
	}

	public int getUsersCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			int count = userOperation.selectUsersCount();

			return count;

		} finally {
			session.close();
		}
	}

	public String getUserPwd(String name) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IUserOperation userOperation = session.getMapper(IUserOperation.class);
			String pwd = userOperation.getUserpwd(name);
			if (pwd != null) {
				return pwd;
			}

		} finally {
			session.close();
		}
		return "null";
	}
	/**
	 * 
	 * @param name
	 * @return
	 */
    public Users getUserList(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            IUserOperation userOperation = session
                    .getMapper(IUserOperation.class);
            Users users = userOperation.selectUsersByName(userName);
            return users;

        } finally {
            session.close();
        }
		
    }
    /**
     *  
     * @return
     */
    public List<Users> getClientUsers() {
    	 SqlSession session = sqlSessionFactory.openSession();
         try {
             IUserOperation userOperation = session
                     .getMapper(IUserOperation.class);
             List<Users> users = userOperation.getClientUsers();
              
             return users;

         } finally {
             session.close();
         }
    }
    
    /**
     * del user
     * @param id
     * @return
     */
    public int delUser(int id){
    	
   	 SqlSession session = sqlSessionFactory.openSession();
     try {
         IUserOperation userOperation = session
                 .getMapper(IUserOperation.class);
         int status = userOperation.delUser(id);
         session.commit();
         return status;

     } finally {
         session.close();
     }
    }

}
