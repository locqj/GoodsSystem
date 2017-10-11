package com.jackie.dao;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jackie.mybatis.inter.ICategoryOperation;
import com.jackie.mybatis.inter.IUserOperation;
import com.jackie.vo.Category;
import com.jackie.vo.Users;

public class CategoryDao {
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
	
	/**
	 * 添加类别
	 * @param name
	 * @return
	 */
	public int addCategory(String name) {
		int count = this.getCount();
		String code = "C"+count;
		Category category = new Category();
		category.setName(name);
		category.setCode(code);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ICategoryOperation co = session.getMapper(ICategoryOperation.class);
			int a = co.add(category);
			session.commit();
			System.out.println("新增类别id" + category.getId());
			return a;
		} finally {
			session.close();
		}
	}
	
	public int getCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ICategoryOperation co = session.getMapper(ICategoryOperation.class);
			int count = co.getCount();
			return count;

		} finally {
			session.close();
		}
	}
	/**
	 * 获取category list
	 * @return
	 */
	public List<Category> getList(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            ICategoryOperation co = session.getMapper(ICategoryOperation.class);
            List<Category> category = co.getList();
//            for(Category c :category){
//            	System.out.println(c.getName());
//            }
            return category;
        } finally {
            session.close();
        }
	}
	
	
	public int delCategory(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			ICategoryOperation co= session.getMapper(ICategoryOperation.class);
			int status= co.delCategory(id);
			 session.commit();
	         return status;

		} finally {
			session.close();
		}
	}
	

}
