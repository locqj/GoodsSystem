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
	普通用户管理sad
	<ul>
		<c:forEach var="list" items="${users}">

			<li>
				<tr>${list.id}</tr>
				<tr>${list.name}</tr>
				<tr><button onclick="del(${list.id})">删除</button></tr>
			</li>

		</c:forEach>
	</ul>
</body>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
function del(id) {
	$.post('del', {id: id}, function(data){
		alert("ok")
	});
}

</script>
</html>