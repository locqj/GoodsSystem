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
	易耗品申請
	<form action="toaddgoodlog" method="post" onsubmit="return check()">
		<p>	
			易耗品： <select id="sel_good_code">
				<option value="0">请选择</option>
				<c:forEach var="list" items="${good}">
					<option value="${list.code}T${list.num}">${list.name}</option>
				</c:forEach>
			</select>
			<input type="hidden" name="good_code" value="0" id="good_code">
		</p>
		<p id="num_text">
		</p>
		<p>
			数目： <input name="good_num" type="number" id="good_num">
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
	<hr>
		<ul>
		<tr>ID</tr>
		<tr>消耗品名</tr>
		<tr>申请数目</tr>
		<tr>申请状态</tr>
		<c:forEach var="list" items="${goodlogs}">

			<li id="C${list.id}">
				<tr>${list.id}</tr>
				<tr>${list.good.name}</tr>
				<tr>${list.num}</tr>
				<tr>
					<c:choose>
   						<c:when test="${list.status == 1}">  
         					已通过
   						</c:when>
   					<c:otherwise> 
   						待审核
   					</c:otherwise>
					</c:choose>		
				</tr>
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
	var num = 0;
	function check() {
		num = parseInt(num);
		if ($('#good_code').val() == 0) {
			alert("请选择消耗品");
			return false;
		} else if ($("#good_num").val() == "") {
			alert("请输入数目");
			return false;
		} else if($("#good_num").val() < 0){
			alert("数目不得大于零");
			return false;
		} else if ($("#good_num").val() > num) {
			alert("填写数目超过最大额度");
			return false;
		}
		return true;
	}
	function del(id) {
		var r = confirm("确定删除吗？");
		if (r) {
			$.post('del', {
				id : id
			}, function(data) {
				alert('删除成功');
				$('#C' + id).hide();
			});
		}

	}
	$("#sel_good_code").change(function() {
		var arr = $(this).val().split('T');
		num = arr[1];
		$("#good_code").val(arr[0]);
		$("#num_text").text("该消耗品当前总量为："+arr[1]);
		$("#num_text").show();
	})
</script>
</html>