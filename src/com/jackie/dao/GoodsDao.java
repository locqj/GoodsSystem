package com.jackie.dao;

import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jackie.mybatis.inter.ICategoryOperation;
import com.jackie.mybatis.inter.IGoodsOperation;
import com.jackie.mybatis.inter.IUserOperation;
import com.jackie.vo.Category;
import com.jackie.vo.Goods;
import com.jackie.vo.Users;

public class GoodsDao {
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
	 * 获取goods list
	 * 
	 * @return
	 */
	public List<Goods> getList() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IGoodsOperation go = session.getMapper(IGoodsOperation.class);
			List<Goods> goods = go.getList();
			// for(Category c :category){
			// System.out.println(c.getName());
			// }
			return goods;
		} finally {
			session.close();
		}
	}

	public void addGoods(String name, String num, String category_code) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		String code = "G" + this.getCount();
		Goods good = new Goods();
		good.setName(name);
		good.setNum(num);
		good.setCategory_code(category_code);
		good.setTime(time);
		good.setCode(code);
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IGoodsOperation go = session.getMapper(IGoodsOperation.class);
			go.add(good);
			session.commit();
			System.out.println("新增ID" + good.getId());
		} finally {
			session.close();
		}
	}

	public int getCount() {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IGoodsOperation go = session.getMapper(IGoodsOperation.class);
			int count = go.getCount();
			return count;

		} finally {
			session.close();
		}
	}

	/**
	 * 删除消耗品
	 * 
	 * @param id
	 * @return
	 */
	public int delGood(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IGoodsOperation go = session.getMapper(IGoodsOperation.class);
			int status = go.delGood(id);
			session.commit();
			return status;

		} finally {
			session.close();
		}
	}



}
