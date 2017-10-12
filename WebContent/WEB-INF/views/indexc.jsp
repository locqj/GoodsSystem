<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
普通用户
<%
String ls_str=null;
ls_str=(String)session.getAttribute("username");
out.println("从session里取出的值为："+ls_str);
%>
<a href="logout">logout</a>
<ul>
	<li><a href="getgoods/index">申请消耗品</a></li>
	<li><a href="download/index">导出</a></li>
</ul>
</body>
</html>