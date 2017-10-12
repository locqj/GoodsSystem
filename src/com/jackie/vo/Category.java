package com.jackie.vo;

import java.util.List;

public class Category {
	private int id;
	private String name;
	private String code;
	private List<Goods> goods;
	

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", code=" + code + ", goods=" + goods + "]";
	}

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	
	
	
}
