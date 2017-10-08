package com.jackie.vo;

public class GoodLogs {
	private int id;
	private String goods_code;
	private String time;
	private String user_code;
	private int num;
	public GoodLogs(int id, String goods_code, String time, String user_code, int num) {
		super();
		this.id = id;
		this.goods_code = goods_code;
		this.time = time;
		this.user_code = user_code;
		this.num = num;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGoods_code() {
		return goods_code;
	}
	public void setGoods_code(String goods_code) {
		this.goods_code = goods_code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUser_code() {
		return user_code;
	}
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
	
}
