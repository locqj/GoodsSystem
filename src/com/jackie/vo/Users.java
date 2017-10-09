package com.jackie.vo;

public class Users {
	private String name;
	private String pwd;
	private String code;
	private int id;
	private int status;
	private int stataus_del;
	
	
public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStataus_del() {
		return stataus_del;
	}
	public void setStataus_del(int stataus_del) {
		this.stataus_del = stataus_del;
	}
	//	public Users(String name, String pwd, String code) {
//		super();
//		this.name = name;
//		this.pwd = pwd;
//		this.code = code;
//	}
	public String getName() {
		return name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
