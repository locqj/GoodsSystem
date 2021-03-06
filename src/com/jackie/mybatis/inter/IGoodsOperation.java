package com.jackie.mybatis.inter;

import java.util.List;

import com.jackie.vo.Goods;

public interface IGoodsOperation {
	public int add(Goods good);
	public int getCount();
	public List<Goods> getList();
	public int delGood(int id);
	public int getGoodNum(String code);
	public int updateGoodNum(String code, int r_num);
}
