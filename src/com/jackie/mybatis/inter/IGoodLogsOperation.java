package com.jackie.mybatis.inter;

import java.util.List;

import com.jackie.vo.GoodLogs;

public interface IGoodLogsOperation {
	public  int add(GoodLogs goodlogs);
	public List<GoodLogs> getList();
	public List<GoodLogs> getListByUserCode(String user_code);
}
