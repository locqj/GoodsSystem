package com.jackie.mybatis.inter;

import org.apache.ibatis.annotations.*;

import com.jackie.vo.Users;

public interface IUserOperation {   
	
    public Users selectUserByID(int id);
    public void addUser(Users user);
}
