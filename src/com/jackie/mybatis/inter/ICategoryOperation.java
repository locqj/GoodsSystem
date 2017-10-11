package com.jackie.mybatis.inter;

import java.util.List;

import com.jackie.vo.Category;

public interface ICategoryOperation {
	public int add(Category category);
	public int getCount();
	public List<Category> getList();
	public int delCategory(int id);
}
