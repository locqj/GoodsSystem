package com.jackie.dao;

import java.io.Reader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jackie.mybatis.inter.ICategoryOperation;
import com.jackie.mybatis.inter.IGoodLogsOperation;
import com.jackie.vo.Category;
import com.jackie.vo.GoodLogs;

public class GoodLogsDao {
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
	public int addGoodLogs(String goods_code, String num, String user_code) {
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(date);
		
		
		GoodLogs goodlogs =new GoodLogs();
		goodlogs.setUser_code(user_code);
		goodlogs.setGoods_code(goods_code);
		goodlogs.setNum(num);
		goodlogs.setTime(time);
		
		SqlSession session = sqlSessionFactory.openSession();
		try {
			IGoodLogsOperation glo = session.getMapper(IGoodLogsOperation.class);
			int a = glo.add(goodlogs);
			session.commit();
			System.out.println("新增类别id" + goodlogs.getId());
			return a;
		} finally {
			session.close();
		}
	}
}