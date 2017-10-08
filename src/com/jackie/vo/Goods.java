package com.jackie.vo;

public class Goods {
	private int id;
	private String name;
	private int num;
	private String category_code;
	private String code;
	private String time;
	
	public Goods(int id, String name, int num, String category_code, String code, String time) {
		super();
		this.id = id;
		this.name = name;
		this.num = num;
		this.category_code = category_code;
		this.code = code;
		this.time = time;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getCategory_code() {
		return category_code;
	}

	public void setCategory_code(String category_code) {
		this.category_code = category_code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	
}
