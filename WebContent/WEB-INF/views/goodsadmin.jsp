<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	易耗品管理


	<form action="toaddgoods" method="post" onsubmit="return check()">
		<p>
			消耗品： <input name="good_name" type="text" id="good_name">
		</p>
		<p>
			数目： <input name="good_num" type="number" id="good_num">
		</p>
		<p>
			类目： <select id="category_code" name="category_code">
				<option value="0">请选择</option>
				<c:forEach var="list" items="${categorys}">
					<option value="${list.code}">${list.name}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<hr>

	<ul>
		<tr>ID</tr>
		<tr>消耗品名</tr>
		<tr>消耗品数目</tr>
		<tr>消耗品类目</tr>
		<c:forEach var="list" items="${goods}">

			<li id="C${list.id}">
				<tr>${list.id}</tr>
				<tr>${list.name}</tr>
				<tr>${list.num}</tr>
				<tr>${list.category.name}</tr>
				<tr>
					<button onclick="del(${list.id})">删除</button>
				</tr>
			</li>

		</c:forEach>
	</ul>
</body>
<script type="text/javascript"
	src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
function check(){
	
	if($('#good_name').val() == ""){ 
		alert("请输入消耗品"); 
		return false;
	} else if($('good_num').val() == ""){
		alert("请输入数目"); 
		return false; 
	} else if($('#category_code').val() == '0') {
		alert("请选择类目"); 
		return false; 	
	}
	return true;
}
function del(id) {
	var r = confirm("确定删除吗？");
	if(r){
		$.post('del', {id: id}, function(data){
			alert('删除成功');
			$('#C'+id).hide();
		});	
	}
	
}
</script>
</html>