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
	易耗品种类查看 建立


	<form action="toaddcategory" method="post" onsubmit="return check()">
		<p>
			类别名： <input name="name" type="text" id="categoryname">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<hr>
	<ul>
		<c:forEach var="list" items="${categorys}">

			<li id="C${list.id}">
				<tr>${list.id}</tr>
				<tr>${list.name}</tr>
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
	if($('#categoryname').val() == ""){ 
		alert("请输入类目名"); 
		document.getElementById("categoryname").focus; 
		return false;//false:阻止提交表单 
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