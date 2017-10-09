package com.jackie.mybatis.inter;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.jackie.vo.Users;

public interface IUserOperation {   
	
    public Users selectUserByID(int id);
    public void addUser(Users user);
    public List<Users> selectUsersByName(String userName);
    public int selectUsersCount();
    public String getUserpwd(String name);
}
