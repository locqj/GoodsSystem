<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
超级首页
	<h1>登录成功</h1>
<%
String ls_str=null;
ls_str=(String)session.getAttribute("username");
out.println("从session里取出的值为："+ls_str);
%>
<a href="logout">logout</a>
<ul>
	<li><a href="useradmin/index">普通用户管理</a></li>
	<li><a href="categoryadmin/index">易耗品类别管理</a></li>
	<li><a href="goodsadmin/index">易耗品入库</a></li>
</ul>
</body>
</html>