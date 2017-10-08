package com.jackie.mybatis.inter;

import org.apache.ibatis.annotations.Select;

import com.jackie.vo.Users;

public interface IUserOperation {   
	
    public Users selectUserByID(int id);
    
}
